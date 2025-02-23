package com.ltpo.crud;

import com.ltpo.crud.dao.UsuarioDAO;
import com.ltpo.crud.model.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int opcao;

        do {
            System.out.println("\n### Sistema de Gerenciamento de Usuários ###");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    usuarioDAO.criarUsuario(new Usuario(0, nome, email));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                case 2:
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    System.out.println("\nLista de Usuários:");
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail());
                    }
                    break;
                case 3:
                    System.out.print("ID do usuário a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    usuarioDAO.atualizarUsuario(new Usuario(idAtualizar, novoNome, novoEmail));
                    System.out.println("Usuário atualizado com sucesso!");
                    break;
                case 4:
                    System.out.print("ID do usuário a deletar: ");
                    int idDeletar = scanner.nextInt();
                    usuarioDAO.deletarUsuario(idDeletar);
                    System.out.println("Usuário deletado com sucesso!");
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }


}
