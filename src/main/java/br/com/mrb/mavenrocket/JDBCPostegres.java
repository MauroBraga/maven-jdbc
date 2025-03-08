package br.com.mrb.mavenrocket;

import java.sql.*;
import java.util.Properties;

public class JDBCPostegres {


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        props.setProperty("ssl", "false");
        Connection conn = DriverManager.getConnection(url, props);
        System.out.println("Conectado com sucesso!");

        String sql = "INSERT INTO tab_cadastro (nome, idade) VALUES (?,?)";
        String nome ="Mauro Braga";
        Integer idade = 18;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, idade);
        stmt.execute();
        stmt.close();
        System.out.println("Cadastrado com sucesso!");

    }
}
