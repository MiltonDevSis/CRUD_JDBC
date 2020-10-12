package Commands;

import dbConnection.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserir {

    public static void inserirUser(String nome, String email, String endereco, String dataNascimento){

        Connection conn;
        PreparedStatement stmt = null;

        try{
            conn = FabricaConexao.getConexao();

            String query = "insert into table_users (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";

            stmt = conn.prepareStatement(query);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, endereco);
            stmt.setString(4, dataNascimento);

            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            FabricaConexao.closeStatement(stmt);
            FabricaConexao.closeConection();
        }
    }
}
