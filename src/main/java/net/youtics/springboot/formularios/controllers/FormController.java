package net.youtics.springboot.formularios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model)
    {
        model.addAttribute("titulo", "Crear Usuario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Model model,
                           @RequestParam (name="username") String username,
                           @RequestParam String password,
                           @RequestParam String email)
    {

        model.addAttribute("titulo", "Usuario");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        return "resultado";
    }
}