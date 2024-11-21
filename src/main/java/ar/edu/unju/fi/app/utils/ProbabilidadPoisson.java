package ar.edu.unju.fi.app.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ProbabilidadPoisson {

    private ProbabilidadPoisson() {
    }

    public static Double calcularProbabilidad(Double lambda, Integer k) {
        double lambdaElevedadoK = Math.pow(lambda, k);  // Calcular lambda^k
        double eElevadoAMenosLambda = Math.exp(-lambda);// Calcular e^(-lambda)
        long factorialK = factorial(k);// Calcular k!
        double resultado = (lambdaElevedadoK * eElevadoAMenosLambda) / factorialK;
        BigDecimal resultadoRedondeado = new BigDecimal(resultado).setScale(4, RoundingMode.HALF_UP);
        return resultadoRedondeado.doubleValue();
    }

    public static Long factorial(int k) {
        long resultado = 1;
        for (int i = 1; i <= k; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static List<Double> calcularProbabilidades(Double lambda){
        List<Double> probabilidades = new ArrayList<Double>();
        List<Integer> clientes = generarClientes();
        for(Integer cliente : clientes)
            probabilidades.add(calcularProbabilidad(lambda, cliente));
        return probabilidades;
    }

    private static List<Integer> generarClientes() {
        List<Integer> clientes = new ArrayList<>();
        clientes.add(0);
        clientes.add(1);
        clientes.add(2);
        clientes.add(3);
        clientes.add(4);
        clientes.add(5);
        clientes.add(6);
        return clientes;
    }
}
