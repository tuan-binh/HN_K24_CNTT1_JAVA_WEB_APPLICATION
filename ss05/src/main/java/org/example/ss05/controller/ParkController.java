package org.example.ss05.controller;

import org.example.ss05.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class ParkController {

    List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person(1, "Trần Trí Dương", 20, false),
                    new Person(2, "Hoàng Văn Lương", 20, false),
                    new Person(3, "Trần Minh Quang", 20, true),
                    new Person(4, "Nguyễn Quang Vinh", 20, false)
            )
    );

    @GetMapping
    public String home(Model model) {
        model.addAttribute("persons", personList);
        return "park";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(
            @PathVariable(name = "id") int editId,
            Model model
    ) {
        Person personEdit = personList.stream()
                .filter(p -> p.getId() == editId)
                .findFirst()
                .orElse(null);
        model.addAttribute("personEdit", personEdit);
        return "edit";
    }

}
