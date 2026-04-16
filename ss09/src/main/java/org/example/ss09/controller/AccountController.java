package org.example.ss09.controller;

import org.example.ss09.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
@SessionAttributes("dataLogin") // Hệ thống tự động lưu trữ
public class AccountController {

    List<Account> accounts = new ArrayList<>(
            Arrays.asList(
                    new Account(1L, "Atmin Trần", "trantriduong", "123456"),
                    new Account(2L, "Đăng Tyler", "tylertran", "123456"),
                    new Account(3L, "Tôn Hành Giả", "tonhanhgia", "123456")
            )
    );


    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String viewLogin(Model model) {
        model.addAttribute("dataLogin", new Account());
        return "form-login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @ModelAttribute(name = "dataLogin") Account account,
            Model model
    ) {
        // Logic tính năng đăng nhập
        // dùng stream filter để lọc ra acc nào có username và password giống với cái gửi lên

        Account dataLogin = accounts.stream()
                .filter(
                        a -> a.getUsername().equals(account.getUsername()) &&
                                a.getPassword().equals(account.getPassword())
                ).findFirst()
                .orElse(null);

        if (dataLogin == null) {
            model.addAttribute("error", "Username or password is incorrect");
            return "form-login";
        } else {
            System.out.println("Welcome: " + dataLogin.getFullName());
        }

        return "home";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // Thực hiện xoá session đi
        return "home";
    }

}
