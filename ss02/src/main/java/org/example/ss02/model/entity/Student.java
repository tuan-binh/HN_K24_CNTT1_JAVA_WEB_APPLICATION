package org.example.ss02.model.entity;

public class Student {
    private int id;
    private String fullName;
    private String department;
    private int yearOfStudy;
    private double avgScore;

    public Student() {
    }

    public Student(int id, String fullName, String department, int yearOfStudy, double avgScore) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
        this.avgScore = avgScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}
