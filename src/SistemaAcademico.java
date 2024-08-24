import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private List<Professor> professores;
    private List<String> mensagensDeErro;

    public SistemaAcademico() {
        professores = new ArrayList<>();
        mensagensDeErro = new ArrayList<>();
    }

    public void incluirProfessor(Professor professor) throws LimiteDeProfessoresException, ProfessorJaExistenteException {
        if (professores.size() >= 5) {
            throw new LimiteDeProfessoresException("Limite de 5 professores atingido.");
        }
        for (Professor p : professores) {
            if (p.getCpf().equals(professor.getCpf())) {
                throw new ProfessorJaExistenteException("Professor com CPF " + professor.getCpf() + " já existe.");
            }
        }
        professores.add(professor);
        System.out.println("Professor incluído com sucesso.");
    }

    public void excluirProfessor(String cpf) throws ProfessorNaoEncontradoException {
        Professor professorAExcluir = null;
        for (Professor p : professores) {
            if (p.getCpf().equals(cpf)) {
                professorAExcluir = p;
                break;
            }
        }
        if (professorAExcluir == null) {
            throw new ProfessorNaoEncontradoException("Professor com CPF " + cpf + " não encontrado.");
        }
        professores.remove(professorAExcluir);
        System.out.println("Professor excluído com sucesso.");
    }

    public Professor pesquisarProfessor(String cpf) throws ProfessorNaoEncontradoException {
        for (Professor p : professores) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        throw new ProfessorNaoEncontradoException("Professor com CPF " + cpf + " não encontrado.");
    }

    public void registrarErro(String mensagem) {
        mensagensDeErro.add(mensagem);
    }

    public void exibirMensagensDeErro() {
        if (mensagensDeErro.isEmpty()) {
            System.out.println("Nenhuma mensagem de erro registrada.");
        } else {
            System.out.println("Mensagens de erro:");
            for (String msg : mensagensDeErro) {
                System.out.println(msg);
            }
        }
    }
}

