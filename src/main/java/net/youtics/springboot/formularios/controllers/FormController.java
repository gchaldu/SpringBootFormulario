package net.youtics.springboot.formularios.controllers;

import jakarta.validation.Valid;
import net.youtics.springboot.formularios.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model)
    {
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Crear Usuario");
        model.addAttribute("user", usuario);
        return "form";
    }

    /** IMPORTANTE: para usar un BindigResult tenemos que hacerlo en el contexto de un @Valida
     * respentando el orden de: primero -> @Valid Usuario usuario, BindingResult result
     * primero el objeto a validar y luego el result
     * */
    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model)
    {
        model.addAttribute("titulo", "Resultado Usuario");
        if(result.hasErrors())
        {
            Map<String, String> errores = new HashMap<>();

            result.getFieldErrors().forEach(err->{
                errores.put(err.getField(), "El campo: " + err.getField() + " " + err.getDefaultMessage());
            });
            model.addAttribute("error", errores);
            return "form";
        }
        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
