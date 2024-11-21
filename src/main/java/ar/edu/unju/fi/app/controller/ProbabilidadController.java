package ar.edu.unju.fi.app.controller;

import ar.edu.unju.fi.app.model.ProbabilidadPoisson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProbabilidadController {

   @GetMapping("/probabilidad")
    public String calcularProbabilidad(Model model) {
       Double lambda = 1.17;
       Long maximo = 6L;
       Long minimo=0L;
       List<Double> probabilidades = ProbabilidadPoisson.calcularProbabilidades(lambda,maximo,minimo);
        model.addAttribute("probabilidades", probabilidades);
        return "index.html";
    }
}
