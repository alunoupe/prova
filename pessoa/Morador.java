package prova.pessoa;

public class Morador {

    private String nome;
    private String cpf;

    public Morador(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return nome + " (" + cpf + ")";
    }
}