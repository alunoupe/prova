package prova.pessoa;

import java.util.ArrayList;
import java.util.List;

public class Familia {

    private String responsavel;
    private String cpf;
    private String agente;
    private List<Morador> moradores = new ArrayList<>();

    public Familia(String responsavel, String cpf, String agente) {
        this.responsavel = responsavel;
        this.cpf = cpf;
        this.agente = agente;
    }

    public void adicionarMorador(Morador m) {
        moradores.add(m);
    }

    public String getResponsavel() { return responsavel; }
    public String getCpf() { return cpf; }
    public String getAgente() { return agente; }
    public List<Morador> getMoradores() { return moradores; }

    @Override
    public String toString() {
        return "Responsável: " + responsavel + " | CPF: " + cpf + 
               " | Agente: " + agente + " | Moradores: " + moradores;
    }
}