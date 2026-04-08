public class Aluno extends Usuario {
    public Aluno(String codigo, String nome, String email) {
        super(codigo, nome, email);
    }

    @Override
    public int getLimiteEmprestimos() { return 3; }

    @Override
    public int getPrazoDevolucao() { return 7; }

    @Override
    public double getValorMultaDiaria() { return 2.50; }
}