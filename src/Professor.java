import java.util.List;

public class Professor {
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private String rg;
    private String endereco;
    private List<Dependente> dependentes;

    public Professor(String nome, int idade, String sexo, String cpf, String rg, String endereco, List<Dependente> dependentes) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.dependentes = dependentes;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo +
                ", CPF: " + cpf + ", RG: " + rg + ", Endereço: " + endereco +
                ", Dependentes: " + dependentes;
    }
}
