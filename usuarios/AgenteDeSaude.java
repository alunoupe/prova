package prova.usuarios;

public class AgenteDeSaude {

    private String nome;

    public AgenteDeSaude(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() { return nome; }
}