package Commands;

import dbConnection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletar {

    public static void deletarUsuario(int id){

        Connection conn;
        PreparedStatement stmt = null;

        try {
            conn = FabricaConexao.getConexao();

            String query = "delete from table_users where id = ?";

            stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            FabricaConexao.closeStatement(stmt);
            FabricaConexao.closeConection();
        }
    }
}
