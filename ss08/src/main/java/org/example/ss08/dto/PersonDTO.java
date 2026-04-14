package org.example.ss08.dto;

import jakarta.validation.constraints.*;
import org.example.ss08.validation.EmailExist;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PersonDTO {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Min(value = 18, message = "Chưa đủ 18 tuổi")
    private Integer age;

    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean gender;

    @Past(message = "Không được chọn ngày tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Email(message = "Email không đúng định dạng")
    @EmailExist
    private String email;

    public PersonDTO() {
    }

    public PersonDTO(String name, Integer age, Boolean gender, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
