public class Livro extends Material {
    private String autor;

    public Livro(String codigo, String titulo, int ano, int qtd, String autor) {
        super(codigo, titulo, ano, qtd);
        this.autor = autor;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + " | Autor: " + autor;
    }
}