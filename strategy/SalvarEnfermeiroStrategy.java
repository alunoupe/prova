package prova.strategy;

public class SalvarEnfermeiroStrategy implements SalvarStrategy {

    private String nome;

    public SalvarEnfermeiroStrategy(String nome) {
        this.nome = nome;
    }

    @Override
    public String gerarLinha() {
        return "ENFERMEIRO;" + nome;
    }
}