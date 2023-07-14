package com.kino.spring6.autowired.context;

import com.kino.spring6.autowired.annotation.Bean;
import com.kino.spring6.autowired.annotation.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kino
 * @date 2023/7/12 11:52 PM
 */
public class Spring6AnnotationApplicationContext implements Spring6ApplicationContext{
    private Map<Class<?>, Object> beanMap = new HashMap<>();
    private String rootPath;
    @Override
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    public Spring6AnnotationApplicationContext(String referencePath) throws IOException {
        referencePath = referencePath.replaceAll("\\.", "/");
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(referencePath);
        while (urls.hasMoreElements()) {
            File filePath = new File(urls.nextElement().getFile());
            rootPath = filePath.getPath().substring(0, filePath.getPath().lastIndexOf(referencePath));
            loadBean(filePath);
        }
        loadDi();
    }

    private void loadDi() {
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> clazz = entry.getKey();
            Object obj = entry.getValue();

            for (Field field : clazz.getDeclaredFields()) {
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, beanMap.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void loadBean(File filePath) {
        File[] fileChildren = filePath.listFiles();
        for (File child : fileChildren) {
            if (child.isDirectory()) {
                loadBean(child);
            } else {
                String pathWithClass = child.getPath().substring(rootPath.length());
                if (pathWithClass.contains(".class")) {
                    String fullName = pathWithClass.replaceAll(".class", "").replaceAll("/", "\\.");
                    try {
                        Class<?> clazz = Class.forName(fullName);
                        if (!clazz.isInterface()) { // 不能对接口做 newInstance 操作
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                Constructor<?> constructor = clazz.getConstructor(); // 获取无参构造器创建对象
                                Object instance = constructor.newInstance();
                                if (clazz.getInterfaces().length > 0) {
                                    beanMap.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanMap.put(clazz, instance);
                                }
                            }
                        }
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                             NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
