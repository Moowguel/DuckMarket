package br.com.fiap.View.Cadastro;

import br.com.fiap.View.Main;
import br.com.fiap.dao.CriptoativoDao;
import br.com.fiap.model.Criptoativo;

import java.sql.SQLException;
import java.util.Scanner;

public class CadastroCriptoativoView {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){

            try {

                System.out.println("=======CADASTRO DE CRIPTOATIVO=======");
                System.out.println("Bem vindo ao Cadastro de Criptoativo!");

                CriptoativoDao dao = new CriptoativoDao();
                System.out.println("Digite o Nome da Criptomoeda");
                String nomeCripto = scanner.nextLine();
                System.out.println("Digite o simbolo da Criptomoeda");
                String simboloCripto = scanner.nextLine();
                System.out.println("Digite a variação");
                double variacao = scanner.nextDouble();
                System.out.println("Digite a Quantidade");
                double quantidade = scanner.nextDouble();
                System.out.println("Digite o preço unitario");
                double precoUnitario = scanner.nextDouble();

                Criptoativo criptoativo = new Criptoativo(nomeCripto, simboloCripto, variacao, quantidade, precoUnitario);
                dao.cadastrar(criptoativo);
                running = false;
                dao.fecharConexao();
                System.out.println("Criptoativo Cadastrado!");
                Main.main(null);
            } catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }

    }
}
