package cntt1.ss13.controller;

import cntt1.ss13.model.Person;
import cntt1.ss13.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PersonController {
    private final IPersonRepository personRepository;

    // Hiển thị danh sách
    @GetMapping
    public String home(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "person-list";
    }

    @GetMapping("/add")
    public String viewAdd(Model model) {
        model.addAttribute("person", new Person());
        return "person-form";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute(name = "person") Person person
    ) {

        personRepository.save(person);

        return "redirect:/";
    }

}
