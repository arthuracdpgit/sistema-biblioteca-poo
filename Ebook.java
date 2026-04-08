public class Ebook extends Material {
    private String formato; // Ex: PDF, EPUB

    public Ebook(String codigo, String titulo, int ano, int qtd, String formato) {
        super(codigo, titulo, ano, qtd);
        this.formato = formato;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + " | Formato: " + formato;
    }
}