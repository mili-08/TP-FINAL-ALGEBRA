package ar.edu.unju.fi.app.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ProbabilidadPoisson {

    private ProbabilidadPoisson() {
    }

    /**
     * Metodo que calcula la probabilidad de un valor de la variable aletoria
     * @param lambda
     * @param k : Representa el valor de la variable
     * @return Double
     */
    public static Double calcularProbabilidad(Double lambda, Long k) {
        double lambdaElevedadoK = Math.pow(lambda, k);  // Calcular lambda^k
        double eElevadoAMenosLambda = Math.exp(-lambda);// Calcular e^(-lambda)
        long factorialK = factorial(k);// Calcular k!
        double resultado = (lambdaElevedadoK * eElevadoAMenosLambda) / factorialK;
        BigDecimal resultadoRedondeado = new BigDecimal(resultado).setScale(4, RoundingMode.HALF_UP);
        return resultadoRedondeado.doubleValue();
    }

    /**
     * Metodo que calcula el factorial de un valor (K)
     * @param k
     * @return Long
     */
    public static Long factorial(Long k) {
        long resultado = 1;
        for (int i = 1; i <= k; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /**
     *
     * @param lambda
     * @param maximo
     * @param minimo
     * @return
     */
    public static List<Double> calcularProbabilidades(Double lambda, Long maximo, Long minimo){
        List<Double> probabilidades = new ArrayList<Double>();
        List<Long> clientes = generarClientes(maximo,minimo);
        for(Long cliente : clientes)
            probabilidades.add(calcularProbabilidad(lambda, cliente));
        return probabilidades;
    }

    /**
     * Metodo que permite generar una lista de los valores de las categorias
     * de la tabla de frecuencia de los datos analizados
     * @param maximo
     * @param minimo
     * @return List<Long>
     */
    private static List<Long> generarClientes(Long maximo,Long minimo) {
        List<Long> clientes = new ArrayList<>();
        for (Long i = minimo; i <= maximo; i++)
            clientes.add(i);
        return clientes;
    }
}
