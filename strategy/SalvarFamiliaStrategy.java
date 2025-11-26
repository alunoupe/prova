package prova.strategy;

import prova.pessoa.Familia;

public class SalvarFamiliaStrategy implements SalvarStrategy {

    private Familia familia;

    public SalvarFamiliaStrategy(Familia f) {
        this.familia = f;
    }

    @Override
    public String gerarLinha() {
        return "FAMILIA;" + familia.getResponsavel() + ";" + familia.getCpf() + ";" + familia.getAgente();
    }
}
