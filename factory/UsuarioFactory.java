package prova.factory;

import prova.usuarios.AgenteDeSaude;
import prova.usuarios.Enfermeiro;

public class UsuarioFactory {

    public static AgenteDeSaude criarAgente(String nome) {
        return new AgenteDeSaude(nome);
    }

    public static Enfermeiro criarEnfermeiro(String nome) {
        return new Enfermeiro(nome);
    }
}