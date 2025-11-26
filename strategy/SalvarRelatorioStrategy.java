package prova.strategy;

import prova.relatorios.Relatorio;

public class SalvarRelatorioStrategy implements SalvarStrategy {

    private Relatorio rel;

    public SalvarRelatorioStrategy(Relatorio r) {
        this.rel = r;
    }

    @Override
    public String gerarLinha() {
        return "RELATORIO;" + rel.getAutor() + ";" + rel.getFamilia() + ";" + rel.getDescricao();
    }
}