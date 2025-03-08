package br.com.mrb.mavenrocket;

import java.util.List;
import java.util.Scanner;

public class SistemaCadastro {

    static CadastroRepository cadastroRepository;
    static Scanner ler;

    public static void main(String[] args) {
        FabricaConexao.conectar();
        cadastroRepository = new CadastroRepository();
        ler = new Scanner(System.in);
        Integer  operacao = 0;
        do {
            System.out.println("Selecione Uma Operação");
            System.out.printf("1 - Cadastrar, 2 Alterar, 3 Excluir, 4 Listar, 5 Find, 0 Sair");
            operacao = ler.nextInt();

            switch (operacao) {
                case 1:
                    salvar();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    buscar();
                    break;
                default:
                    break;
            }
        }while(operacao != 0);
      /*  cadastro.setNome("Mauro");
        cadastro.setIdade(30);
        cadastro.setId(3);
        cadastroRepository.excluir(3);*/

    }

    private static void buscar() {
        System.out.println("Buscar Usuário");
        System.out.printf("Digite Id");
        int id = ler.nextInt();
        Cadastro cadastro = cadastroRepository.buscar(id);
        System.out.println("Nome: "+cadastro.getNome());
        System.out.println("Idade: "+cadastro.getIdade());
    }

    private static void listar() {
        System.out.println("Listar Usuário");
        List<Cadastro> cadastros = cadastroRepository.listar();
        cadastros.forEach(cadastro -> {
            System.out.println("Nome: "+cadastro.getNome());
            System.out.println("Idade: "+cadastro.getIdade());
            System.out.println("###############################");
        });
    }

    private static void delete() {
        System.out.println("Delete Usuário");
        System.out.printf("Digite Id");
        int id = ler.nextInt();
        cadastroRepository.excluir(id);
    }

    private static void alterar() {
        System.out.println("Cadastrar Usuário");
        System.out.printf("Inserir Nome");
        String nome = ler.next();
        System.out.printf("Inserir Idade");
        int idade = ler.nextInt();
        System.out.printf("Digite Id");
        int id = ler.nextInt();
        Cadastro cadastro = new Cadastro();
        cadastro.setId(id);
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
        cadastroRepository.incluir(cadastro);
    }

    private static void salvar() {
        System.out.println("Cadastrar Usuário");
        System.out.printf("Inserir Nome");
        String nome = ler.next();
        System.out.printf("Inserir Idade");
        int idade = ler.nextInt();
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
        cadastroRepository.incluir(cadastro);
    }
}
