package dbConnection;

import java.sql.*;

public class FabricaConexao {

    private static Connection conn = null;

    public static Connection getConexao() {

        try {
            final String url = "jdbc:mysql://localhost/crud_jdbc?zeroDateTimeBehavior=convertToNull";
            final String user = "root";
            final String senha = "";

            return DriverManager.getConnection(url, user, senha);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConection(){
        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
