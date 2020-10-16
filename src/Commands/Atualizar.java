package Commands;

import dbConnection.FabricaConexao;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static List<User> pesquisaNome() throws SQLException {

        Scanner entrada = new Scanner(System.in);
        Connection conn = FabricaConexao.getConexao();

        List<User> users = new ArrayList<>();

        System.out.println("Informe um nome!");
        String nome = entrada.nextLine();

        String query = "SELECT * FROM table_users WHERE nome=?";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            user.setEndereco(rs.getString("endereco"));
            user.setDataNascimento(rs.getString("dataNascimento"));
            users.add(user);
        }
        stmt.close();
        rs.close();
        conn.close();
        return users;
    }
}
