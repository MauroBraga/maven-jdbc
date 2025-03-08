package br.com.mrb.mavenrocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    private static Connection connection;

    public static void conectar()  {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            props.setProperty("ssl", "false");
            try {
                connection = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Conectado com sucesso!");
    }

    public static Connection getConnection() {
        return connection;
    }
}
