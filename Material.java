public abstract class Material implements Exibivel {
    private String codigo;
    private String titulo;
    private int ano;
    private int quantidadeDisponivel;

    public Material(String codigo, String titulo, int ano, int quantidadeDisponivel) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    
    public void reduzirEstoque() {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
        }
    }

    public void aumentarEstoque() {
        quantidadeDisponivel++;
    }

    
    @Override
    public String exibirResumo() {
        return "Cód: " + codigo + " | Título: " + titulo + " | Estoque: " + quantidadeDisponivel;
    }

    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public String getTitulo() { return titulo; }
    public String getCodigo() { return codigo; }
}

