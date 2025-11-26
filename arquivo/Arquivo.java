package prova.arquivo;
import prova.strategy.*;
import prova.pessoa.*;
import prova.usuarios.*;
import prova.relatorios.*;

import java.io.*;
import java.util.*;

public class Arquivo {

    private static Arquivo instancia;
    private static final String CAMINHO = "dados_usb.txt";

    private Arquivo() {}

    public static Arquivo getInstancia() {
        if (instancia == null)
            instancia = new Arquivo();
        return instancia;
    }

    
    public void salvar(SalvarStrategy estrategia) {
        try (FileWriter fw = new FileWriter(CAMINHO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(estrategia.gerarLinha());
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

 
    public List<Familia> carregarFamilias() {
        List<Familia> lista = new ArrayList<>();
        Familia atual = null;

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;

            while ((linha = br.readLine()) != null) {

                String[] p = linha.split(";");

                switch (p[0]) {
                    case "FAMILIA" -> {
                        atual = new Familia(p[1], p[2], p[3]);
                        lista.add(atual);
                    }
                    case "MORADOR" -> {
                        if (atual != null)
                            atual.adicionarMorador(new Morador(p[1], p[2]));
                    }
                }
            }

        } catch (Exception e) {}

        return lista;
    }

    public List<AgenteDeSaude> carregarAgentes() {
        List<AgenteDeSaude> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(";");
                if (p[0].equals("AGENTE"))
                    lista.add(new AgenteDeSaude(p[1]));
            }
        } catch (Exception e) {}

        return lista;
    }

    public List<Enfermeiro> carregarEnfermeiros() {
        List<Enfermeiro> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(";");
                if (p[0].equals("ENFERMEIRO"))
                    lista.add(new Enfermeiro(p[1]));
            }
        } catch (Exception e) {}

        return lista;
    }

    public List<Relatorio> carregarRelatorios() {
        List<Relatorio> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(";");
                if (p[0].equals("RELATORIO"))
                    lista.add(new Relatorio(p[1], p[2], p[3]));
            }
        } catch (Exception e) {}

        return lista;
    }
}

