package org.example.ss09.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CookieController {

    // Bài toán cần lưu vào theme (chủ đề màu tối hoặc sáng)

    // thêm cookie
    @GetMapping("/set-theme")
    public String setTheme(
            // Lấy giá trị theme trên đường dẫn
            @RequestParam(name = "theme", defaultValue = "light") String mode,
            HttpServletResponse response
    ) {
        // Tạo ra cookie
        Cookie cookie = new Cookie("theme", mode);
        cookie.setMaxAge(2 * 60 * 60);

        // Thêm cookie vào trình duyệt
        response.addCookie(cookie);
        return "home";
    }

    // đọc cookie

    @GetMapping("/read-theme")
    public String readTheme(
            @CookieValue(name = "theme", defaultValue = "light") String theme,
            Model model
    ) {
        model.addAttribute("theme", theme);
        return "home";
    }

    // xoá cookie
    // Luồng của xoá cookie
    /**
     * Tạo ra 1 cookie giống tên cookie muốn xoá
     * SetMaxAge = 0
     * Response.addCookie(cookie)
     * */

}
