package application;

import Commands.Atualizar;
import Commands.Consultar;
import Commands.Deletar;
import Commands.Inserir;
import entities.User;

import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {


        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        int escolha = 0;
        while (escolha != 6){

            StringBuilder sb = new StringBuilder();
            System.out.println("Meu CRUD JDBC");
            sb.append("\n");
            sb.append("***** Escolha uma opção! *****");
            sb.append("\n");
            sb.append("1 - Inserir");
            sb.append("\n");
            sb.append("2 - Atualizar");
            sb.append("\n");
            sb.append("3 - Deletar");
            sb.append("\n");
            sb.append("4 - Consultar");
            sb.append("\n");
            sb.append("5 - Nova funcionalidade");
            sb.append("\n");
            sb.append("6 - Fechar");
            System.out.println(sb);
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch(escolha){
                case 1:
                    System.out.println("-----  Inserir  -----");
                    System.out.println("Nome:");
                    String nome = entrada.nextLine();
                    System.out.println("Email:");
                    String email = entrada.nextLine();
                    System.out.println("Endereço:");
                    String endereco = entrada.nextLine();
                    System.out.println("Data de nascimento: (dd/mm/aaaa)");
                    String dataNacimento = entrada.nextLine();
                    Inserir.inserirUser(nome, email, endereco, dataNacimento);
                    System.out.println("Usuário inserido com sucesso!");
                    System.out.println();
                    escolha = 0;
                    break;
                case 2:
                    System.out.println("-----  Atualizar  -----");
                    System.out.println();
                    Consultar.consultarUsers();
                    System.out.println("Digite um ID");
                    int idUser = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = entrada.nextLine();
                    System.out.println("novo Email:");
                    String novoEmail = entrada.nextLine();
                    System.out.println("Novo Endereço:");
                    String novoEndereco = entrada.nextLine();
                    System.out.println("Nova Data de Nascimento");
                    String novaData = entrada.nextLine();
                    Atualizar.atualizarUser(novoNome, novoEmail, novoEndereco, novaData, idUser);
                    System.out.println("Usuário atualizado com sucesso!");
                    escolha = 0;
                    break;
                case 3:
                    System.out.println("-----  Deletar  -----");
                    System.out.println();
                    Consultar.consultarIds();
                    System.out.println("Qual User você deseja deletar?");
                    int id = entrada.nextInt();
                    Deletar.deletarUsuario(id);
                    System.out.println("Usuário deletado com sucesso!");
                    escolha = 0;
                    break;
                case 4:
                    System.out.println("-----  Consultar  -----");
                    System.out.println();
                    Consultar.consultarUsers();
                    escolha = 0;
                    break;
                case 5:
                    List<User> users = Atualizar.pesquisaNome();

                    if (users.size() > 0){
                        int y = users.size();
                        System.out.println("Foram encontrados " + y + " registros");
                        for(User user: users){
                            System.out.println("ID: " + user.getId());
                            System.out.println("Nome; " + user.getNome());
                            System.out.println("Email: " + user.getEmail());
                            System.out.println("Endereco: " + user.getEndereco());
                            System.out.println("Data Nascimento: " + user.getDataNascimento());
                            System.out.println("-----------------------------");
                        }
                    }else{
                        System.out.println("Nenhum registro encontrado");
                    }

                    escolha = 0;
                    break;
                case 6:
                    System.out.println("SAINDO....");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }
        entrada.close();
    }
}
