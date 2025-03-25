import java.util.ArrayList;
import java.util.List;

public class GestorPacientes {
    private List<Paciente> pacientes;
    private List<TecnicoSaude> tecnicos;

    public GestorPacientes() {
        this.pacientes = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente p) {
        pacientes.add(p);
    }

    public void adicionarTecnico(TecnicoSaude t) {
        tecnicos.add(t);
    }

    public void listarPacientesOrdenadosPorDataNascimento() {
        pacientes.sort((p1, p2) -> p1.getDataNascimento().compareTo(p2.getDataNascimento()));
        for (Paciente p : pacientes) {
            System.out.println(p);
            System.out.println("Classificação: " + p.classificarPaciente());
        }
    }

    public void listarTecnicosOrdenadosPorNome() {
        tecnicos.sort((t1, t2) -> t1.getNome().compareToIgnoreCase(t2.getNome()));
        for (TecnicoSaude t : tecnicos) {
            System.out.println(t);
        }
    }

    public void setPacientes(List<Paciente> listaPacientes) {
        this.pacientes = new ArrayList<>(listaPacientes);
    }

    public void setTecnicos(List<TecnicoSaude> listaTecnicos) {
        this.tecnicos = new ArrayList<>(listaTecnicos);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<TecnicoSaude> getTecnicos() {
        return tecnicos;
    }

    public List<Double> getFrequenciasCardiacas() {
        List<Double> lista = new ArrayList<>();
        for (Paciente p : pacientes) {
            lista.add(p.getFrequenciaCardiaca());
        }
        return lista;
    }

    public List<Double> getTemperaturas() {
        List<Double> lista = new ArrayList<>();
        for (Paciente p : pacientes) {
            lista.add(p.getTemperatura());
        }
        return lista;
    }

    public List<Double> getSaturacoesOxigenio() {
        List<Double> lista = new ArrayList<>();
        for (Paciente p : pacientes) {
            lista.add(p.getSaturacaoOxigenio());
        }
        return lista;
    }
}


