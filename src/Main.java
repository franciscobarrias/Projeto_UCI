import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorPacientes gestor = new GestorPacientes();

        // Carregar dados de ficheiros
        gestor.setPacientes(FicheiroPacientes.carregarPacientes());
        gestor.setTecnicos(FicheiroPacientes.carregarTecnicos());

        System.out.println("Total de pacientes carregados: " + gestor.getPacientes().size());
        System.out.println("Total de técnicos de saúde carregados: " + gestor.getTecnicos().size());

        int opcao;
        do {
            System.out.println("\n### MENU ###");
            System.out.println("1 - Adicionar novo paciente");
            System.out.println("2 - Adicionar novo Técnico de Saúde");
            System.out.println("3 - Listar pacientes ordenados por data de nascimento");
            System.out.println("4 - Listar Técnicos de Saúde ordenados por nome");
            System.out.println("5 - Atualizar sinais vitais de um paciente");
            System.out.println("6 - Estatísticas dos pacientes");
            System.out.println("7 - Guardar e sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    adicionarPaciente(scanner, gestor);
                    break;
                case 2:
                    adicionarTecnicoSaude(scanner, gestor);
                    break;
                case 3:
                    gestor.listarPacientesOrdenadosPorDataNascimento();
                    break;
                case 4:
                    gestor.listarTecnicosOrdenadosPorNome();
                    break;
                case 5:
                    atualizarSinaisVitais(scanner, gestor);
                    break;
                case 6:
                    exibirEstatisticas(gestor);
                    break;
                case 7:
                    FicheiroPacientes.guardarPacientes(gestor.getPacientes());
                    FicheiroPacientes.guardarTecnicos(gestor.getTecnicos());
                    System.out.println("Dados guardados. A sair...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    private static void adicionarPaciente(Scanner scanner, GestorPacientes gestor) {
        System.out.println("Nome do paciente:");
        String nome = scanner.nextLine();

        System.out.println("Data de nascimento (YYYY-MM-DD):");
        String dataNascimento = scanner.nextLine();

        System.out.println("Altura:");
        double altura = scanner.nextDouble();

        System.out.println("Peso:");
        double peso = scanner.nextDouble();

        double frequenciaCardiaca = lerValor(scanner, "Frequência Cardíaca:", 30, 220);
        double temperatura = lerValor(scanner, "Temperatura:", 30, 45);
        double saturacaoOxigenio = lerValor(scanner, "Saturação de Oxigénio:", 50, 100);
        scanner.nextLine();

        Paciente novoPaciente = new Paciente(nome, dataNascimento, altura, peso, frequenciaCardiaca, temperatura, saturacaoOxigenio);
        gestor.adicionarPaciente(novoPaciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    private static void adicionarTecnicoSaude(Scanner scanner, GestorPacientes gestor) {
        System.out.println("Nome do Técnico de Saúde:");
        String nome = scanner.nextLine();

        System.out.println("Data de nascimento (YYYY-MM-DD):");
        String dataNascimento = scanner.nextLine();

        System.out.println("Altura:");
        double altura = scanner.nextDouble();

        System.out.println("Peso:");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Categoria Profissional:");
        String categoriaProfissional = scanner.nextLine();

        TecnicoSaude novoTecnico = new TecnicoSaude(nome, dataNascimento, altura, peso, categoriaProfissional);
        gestor.adicionarTecnico(novoTecnico);
        System.out.println("Técnico de Saúde adicionado com sucesso!");
    }

    private static void atualizarSinaisVitais(Scanner scanner, GestorPacientes gestor) {
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = scanner.nextLine();
        boolean encontrado = false;

        for (Paciente p : gestor.getPacientes()) {
            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                System.out.println("Atualizando sinais vitais de " + p.getNome());

                double novaFrequencia = lerValor(scanner, "Nova Frequência Cardíaca:", 30, 220);
                double novaTemperatura = lerValor(scanner, "Nova Temperatura:", 30, 45);
                double novaSaturacao = lerValor(scanner, "Nova Saturação de Oxigénio:", 50, 100);
                scanner.nextLine();

                p.registarSinaisVitais(novaFrequencia, novaTemperatura, novaSaturacao);
                System.out.println("Sinais vitais atualizados! Nova classificação: " + p.classificarPaciente());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void exibirEstatisticas(GestorPacientes gestor) {
        System.out.println("\n### Estatísticas ###");
        System.out.println("Média da Frequência Cardíaca: " + Estatisticas.calcularMedia(gestor.getFrequenciasCardiacas()));
        System.out.println("Média da Temperatura: " + Estatisticas.calcularMedia(gestor.getTemperaturas()));
        System.out.println("Média da Saturação de Oxigénio: " + Estatisticas.calcularMedia(gestor.getSaturacoesOxigenio()));

        System.out.println("Mínimo da Frequência Cardíaca: " + Estatisticas.calcularMinimo(gestor.getFrequenciasCardiacas()));
        System.out.println("Máximo da Frequência Cardíaca: " + Estatisticas.calcularMaximo(gestor.getFrequenciasCardiacas()));

        System.out.println("Desvio Padrão da Frequência Cardíaca: " + Estatisticas.calcularDesvioPadrao(gestor.getFrequenciasCardiacas()));

        System.out.println("Percentagem de Pacientes Críticos: " + Estatisticas.calcularPercentagemCriticos(gestor.getPacientes()) + "%");
    }

    private static double lerValor(Scanner scanner, String mensagem, double min, double max) {
        double valor;
        do {
            System.out.println(mensagem);
            valor = scanner.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }
}
