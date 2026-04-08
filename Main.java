public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Usuario u1 = new Aluno("A10", "Arthur Azevedo", "arthur-azevedo@email.com");
        Usuario u2 = new Aluno("A11", "Beatriz Cavalcanti", "bia_cav@email.com");
        Usuario u3 = new Aluno("A12", "Thiago lopes", "thiagolopes@email.com");
        Usuario p1 = new Professor("P50", "Dr. Rafael Roque", "prof.rafael-roque@unicap.br");
        Usuario p2 = new Professor("P51", "Dr. Daniel Bezerra", "prof.daniel-bezerra@unicap.br");
        
        biblioteca.cadastrarUsuario(u1);
        biblioteca.cadastrarUsuario(u2);
        biblioteca.cadastrarUsuario(u3);
        biblioteca.cadastrarUsuario(p1);
        biblioteca.cadastrarUsuario(p2);

        Material m1 = new Livro("L99", "Algoritmos em C", 2018, 3, "Robert Sedgewick");
        Material m2 = new Livro("L88", "Banco de Dados NoSQL", 2021, 1, "Pramod Sadalage");
        Material m3 = new Livro("L77", "Inteligência Artificial", 2022, 2, "Stuart Russell");
        Material m4 = new Revista("R10", "Tech World Ed. 45", 2024, 10, 45);
        Material m5 = new Revista("R11", "Ciência Hoje", 2023, 4, 12);
        Material m6 = new Ebook("E05", "Segurança da Informação", 2023, 20, "EPUB");
        Material m7 = new Ebook("E06", "Docker para Iniciantes", 2022, 15, "PDF");

        biblioteca.cadastrarMaterial(m1);
        biblioteca.cadastrarMaterial(m2);
        biblioteca.cadastrarMaterial(m3);
        biblioteca.cadastrarMaterial(m4);
        biblioteca.cadastrarMaterial(m5);
        biblioteca.cadastrarMaterial(m6);
        biblioteca.cadastrarMaterial(m7);

        System.out.println("--- REALIZANDO EMPRÉSTIMOS VÁLIDOS ---");
        biblioteca.realizarEmprestimo(u1, m1); 
        biblioteca.realizarEmprestimo(u1, m4); 
        biblioteca.realizarEmprestimo(u1, m5); 
        biblioteca.realizarEmprestimo(p1, m6);

        System.out.println("\n--- ETAPA 6: TESTANDO TENTATIVA INVÁLIDA (ERRO FORÇADO) ---");
        biblioteca.realizarEmprestimo(u1, m7); 

        System.out.println("\n--- REGISTRANDO DEVOLUÇÕES ---");
        Emprestimo emp1 = biblioteca.getEmprestimos().get(0);
        emp1.registrarDevolucao(5);

        Emprestimo emp2 = biblioteca.getEmprestimos().get(3);
        emp2.registrarDevolucao(20); 

        biblioteca.listarEmprestimos();
        
        System.out.println("\n--- RESUMO DE MULTAS ---");
        System.out.println("Multa Arthur (no prazo): R$ " + String.format("%.2f", emp1.calcularMulta()));
        System.out.println("Multa Professor (atrasado): R$ " + String.format("%.2f", emp2.calcularMulta()));
    }
}