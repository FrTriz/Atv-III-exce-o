import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaAcademico {
    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();
        Scanner scanner = new Scanner(System.in);

        try {
            List<Dependente> dependentes1 = new ArrayList<>();
            dependentes1.add(new Dependente("Pedro", 8, "Masculino"));

            List<Dependente> dependentes2 = new ArrayList<>();
            dependentes2.add(new Dependente("Joana", 5, "Feminino"));

            sistema.incluirProfessor(new Professor("Carlos Silva", 40, "Masculino", "11111111111", "RG1", "Rua 75", dependentes1));
            sistema.incluirProfessor(new Professor("Ana Souza", 35, "Feminino", "22222222222", "RG2", "Rua B", dependentes2));
            sistema.incluirProfessor(new Professor("Pedro Paulo", 50, "Masculino", "33333333333", "RG3", "Rua 35", new ArrayList<>()));
            sistema.incluirProfessor(new Professor("Julia Mendes", 30, "Feminino", "44444444444", "RG4", "Rua 60", new ArrayList<>()));
            sistema.incluirProfessor(new Professor("Roberto Campos", 45, "Masculino", "55555555555", "RG5", "Rua ", new ArrayList<>()));

            sistema.incluirProfessor(new Professor("Extra Professor", 40, "Masculino", "66666666666", "RG6", "Rua F", new ArrayList<>()));

        } catch (LimiteDeProfessoresException | ProfessorJaExistenteException e) {
            sistema.registrarErro(e.getMessage());
        } catch (Exception e) {
            sistema.registrarErro("Erro inesperado: " + e.getMessage());
        }

        try {
            sistema.excluirProfessor("22222222222");
            sistema.excluirProfessor("99999999999"); // CPF inexistente
        } catch (ProfessorNaoEncontradoException e) {
            sistema.registrarErro(e.getMessage());
        } catch (Exception e) {
            sistema.registrarErro("Erro inesperado: " + e.getMessage());
        }

        try {
            Professor professor = sistema.pesquisarProfessor("33333333333");
            System.out.println("Professor encontrado: " + professor);
        } catch (ProfessorNaoEncontradoException e) {
            sistema.registrarErro(e.getMessage());
        } catch (Exception e) {
            sistema.registrarErro("Erro inesperado: " + e.getMessage());
        }

        sistema.exibirMensagensDeErro();
        scanner.close();
    }
}

