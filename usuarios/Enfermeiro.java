package prova.usuarios;

public class Enfermeiro {

    private String nome;

    public Enfermeiro(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() { return nome; }
}