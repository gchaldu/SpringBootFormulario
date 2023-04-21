package net.youtics.springboot.formularios.controllers;

import jakarta.validation.Valid;
import net.youtics.springboot.formularios.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
/*import org.springframework.web.bind.annotation.ModelAttribute;*/
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*import java.util.HashMap;
import java.util.Map;*/


@Controller
@SessionAttributes("usuario")
public class FormController {

    @GetMapping("/form")
    public String form(Model model)
    {
        Usuario usuario = new Usuario();
        usuario.setApellido("Chaldu");
        usuario.setNombre("Gabriel");
        usuario.setIdentificador("1.2-3");
        model.addAttribute("titulo", "Crear Usuario");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    /** IMPORTANTE: para usar un BindigResult tenemos que hacerlo en el contexto de un @Valida
     * respentando el orden de: primero -> @Valid Usuario usuario, BindingResult result
     * primero el objeto a validar y luego el result
     * */
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus sessionStatus)
    {
        model.addAttribute("titulo", "Resultado Usuario");
        if(result.hasErrors())
        {
            return "form";
        }
        model.addAttribute("usuario", usuario);
        /*limpia la session*/
        sessionStatus.setComplete();
        return "resultado";
    }
}
