package prova.relatorios;

public class Relatorio {

    private String autor;
    private String familia;
    private String descricao;

    public Relatorio(String autor, String familia, String descricao) {
        this.autor = autor;
        this.familia = familia;
        this.descricao = descricao;
    }

    public String getAutor() { return autor; }
    public String getFamilia() { return familia; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return "Autor: " + autor + " | Família: " + familia + 
               "\nDescrição: " + descricao + "\n";
    }
}