package com.kino.spring6.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author kino
 * @date 2023/7/11 11:04 PM
 */
public class Teacher {
    private Integer id;
    private String name;
    private Clazz clazz;  // 老师所教班级
    private String[] hobbies;
    private List<Student> students;
    private Map<String, Clazz> clazzMap;

    public Teacher() {
    }

    public Map<String, Clazz> getClazzMap() {
        return clazzMap;
    }

    public void setClazzMap(Map<String, Clazz> clazzMap) {
        this.clazzMap = clazzMap;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", students=" + students +
                ", clazzMap=" + clazzMap +
                '}';
    }
}
