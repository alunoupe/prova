package prova.factory;

import prova.relatorios.Relatorio;

public class RelatorioFactory {

    public static Relatorio criarRelatorio(String autor, String familia, String descricao) {
        return new Relatorio(autor, familia, descricao);
    }
}