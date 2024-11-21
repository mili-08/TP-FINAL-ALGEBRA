package ar.edu.unju.fi.app.controller;

import ar.edu.unju.fi.app.utils.ProbabilidadPoisson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProbabilidadController {

   @GetMapping("/probabilidad")
    public String mostrarPagina(Model model) {
       Double lambda = 1.17;
       List<Double> probabilidades = ProbabilidadPoisson.calcularProbabilidades(lambda);
        model.addAttribute("probabilidades", probabilidades);
        return "tablaFrecuencia";
    }
}
