import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cálculo de estatísticas sobre os pacientes.
 */
public class Estatisticas {

    /**
     * Calcula a média dos valores fornecidos.
     * @param valores Lista de valores numéricos (exemplo: temperaturas, frequências cardíacas).
     * @return Média dos valores ou 0 se a lista estiver vazia.
     */
    public static double calcularMedia(List<Double> valores) {
        if (valores.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.size();
    }

    /**
     * Calcula o valor mínimo de uma lista de valores.
     * @param valores Lista de valores numéricos.
     * @return Valor mínimo encontrado ou 0 se a lista estiver vazia.
     */
    public static double calcularMinimo(List<Double> valores) {
        if (valores.isEmpty()) return 0;
        double minimo = valores.get(0);
        for (double valor : valores) {
            if (valor < minimo) {
                minimo = valor;
            }
        }
        return minimo;
    }

    /**
     * Calcula o valor máximo de uma lista de valores.
     * @param valores Lista de valores numéricos.
     * @return Valor máximo encontrado ou 0 se a lista estiver vazia.
     */
    public static double calcularMaximo(List<Double> valores) {
        if (valores.isEmpty()) return 0;
        double maximo = valores.get(0);
        for (double valor : valores) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        return maximo;
    }

    /**
     * Calcula o desvio padrão de uma lista de valores.
     * @param valores Lista de valores numéricos.
     * @return Desvio padrão dos valores ou 0 se a lista estiver vazia.
     */
    public static double calcularDesvioPadrao(List<Double> valores) {
        if (valores.isEmpty()) return 0;

        double media = calcularMedia(valores);
        double somaDiferencasQuadrado = 0;
        for (double valor : valores) {
            somaDiferencasQuadrado += Math.pow(valor - media, 2);
        }
        return Math.sqrt(somaDiferencasQuadrado / valores.size());
    }

    /**
     * Calcula a percentagem de pacientes classificados como "Crítico".
     * @param pacientes Lista de pacientes.
     * @return Percentagem de pacientes críticos ou 0 se a lista estiver vazia.
     */
    public static double calcularPercentagemCriticos(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            return 0;
        }
        int criticos = 0;
        for (Paciente p : pacientes) {
            if (p.classificarPaciente().equals("Crítico")) {
                criticos++;
            }
        }
        return (criticos * 100.0) / pacientes.size();
    }
}
