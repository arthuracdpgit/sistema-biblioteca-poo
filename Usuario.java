public abstract class Usuario implements Exibivel {
    private String codigo;
    private String nome;
    private String email;

    public Usuario(String codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public abstract int getLimiteEmprestimos();
    public abstract int getPrazoDevolucao();
    public abstract double getValorMultaDiaria();

    @Override
    public String exibirResumo() {
        return "Cód: " + codigo + " | Nome: " + nome + " | Email: " + email;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
}