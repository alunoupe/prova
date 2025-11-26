package prova.main;


import prova.arquivo.Arquivo;
import prova.arquivo.Arquivo;
import prova.factory.PessoaFactory;
import prova.factory.RelatorioFactory;
import prova.factory.UsuarioFactory;
import prova.usuarios.AgenteDeSaude;
import prova.usuarios.Enfermeiro;
import prova.pessoa.Familia;
import prova.pessoa.Morador;
import prova.relatorios.*;
import prova.strategy.SalvarAgenteStrategy;
import prova.strategy.SalvarEnfermeiroStrategy;
import prova.strategy.SalvarFamiliaStrategy;
import prova.strategy.SalvarMoradorStrategy;
import prova.strategy.SalvarRelatorioStrategy;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Arquivo arq = Arquivo.getInstancia();

        List<Familia> familias = arq.carregarFamilias();
        List<AgenteDeSaude> agentes = arq.carregarAgentes();
        List<Enfermeiro> enfermeiros = arq.carregarEnfermeiros();
        List<Relatorio> relatorios = arq.carregarRelatorios();

        boolean loop = true;

        while (loop) {

            System.out.println("\n=== SISTEMA USB ===");
            System.out.println("1. Cadastrar Família");
            System.out.println("2. Cadastrar Agente");
            System.out.println("3. Cadastrar Enfermeiro");
            System.out.println("4. Listar Famílias");
            System.out.println("5. Listar Agentes");
            System.out.println("6. Listar Enfermeiros");
            System.out.println("7. Adicionar Morador em Família");
            System.out.println("8. Criar Relatório");
            System.out.println("9. Ver Relatórios");
            System.out.println("10. Sair");
            System.out.print("Escolha: ");

            int op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1 -> {
                    System.out.print("Responsável: ");
                    String resp = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Agente responsável: ");
                    String agente = sc.nextLine();

                    Familia f = PessoaFactory.criarFamilia(resp, cpf, agente);
                    familias.add(f);

                    arq.salvar(new SalvarFamiliaStrategy(f));

                    System.out.println("Família cadastrada!");
                }

                case 2 -> {
                    System.out.print("Nome do agente: ");
                    String nome = sc.nextLine();

                    AgenteDeSaude a = UsuarioFactory.criarAgente(nome);
                    agentes.add(a);

                    arq.salvar(new SalvarAgenteStrategy(nome));

                    System.out.println("Agente cadastrado!");
                }

                case 3 -> {
                    System.out.print("Nome do enfermeiro: ");
                    String nome = sc.nextLine();

                    Enfermeiro e = UsuarioFactory.criarEnfermeiro(nome);
                    enfermeiros.add(e);

                    arq.salvar(new SalvarEnfermeiroStrategy(nome));

                    System.out.println("Enfermeiro cadastrado!");
                }

                case 4 -> {
                    System.out.println("\n=== FAMÍLIAS ===");
                    familias.forEach(System.out::println);
                }

                case 5 -> {
                    System.out.println("\n=== AGENTES ===");
                    agentes.forEach(System.out::println);
                }

                case 6 -> {
                    System.out.println("\n=== ENFERMEIROS ===");
                    enfermeiros.forEach(System.out::println);
                }

                case 7 -> {
                    System.out.print("Nome do responsável da família: ");
                    String nome = sc.nextLine();

                    Familia f = familias.stream()
                            .filter(x -> x.getResponsavel().equalsIgnoreCase(nome))
                            .findFirst().orElse(null);

                    if (f == null) {
                        System.out.println("Família não encontrada!");
                        break;
                    }

                    System.out.print("Nome do morador: ");
                    String mnome = sc.nextLine();

                    System.out.print("CPF: ");
                    String mcpf = sc.nextLine();

                    Morador m = PessoaFactory.criarMorador(mnome, mcpf);
                    f.adicionarMorador(m);

                    arq.salvar(new SalvarMoradorStrategy(m));

                    System.out.println("Morador adicionado!");
                }

                case 8 -> {
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Família visitada: ");
                    String fam = sc.nextLine();

                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();

                    Relatorio r = RelatorioFactory.criarRelatorio(autor, fam, desc);
                    relatorios.add(r);

                    arq.salvar(new SalvarRelatorioStrategy(r));

                    System.out.println("Relatório salvo!");
                }

                case 9 -> {
                    System.out.println("\n=== RELATÓRIOS ===");
                    relatorios.forEach(System.out::println);
                }

                case 10 -> loop = false;
            }
        }

        sc.close();
    }
}