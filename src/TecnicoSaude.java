/**
 * Representa um Técnico de Saúde.
 * Herda da classe Pessoa.
 */
public class TecnicoSaude extends Pessoa {
    private String categoriaProfissional;

    /**
     * Construtor da classe TecnicoSaude.
     * @param nome Nome do técnico.
     * @param dataNascimento Data de nascimento do técnico.
     * @param altura Altura do técnico.
     * @param peso Peso do técnico.
     * @param categoriaProfissional Categoria profissional do técnico.
     */
    public TecnicoSaude(String nome, String dataNascimento, double altura, double peso, String categoriaProfissional) {
        super(nome, dataNascimento, altura, peso);
        this.categoriaProfissional = categoriaProfissional;
    }

    /**
     * Obtém a categoria profissional do técnico.
     * @return Categoria profissional.
     */
    public String getCategoriaProfissional() {
        return categoriaProfissional;
    }

    /**
     * Retorna uma representação textual do Técnico de Saúde.
     * @return String formatada com os dados do técnico.
     */
    @Override
    public String toString() {
        return super.toString() + ", Categoria Profissional: " + categoriaProfissional;
    }
}

