public class Emprestimo implements Exibivel, CalculavelMulta {
    private Usuario usuario;
    private Material material;
    private int diasAtraso;
    private boolean devolvido;

    public Emprestimo(Usuario usuario, Material material) {
        this.usuario = usuario;
        this.material = material;
        this.diasAtraso = 0;
        this.devolvido = false;
    }

    public void registrarDevolucao(int diasEfetivos) {
        this.devolvido = true;
        int prazo = usuario.getPrazoDevolucao();
        
        if (diasEfetivos > prazo) {
            this.diasAtraso = diasEfetivos - prazo;
        } else {
            this.diasAtraso = 0;
        }
        material.aumentarEstoque();
    }

    @Override
    public double calcularMulta() {
        if (diasAtraso > 0) {
            return diasAtraso * usuario.getValorMultaDiaria();
        }
        return 0.0;
    }

    @Override
public String exibirResumo() {
    String status = devolvido ? "Devolvido" : "Em andamento";

    String multaFormatada = String.format("%.2f", calcularMulta());
    
    return "Usuário: " + usuario.getNome() + 
           " | Material: " + material.getTitulo() + 
           " | Status: " + status + 
           " | Multa: R$ " + multaFormatada;
}

    public Usuario getUsuario() { return usuario; }
    public boolean isDevolvido() { return devolvido; }
}
