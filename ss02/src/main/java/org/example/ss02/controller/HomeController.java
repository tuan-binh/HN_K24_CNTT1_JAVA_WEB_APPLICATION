package org.example.ss02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home") // Ngõ 15 - HandlerMapping
public class HomeController {

    // Định nghĩa các Http method (GET | POST) // Ngách
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/home/cntt4";
    }

    @RequestMapping(value = "/cntt4", method = RequestMethod.GET)
    public String cntt4(Model model) {
        // Model để gửi dữ liệu sang view
        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Hoàng Cương Cát",
                        "Nguyễn Quang Vinh",
                        "Nguyễn Nhật Minh",
                        "Quách Văn Sơn Bách",
                        "Đinh Đình Thành"
                )
        );
        model.addAttribute("ds_cntt1", names);
        return "hn_cntt4";
    }

}
