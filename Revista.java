public class Revista extends Material {
    private int edicao;

    public Revista(String codigo, String titulo, int ano, int qtd, int edicao) {
        super(codigo, titulo, ano, qtd);
        this.edicao = edicao;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + " | Edição: " + edicao;
    }
}