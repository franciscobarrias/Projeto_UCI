/**
 * Representa um Paciente, que herda de Pessoa e implementa Monitorizacao.
 */
public class Paciente extends Pessoa implements Monitorizacao {
    private double frequenciaCardiaca;
    private double temperatura;
    private double saturacaoOxigenio;

    /**
     * Construtor da classe Paciente.
     * @param nome Nome do paciente.
     * @param dataNascimento Data de nascimento no formato YYYY-MM-DD.
     * @param altura Altura em metros.
     * @param peso Peso em kg.
     * @param frequenciaCardiaca Frequência cardíaca inicial.
     * @param temperatura Temperatura corporal inicial.
     * @param saturacaoOxigenio Saturação de oxigénio inicial.
     */
    public Paciente(String nome, String dataNascimento, double altura, double peso,
                    double frequenciaCardiaca, double temperatura, double saturacaoOxigenio) {
        super(nome, dataNascimento, altura, peso);
        this.frequenciaCardiaca = validarFrequenciaCardiaca(frequenciaCardiaca);
        this.temperatura = validarTemperatura(temperatura);
        this.saturacaoOxigenio = validarSaturacaoOxigenio(saturacaoOxigenio);
    }

    /**
     * Regista novos sinais vitais para o paciente, garantindo que estão dentro dos limites aceitáveis.
     * @param frequenciaCardiaca Nova frequência cardíaca.
     * @param temperatura Nova temperatura corporal.
     * @param saturacaoOxigenio Nova saturação de oxigénio.
     */
    @Override
    public void registarSinaisVitais(double frequenciaCardiaca, double temperatura, double saturacaoOxigenio) {
        this.frequenciaCardiaca = validarFrequenciaCardiaca(frequenciaCardiaca);
        this.temperatura = validarTemperatura(temperatura);
        this.saturacaoOxigenio = validarSaturacaoOxigenio(saturacaoOxigenio);
    }

    /**
     * Classifica o estado do paciente com base nos sinais vitais.
     * @return String com a classificação: "Crítico", "Atenção" ou "Normal".
     */
    public String classificarPaciente() {
        if (frequenciaCardiaca < 50 || frequenciaCardiaca > 130 ||
                temperatura < 35.5 || temperatura > 39.0 ||
                saturacaoOxigenio < 88) {
            return "Crítico";
        } else if ((frequenciaCardiaca >= 100 && frequenciaCardiaca <= 130) ||
                (temperatura >= 37.5 && temperatura <= 39.0) ||
                (saturacaoOxigenio >= 88 && saturacaoOxigenio < 92)) {
            return "Atenção";
        } else {
            return "Normal";
        }
    }

    /**
     * Retorna a frequência cardíaca do paciente.
     * @return Frequência cardíaca em bpm.
     */
    public double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    /**
     * Retorna a temperatura corporal do paciente.
     * @return Temperatura em °C.
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Retorna a saturação de oxigénio do paciente.
     * @return Saturação de oxigénio em %.
     */
    public double getSaturacaoOxigenio() {
        return saturacaoOxigenio;
    }

    /**
     * Representação textual do Paciente.
     * @return String formatada com os dados do paciente.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", FC: " + frequenciaCardiaca + " bpm, Temp: " + temperatura + "°C, SatO2: " + saturacaoOxigenio + "%";
    }

    /**
     * Valida a frequência cardíaca dentro dos limites aceitáveis.
     * @param fc Frequência cardíaca a validar.
     * @return Valor ajustado se necessário.
     */
    private double validarFrequenciaCardiaca(double fc) {
        if (fc < 30) return 30;
        if (fc > 220) return 220;
        return fc;
    }

    /**
     * Valida a temperatura dentro dos limites aceitáveis.
     * @param temp Temperatura a validar.
     * @return Valor ajustado se necessário.
     */
    private double validarTemperatura(double temp) {
        if (temp < 30) return 30;
        if (temp > 45) return 45;
        return temp;
    }

    /**
     * Valida a saturação de oxigénio dentro dos limites aceitáveis.
     * @param satO2 Saturação de oxigénio a validar.
     * @return Valor ajustado se necessário.
     */
    private double validarSaturacaoOxigenio(double satO2) {
        if (satO2 < 50) return 50;
        if (satO2 > 100) return 100;
        return satO2;
    }
}
