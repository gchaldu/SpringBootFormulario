package net.youtics.springboot.formularios.controllers;

import net.youtics.springboot.formularios.models.domain.Usuario;
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
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);

        model.addAttribute("titulo", "Usuario");
        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
