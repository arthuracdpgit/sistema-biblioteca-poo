public class Main {
    public static void main(String[] args) {
        // 1. biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // 2. Cadastro: Usuários
        Usuario u1 = new Aluno("A10", "Arthur Azevedo", "arthur-azevedo@email.com");
        Usuario u2 = new Aluno("A11", "Beatriz Cavalcanti", "bia_cav@email.com");
        Usuario u3 = new Aluno("A12", "Thiago lopes", "thiagolopes@email.com");
        Usuario p1 = new Professor("P50", "Dr. RafaelRoque", "prof.rafael-roque@unicap.br");
        Usuario p2 = new Professor("P51", "Dr. Daniel Bezerra", "prof.daniel-bezerra@unicap.br");
        
        biblioteca.cadastrarUsuario(u1);
        biblioteca.cadastrarUsuario(u2);
        biblioteca.cadastrarUsuario(u3);
        biblioteca.cadastrarUsuario(p1);
        biblioteca.cadastrarUsuario(p2);

        // 3. Cadastro: Materiais
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

        // 4. Empréstimos Oks
        System.out.println("--- REALIZANDO EMPRÉSTIMOS ---");
        biblioteca.realizarEmprestimo(u1, m1); 
        biblioteca.realizarEmprestimo(u1, m4); 
        biblioteca.realizarEmprestimo(u2, m3);
        biblioteca.realizarEmprestimo(p1, m6);

        // 5. Limite de 3 itens por Aluno
        System.out.println("\n--- TESTANDO LIMITE DE ALUNO ---");
        Material extra1 = new Livro("L03", "Livro Extra 1", 2024, 5, "Autor X");
        Material extra2 = new Livro("L04", "Livro Extra 2", 2024, 5, "Autor Y");
        
        biblioteca.realizarEmprestimo(u1, extra1); // 3º item (OK)
        biblioteca.realizarEmprestimo(u2, extra2); // 4º item (DEVE DAR ERRO)

        // 6. Devoluções
        System.out.println("\n--- REGISTRANDO DEVOLUÇÕES ---");

        Emprestimo emp1 = biblioteca.getEmprestimos().get(0);
        emp1.registrarDevolucao(5);

        Emprestimo emp2 = biblioteca.getEmprestimos().get(2);
        emp2.registrarDevolucao(20); 

        biblioteca.listarEmprestimos();
        
        System.out.println("\n--- RESUMO DE MULTAS ---");
        System.out.println("Multa Arthur (no prazo): R$ " + emp1.calcularMulta());
        System.out.println("Multa Professor (atrasado): R$ " + emp2.calcularMulta());
    }
}