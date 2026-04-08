public class GeradorDados {
    public static void carregarBaseTeste(Biblioteca b) {
        
        b.cadastrarUsuario(new Aluno("A200", "Mariana Costa", "mari@email.com"));
        b.cadastrarUsuario(new Aluno("A201", "Lucas Mendes", "lucas@email.com"));
        
        
        b.cadastrarMaterial(new Livro("L50", "Clean Architecture", 2024, 5, "Uncle Bob"));
        b.cadastrarMaterial(new Livro("L51", "Refatoração", 2019, 2, "Martin Fowler"));
    }
}