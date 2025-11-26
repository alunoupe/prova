package prova.strategy;

public class SalvarAgenteStrategy implements SalvarStrategy {

    private String nome;

    public SalvarAgenteStrategy(String nome) {
        this.nome = nome;
    }

    @Override
    public String gerarLinha() {
        return "AGENTE;" + nome;
    }
}