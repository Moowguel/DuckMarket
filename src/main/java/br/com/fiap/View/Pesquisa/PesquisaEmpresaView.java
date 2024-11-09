package br.com.fiap.View.Pesquisa;
import br.com.fiap.View.Main;
import br.com.fiap.dao.EmpresaDao;
import br.com.fiap.exception.ENEexception;

import br.com.fiap.model.Empresa;

import java.sql.SQLException;
import java.util.Scanner;

public class PesquisaEmpresaView {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                EmpresaDao dao = new EmpresaDao();
                System.out.println("Digite o codigo da Empresa que deseja pesquisar");
                int codEmpresa = scanner.nextInt();
                Empresa empresa = dao.pesquisar(codEmpresa);

                System.out.println("NOME:" + empresa.getNomeConta());
                System.out.println("Saldo: "+empresa.getSaldo()+"| Limite: "+ empresa.getLimite());
                dao.fecharConexao();
                running = false;
                Main.main(null);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (ENEexception e) {
                System.err.println("Codigo não existe na tabela.");
            }
        }
    }
}
