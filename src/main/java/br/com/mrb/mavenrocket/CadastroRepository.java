package br.com.mrb.mavenrocket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection connection;
    PreparedStatement stmt;

    public CadastroRepository() {
        connection = FabricaConexao.getConnection();
    }

    public void incluir(Cadastro cadastro) {
        String sql = "INSERT INTO tab_cadastro (nome, idade) VALUES (?,?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getIdade());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Cadastro cadastro) {
        String sql = "UPDATE  tab_cadastro set nome= ?, idade = ? where id_serial = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getIdade());
            stmt.setInt(3, cadastro.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void excluir(Integer id) {
        String sql = "DELETE from  tab_cadastro   where id_serial = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Cadastro> listar(){
        String sql = "SELECT * from  tab_cadastro ";
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Cadastro> cadastros = new ArrayList<>();
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setId(rs.getInt("id_serial"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setIdade(rs.getInt("idade"));
                cadastros.add(cadastro);
            }
            return cadastros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Cadastro buscar(Integer id) {
        String sql = "SELECT * from  tab_cadastro where id_serial = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Cadastro cadastro = new Cadastro();
            if (rs.next()) {

                cadastro.setId(rs.getInt("id_serial"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setIdade(rs.getInt("idade"));

            }
            return cadastro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
