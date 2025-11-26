package prova.factory;

import prova.pessoa.Familia;
import prova.pessoa.Morador;

public class PessoaFactory {

    public static Familia criarFamilia(String resp, String cpf, String agente) {
        return new Familia(resp, cpf, agente);
    }

    public static Morador criarMorador(String nome, String cpf) {
        return new Morador(nome, cpf);
    }
}