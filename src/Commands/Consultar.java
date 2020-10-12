package Commands;

import dbConnection.FabricaConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

    public static void consultarUsers(){

        try{
            Connection conn = FabricaConexao.getConexao();

            String query = "select * from table_users";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String data = rs.getString("dataNascimento");
                System.out.println("(Id " + id + " -> " + nome + ") \nEmail: " + email + "\nEndereço: " + endereco + "\nData de nascimento: " + data);
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void consultarIds(){

        try{
            Connection conn = FabricaConexao.getConexao();

            String query = "select * from table_users";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.println("Id " + id + " -> " + nome);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}