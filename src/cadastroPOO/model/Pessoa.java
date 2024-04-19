package cadastropoo.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;

    public Pessoa() {
        this(0, "");
    }
    
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for Nome
    public String getNome() {
        return nome;
    }

    // Setter for Nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // Method to display Pessoa's information
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }

    // Getter for serialVersionUID (Optional, but kept to match your request)
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}
