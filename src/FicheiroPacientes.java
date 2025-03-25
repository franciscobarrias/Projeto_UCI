import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerir a leitura e escrita de pacientes e técnicos de saúde em ficheiros.
 */
public class FicheiroPacientes {

    private static final String FICHEIRO_PACIENTES = "pacientes.txt";
    private static final String FICHEIRO_TECNICOS = "tecnicos.txt";

    /**
     * Método para carregar pacientes a partir do ficheiro "pacientes.txt".
     * @return Lista de pacientes lidos do ficheiro.
     */
    public static List<Paciente> carregarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_PACIENTES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 7) {  // Verifica se há todas as colunas necessárias
                    String nome = dados[0];
                    String dataNascimento = dados[1];
                    double altura = Double.parseDouble(dados[2]);
                    double peso = Double.parseDouble(dados[3]);
                    double frequenciaCardiaca = Double.parseDouble(dados[4]);
                    double temperatura = Double.parseDouble(dados[5]);
                    double saturacaoOxigenio = Double.parseDouble(dados[6]);

                    Paciente p = new Paciente(nome, dataNascimento, altura, peso, frequenciaCardiaca, temperatura, saturacaoOxigenio);
                    pacientes.add(p);
                } else {
                    System.out.println("Linha inválida no ficheiro: " + linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum ficheiro de pacientes encontrado. Criando um novo...");
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro de pacientes.");
        }
        return pacientes;
    }

    /**
     * Método para guardar pacientes no ficheiro "pacientes.txt".
     * @param pacientes Lista de pacientes a serem guardados.
     */
    public static void guardarPacientes(List<Paciente> pacientes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHEIRO_PACIENTES))) {
            for (Paciente p : pacientes) {
                writer.println(p.getNome() + "," + p.getDataNascimento() + "," + p.getAltura() + "," +
                        p.getPeso() + "," + p.getFrequenciaCardiaca() + "," + p.getTemperatura() + "," +
                        p.getSaturacaoOxigenio());
            }
            System.out.println("Pacientes guardados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar o ficheiro de pacientes.");
        }
    }

    /**
     * Método para carregar técnicos de saúde a partir do ficheiro "tecnicos.txt".
     * @return Lista de técnicos de saúde lidos do ficheiro.
     */
    public static List<TecnicoSaude> carregarTecnicos() {
        List<TecnicoSaude> tecnicos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_TECNICOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {  // Verifica se há todas as colunas necessárias
                    String nome = dados[0];
                    String dataNascimento = dados[1];
                    double altura = Double.parseDouble(dados[2]);
                    double peso = Double.parseDouble(dados[3]);
                    String categoriaProfissional = dados[4];

                    TecnicoSaude t = new TecnicoSaude(nome, dataNascimento, altura, peso, categoriaProfissional);
                    tecnicos.add(t);
                } else {
                    System.out.println("Linha inválida no ficheiro: " + linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum ficheiro de técnicos encontrado. Criando um novo...");
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro de técnicos.");
        }
        return tecnicos;
    }

    /**
     * Método para guardar técnicos de saúde no ficheiro "tecnicos.txt".
     * @param tecnicos Lista de técnicos de saúde a serem guardados.
     */
    public static void guardarTecnicos(List<TecnicoSaude> tecnicos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHEIRO_TECNICOS))) {
            for (TecnicoSaude t : tecnicos) {
                writer.println(t.getNome() + "," + t.getDataNascimento() + "," + t.getAltura() + "," +
                        t.getPeso() + "," + t.getCategoriaProfissional());
            }
            System.out.println("Técnicos de saúde guardados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar o ficheiro de técnicos.");
        }
    }
}
