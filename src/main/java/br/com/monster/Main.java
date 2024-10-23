package br.com.monster;


import br.com.monster.DAO.DAO;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;
import br.com.monster.model.veiculo.Veiculo;
import br.com.monster.model.veiculo.Historico;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //declarando as variaveis nessesarias para o teste
        Cadastro cadastro = new Cadastro ("Test1","123","Test1@Test.com.br");
        Login test1 = new Login (cadastro);
        DAO conexao = new DAO ();

        //Teste Usuario
        //fazendo peimeiros teste da conexão com o banco de dados
        System.out.println ("FAZENDO PRIMEIRO TESTE DA CONEXÃO COM O BANCO DE DADOS");
        conexao.cadastro (cadastro);
        conexao.login (test1);
        conexao.getDados (test1);
        System.out.println ("=".repeat (40));
        //fazando o upudate dos dados
        System.out.println ("FAZENDO O UPDATE DOS DADOS");
        //test1.setCep ("03138-000");
        test1.setTelefone ("11999999999");
        conexao.updatetCep (test1);
        conexao.updateTel (test1);
        System.out.println ("GET DO CEO E TELEFONE INDIVIDUALEMNTE:");
        conexao.getCep (test1);
        conexao.getTel (test1);
        System.out.println ("=".repeat (40));
        System.out.println ("PEGANDO AS INFORMAÇÕES DO USUARIO DE TESTE");
        conexao.getDados (test1);
        System.out.println ("=".repeat (40));


        //Teste veiculo
        System.out.println ("CADASTRANDO VEICULOS");
        System.out.println ("=".repeat (40));
        Veiculo veiculo = new Veiculo ("a", "a", 2000, "a", test1.getId ());
        Veiculo veiculo2 = new Veiculo ("b", "b", 2020, "b", test1.getId ());
        conexao.cadastroVeiculo (veiculo);
        conexao.cadastroVeiculo (veiculo2);
        System.out.println ("=".repeat (40));
        System.out.println ("RESGATANDO LISTA DE VEICULOS");
        conexao.getListaVeiculo (test1);


        //Historico
        Scanner sc = new Scanner (System.in);
        System.out.println ("CADASTRANDO HISTORICO");
        System.out.println ("Escreva o id do veiculo com problema");
        int a = sc.nextInt ();
        Historico historico = new Historico ("Motor", a , "Falha no sistema de ignição após 5000 km de uso.");
        conexao.addHistorico (historico);
        System.out.println ("RESGATANDO LISTA DE HISTORICO DE PEOBLEMA");
        System.out.println ("Escreva o id do veiculo que deseja ver o historico");
        conexao.listaProblema(sc.nextInt ());


        //Deletando tudo
        System.out.println ("DELETANDO TUDO");
        System.out.println ("Escreva o ID do historico");
        conexao.deletarHistorico (sc.nextInt ());
        System.out.println ("Escreva o ID do veiculo");
        conexao.deletarVeiculo (sc.nextInt ());
        System.out.println ("Escreva o ID do veiculo");
        conexao.deletarVeiculo (sc.nextInt ());
        conexao.deletar (test1);



    }
}