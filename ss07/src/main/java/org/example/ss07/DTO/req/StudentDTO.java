package org.example.ss07.DTO.req;

import org.example.ss07.model.Gender;
import org.springframework.web.multipart.MultipartFile;

// MapStruct - tìm hiểu thêm về cái này
public class StudentDTO {
    private Long id;
    private String fullName;
    private Integer age;
    private Gender gender;
    private MultipartFile avatar;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String fullName, Integer age, Gender gender, MultipartFile avatar) {
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

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
