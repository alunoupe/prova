package prova.strategy;

import prova.pessoa.Morador;

public class SalvarMoradorStrategy implements SalvarStrategy {

    private Morador morador;

    public SalvarMoradorStrategy(Morador m) {
        this.morador = m;
    }

    @Override
    public String gerarLinha() {
        return "MORADOR;" + morador.getNome() + ";" + morador.getCpf();
    }
}