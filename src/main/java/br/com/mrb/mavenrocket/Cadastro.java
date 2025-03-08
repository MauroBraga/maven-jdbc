package br.com.mrb.mavenrocket;

public class Cadastro {
    private Integer id;
    private String nome;
    private Integer idade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
