import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Material> materiais = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarUsuario(Usuario u) { usuarios.add(u); }
    public void cadastrarMaterial(Material m) { materiais.add(m); }

    public void realizarEmprestimo(Usuario u, Material m) {

        if (m.getQuantidadeDisponivel() <= 0) {
            System.out.println("ERRO: Material '" + m.getTitulo() + "' sem estoque.");
            return;
        }

        int ativos = 0;
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().getCodigo().equals(u.getCodigo()) && !e.isDevolvido()) {
                ativos++;
            }
        }

        if (ativos >= u.getLimiteEmprestimos()) {
            System.out.println("ERRO: Usuário " + u.getNome() + " atingiu o limite de " + u.getLimiteEmprestimos() + " itens.");
            return;
        }

        m.reduzirEstoque();
        emprestimos.add(new Emprestimo(u, m));
        System.out.println("Sucesso: Empréstimo de '" + m.getTitulo() + "' para " + u.getNome() + " realizado.");
    }

    public void listarEmprestimos() {
        System.out.println("\n--- LISTA DE EMPRÉSTIMOS ---");
        for (Emprestimo e : emprestimos) {
            System.out.println(e.exibirResumo());
        }
    }

    public ArrayList<Emprestimo> getEmprestimos() { return emprestimos; }
}