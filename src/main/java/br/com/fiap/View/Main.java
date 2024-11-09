package br.com.fiap.View;
import br.com.fiap.View.Atualizacao.AtualizacaoCriptoativoView;
import br.com.fiap.View.Atualizacao.AtualizacaoEmpresaView;
import br.com.fiap.View.Atualizacao.AtualizacaoTransacaoView;
import br.com.fiap.View.Atualizacao.AtualizacaoUsuarioView;
import br.com.fiap.View.Cadastro.CadastroCriptoativoView;
import br.com.fiap.View.Cadastro.CadastroEmpresaView;
import br.com.fiap.View.Cadastro.CadastroTransacaoView;
import br.com.fiap.View.Cadastro.CadastroUsuarioView;
import br.com.fiap.View.Listagem.ListagemCriptoativoView;
import br.com.fiap.View.Listagem.ListagemEmpresaView;
import br.com.fiap.View.Listagem.ListagemTransacaoView;
import br.com.fiap.View.Listagem.ListagemUsuarioView;
import br.com.fiap.View.Pesquisa.PesquisaCriptoativoView;
import br.com.fiap.View.Pesquisa.PesquisaEmpresaView;
import br.com.fiap.View.Pesquisa.PesquisaTransacaoView;
import br.com.fiap.View.Pesquisa.PesquisaUsuarioView;
import br.com.fiap.View.Remocao.RemocaoCriptoativoView;
import br.com.fiap.View.Remocao.RemocaoEmpresaView;
import br.com.fiap.View.Remocao.RemocaoTransacaoView;
import br.com.fiap.View.Remocao.RemocaoUsuarioView;

import java.util.Scanner;

/*

███╗░░░███╗░█████╗░░█████╗░░██╗░░░░░░░██╗░██████╗░██╗░░░██╗███████╗██╗░░░░░
████╗░████║██╔══██╗██╔══██╗░██║░░██╗░░██║██╔════╝░██║░░░██║██╔════╝██║░░░░░
██╔████╔██║██║░░██║██║░░██║░╚██╗████╗██╔╝██║░░██╗░██║░░░██║█████╗░░██║░░░░░
██║╚██╔╝██║██║░░██║██║░░██║░░████╔═████║░██║░░╚██╗██║░░░██║██╔══╝░░██║░░░░░
██║░╚═╝░██║╚█████╔╝╚█████╔╝░░╚██╔╝░╚██╔╝░╚██████╔╝╚██████╔╝███████╗███████╗
╚═╝░░░░░╚═╝░╚════╝░░╚════╝░░░░╚═╝░░░╚═╝░░░╚═════╝░░╚═════╝░╚══════╝╚══════╝

DuckMarket V2.0

 */


