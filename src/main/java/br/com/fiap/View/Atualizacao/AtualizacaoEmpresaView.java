package br.com.fiap.View.Atualizacao;

import br.com.fiap.View.Main;
import br.com.fiap.dao.EmpresaDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Empresa;

import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoEmpresaView {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                System.out.println("=======MENU DE ATUALIZACAO=======");
                System.out.println("Bem vindo a Atualizacao de Empresa!");;
                System.out.println("Qual id da Empresa que voce gostaria de alterar?");
                long codEmp = scanner.nextLong();
                scanner.nextLine();
                EmpresaDao dao = new EmpresaDao();
                Empresa empresa = dao.pesquisar(codEmp);
                System.out.println("Qual o novo nome?");
                String nome = scanner.nextLine();
                System.out.println("Qual o novo Saldo?");
                double saldo = scanner.nextDouble();
                System.out.println("Qual o novo Limite");
                double limite = scanner.nextDouble();

                empresa.setNomeConta(nome);
                empresa.setSaldo(saldo);
                empresa.setLimite(limite);

                dao.atualizar(empresa);
                running = false;
                System.out.println("Empresa Atualizada");
                Main.main(null);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            } catch (ENEexception e) {
                System.err.println("Produto não encontrado");
            }
        }


    }

}
