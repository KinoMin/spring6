package com.kino.spring6.autowired.context;

/**
 * @author kino
 * @date 2023/7/12 11:51 PM
 */
public interface Spring6ApplicationContext {
    Object getBean(Class<?> clazz);
}