public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){

            System.out.println("=====Menu Principal=====");
            System.out.println("1. Cadastro");
            System.out.println("2. Atualizar cadastros");
            System.out.println("3. Pesquisar");
            System.out.println("4. Listar");
            System.out.println("5. Deletar");
            System.out.println("6. Sair");

            int mainChoice = scanner.nextInt();

            switch (mainChoice){
                case 1:
                    menuCadastro(scanner);
                break;
                case 2:
                    menuAtt(scanner);
                break;
                case 3:
                    menuPesquisa(scanner);
                break;
                case 4:
                    menuListar(scanner);
                break;
                case 5:
                    menuDelete(scanner);
                break;
                case 6:
                    running = false;
                    System.out.println("Saindo!");
                    scanner.close();
                break;

                default:System.out.println("Opção inválida! Tente novamente.");break;

            }

        }

    }

    private static void menuCadastro(Scanner scanner){
        boolean cadastroMenu = true;

        while (cadastroMenu){
            System.out.println("=====Menu de Cadastro=====");
            System.out.println("1. Cadastrar Criptoativo");
            System.out.println("2. Cadastrar Empresa");
            System.out.println("3. Cadastrar Transação");
            System.out.println("4. Cadastrar Usuario");
            System.out.println("5. Voltar ao Menu Principal");

            int cadastroChoice = scanner.nextInt();

            switch (cadastroChoice){

                case 1:
                    CadastroCriptoativoView.main(null);
                break;
                case 2:
                    CadastroEmpresaView.main(null);
                break;
                case 3:
                    CadastroTransacaoView.main(null);
                break;
                case 4:
                    CadastroUsuarioView.main(null);
                break;
                case 5:
                    cadastroMenu = false;
                break;

                default:System.out.println("Opção inválida! Tente novamente.");break;

            }
        }

    }

    private static void menuAtt(Scanner scanner){
        boolean attMenu = true;

        while (attMenu){
            System.out.println("=====Menu de Atualização=====");
            System.out.println("1. Atualizar Criptoativo");
            System.out.println("2. Atualizar Empresa");
            System.out.println("3. Atualizar Transação");
            System.out.println("4. Atualizar Usuario");
            System.out.println("5. Voltar ao Menu Principal");

            int attChoice = scanner.nextInt();

            switch (attChoice){

                case 1:
                    AtualizacaoCriptoativoView.main(null);
                    break;
                case 2:
                    AtualizacaoEmpresaView.main(null);
                    break;
                case 3:
                    AtualizacaoTransacaoView.main(null);
                    break;
                case 4:
                    AtualizacaoUsuarioView.main(null);
                    break;
                case 5:
                    attMenu = false;
                    break;

                default:System.out.println("Opção inválida! Tente novamente.");break;

            }
        }

    }

    private static void menuPesquisa(Scanner scanner){
        boolean pesquisaMenu = true;

        while (pesquisaMenu){
            System.out.println("=====Menu de Cadastro=====");
            System.out.println("1. Pesquisar Criptoativo");
            System.out.println("2. Pesquisar Empresa");
            System.out.println("3. Pesquisar Transação");
            System.out.println("4. Pesquisar Usuario");
            System.out.println("5. Voltar ao Menu Principal");

            int pesquisaChoice = scanner.nextInt();

            switch (pesquisaChoice){

                case 1:
                    PesquisaCriptoativoView.main(null);
                    break;
                case 2:
                    PesquisaEmpresaView.main(null);
                    break;
                case 3:
                    PesquisaTransacaoView.main(null);
                    break;
                case 4:
                    PesquisaUsuarioView.main(null);
                    break;
                case 5:
                    pesquisaMenu = false;
                    break;

                default:System.out.println("Opção inválida! Tente novamente.");break;

            }

        }
    }

    private static void menuListar(Scanner scanner){
        boolean listarMenu = true;

        while (listarMenu){
            System.out.println("=====Menu de Listagem=====");
            System.out.println("1. Listar Criptoativo");
            System.out.println("2. Listar Empresa");
            System.out.println("3. Listar Transação");
            System.out.println("4. Listar Usuario");
            System.out.println("5. Voltar ao Menu Principal");

            int listarChoice = scanner.nextInt();

            switch (listarChoice){

                case 1:
                    ListagemCriptoativoView.main(null);
                    break;
                case 2:
                    ListagemEmpresaView.main(null);
                    break;
                case 3:
                    ListagemTransacaoView.main(null);
                    break;
                case 4:
                    ListagemUsuarioView.main(null);
                    break;
                case 5:
                    listarMenu = false;
                    break;

                default:System.out.println("Opção inválida! Tente novamente.");break;

            }

        }
    }


    private static void menuDelete(Scanner scanner){
        boolean deleteMenu = true;

        while (deleteMenu){
            System.out.println("=====Menu de Cadastro=====");
            System.out.println("1. Deletar Criptoativo");
            System.out.println("2. Deletar Empresa");
            System.out.println("3. Deletar Transação");
            System.out.println("4. Deletar Usuario");
            System.out.println("5. Voltar ao Menu Principal");

            int deleteChoice = scanner.nextInt();

            switch (deleteChoice){

                case 1:
                    RemocaoCriptoativoView.main(null);
                    break;
                case 2:
                    RemocaoEmpresaView.main(null);
                    break;
                case 3:
                    RemocaoTransacaoView.main(null);
                    break;
                case 4:
                    RemocaoUsuarioView.main(null);
                    break;
                case 5:
                    deleteMenu = false;
                    break;

                default:System.out.println("Opção inválida! Tente novamente.");break;

            }

        }
    }

}
