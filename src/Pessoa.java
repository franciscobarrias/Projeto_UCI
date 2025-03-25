public class Pessoa {
    private String nome;
    private String dataNascimento;
    private double altura;
    private double peso;

    public Pessoa(String nome, String dataNascimento, double altura, double peso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Data de Nascimento: " + dataNascimento +
                ", Altura: " + altura + "m, Peso: " + peso + "kg";
    }
}


