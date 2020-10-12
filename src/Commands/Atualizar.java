package Commands;

import dbConnection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Atualizar {

    public static void atualizarUser(String nome, String email, String endereco, String dataNascimento, int id){

        Connection conn;
        PreparedStatement stmt = null;

        try{
            conn = FabricaConexao.getConexao();

            String query = "UPDATE table_users SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE (id = ?)";

            stmt = conn.prepareStatement(query);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, endereco);
            stmt.setString(4, dataNascimento);
            stmt.setInt(5, id);

           int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Linhas afetadas: " + linhasAfetadas);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            FabricaConexao.closeStatement(stmt);
            FabricaConexao.closeConection();
        }
    }
}
