package org.example.ss02.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.ss02.model.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student-card")
public class StudentController {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Định Trọng An", "Công nghệ thông tin", 3, 8.5),
                    new Student(2, "Trần Minh Quang", "Kinh tế", 2, 7.2),
                    new Student(3, "Trần Trí Dương", "Du lịch", 4, 3.6)
            )
    );

    @GetMapping
    // Tham số phân biệt với đường dẫn thông qua dấu ? key=value
    public String studentCard(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("msv"));

        // Tìm sinh viên
        Student findStudent = students.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        // Gửi dữ liệu sinh viên qua
        model.addAttribute("student", findStudent);

        return "student-card";
    }

}
