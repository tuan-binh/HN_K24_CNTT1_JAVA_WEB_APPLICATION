package org.example.ss07.controller;

import org.example.ss07.DTO.req.StudentDTO;
import org.example.ss07.model.Gender;
import org.example.ss07.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1L, "Nguyễn Nhật Minh", 19, Gender.FEMALE, "nguyen_nhat_minh.png"),
                    new Student(2L, "Quách Văn Sơn Bách", 19, Gender.MALE, "quach_van_son_bach.png"),
                    new Student(3L, "Atmin Trần", 19, Gender.OTHER, "tran_tri_duong.png")
            )
    );

    @GetMapping
    public String home(Model model) {
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "form";
    }

    @PostMapping("/handle-add")
    public String handleAdd(
//            @RequestParam(name = "id") Long id,
//            @RequestParam(name = "fullName") String fullName,
//            @RequestParam(name = "age") Integer age,
//            @RequestParam(name = "gender") Gender gender
            @ModelAttribute(name = "student") StudentDTO student,
            Model model
    ) {

        String path = "D:\\RIKKEI\\HN-K24-CNTT1\\ss07\\src\\main\\webapp\\images\\";


        MultipartFile file = student.getAvatar();

        if (file.isEmpty()) {
            model.addAttribute("error", "File không tồn tại");
            return "result";
        }

        String fileName = file.getOriginalFilename();

        File insertFile = new File(path + fileName);

        try {
            file.transferTo(insertFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // DTO chuyển đổi từ request -> Entity (Model)
        Student newStudent = new Student(
                student.getId(),
                student.getFullName(),
                student.getAge(),
                student.getGender(),
                fileName
        );

        students.add(newStudent);
        return "redirect:/";
    }

    // Wrapper Class
    // Những kiểu dữ liệu nguyên thuỷ -> Đối tượng
    // VD: int --> Integer, long -> Long
    @GetMapping("/view-edit/{id}")
    public String viewEdit(
            @PathVariable(name = "id") Long editId,
            Model model
    ) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(editId))
                .findFirst()
                .orElse(null);

        model.addAttribute("student", student);
        return "form";
    }

}
