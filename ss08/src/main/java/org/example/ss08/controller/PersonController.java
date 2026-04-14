package org.example.ss08.controller;

import jakarta.validation.Valid;
import org.example.ss08.dto.PersonDTO;
import org.example.ss08.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Tìm hiểu RestController khác gì so với Controller
@Controller
@RequestMapping
public class PersonController {

    public static List<Person> luonGiuBinhTinh = new ArrayList<>(
            Arrays.asList(
                    new Person(
                            1L,
                            "Trần Trí D",
                            19,
                            true,
                            LocalDate.of(2008, 2, 17),
                            "d@gmail.com"
                    )
            )
    );

    @GetMapping
    public String home(Model model) {
        model.addAttribute("personList", luonGiuBinhTinh);
        return "person-list";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "person-form";
    }

    @PostMapping("/handle-submit")
    public String handleSubmit(
            @Valid @ModelAttribute(name = "personDTO") PersonDTO personDTO,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            model.addAttribute("personDTO", personDTO);
            return "person-form";
        }

        // Tìm id max xong ++;

        Person person = luonGiuBinhTinh.stream().max(Comparator.comparingLong(Person::getId)).orElse(null);

        Long newId = person == null ? 1 : person.getId() + 1;

        // Chuyển đổi từ DTO --> Model (Entity)
        Person newPerson = new Person(
                newId,
                personDTO.getName(),
                personDTO.getAge(),
                personDTO.getGender(),
                personDTO.getDateOfBirth(),
                personDTO.getEmail()
        );

        luonGiuBinhTinh.add(newPerson);
        return "redirect:/";
    }

}
