package br.com.fiap.View.Pesquisa;
import br.com.fiap.View.Main;
import br.com.fiap.dao.CriptoativoDao;
import br.com.fiap.exception.ENEexception;
import br.com.fiap.model.Criptoativo;
import java.sql.SQLException;
import java.util.Scanner;

public class PesquisaCriptoativoView {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            try{
                System.out.println("Digite o código do Criptoativo que deseja pesquisar: ");
                int codCripto = scanner.nextInt();
                CriptoativoDao dao = new CriptoativoDao();

                Criptoativo criptoativo = dao.pesquisar(codCripto);
                System.out.println("NOME:" + criptoativo.getNomeCripto());
                System.out.println("Preço Unitário: "+criptoativo.getPrecoUnitario()+"| Váriação: "+ criptoativo.getVariacao()+" | Quantidade: "+ criptoativo.getQtdCriptoativo());
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
