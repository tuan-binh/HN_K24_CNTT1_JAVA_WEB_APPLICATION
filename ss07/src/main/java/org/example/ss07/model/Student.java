package org.example.ss07.model;

public class Student {
    private Long id;
    private String fullName;
    private Integer age;
    private Gender gender;
    private String avatar;

    public Student() {
    }

    public Student(Long id, String fullName, Integer age, Gender gender, String avatar) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
