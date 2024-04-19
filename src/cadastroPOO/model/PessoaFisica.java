package cadastropoo.model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cpf;
    private int idade;
    
    // Default constructor
    public PessoaFisica() {
        this("", 0, "", 0);
    }
    
    // Constructor with cpf and idade
    public PessoaFisica(String cpf, int idade) {
        this(0, "", cpf, idade);
    }
    
    // Full parameterized constructor
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome); // Initialize the Pessoa part
        this.cpf = cpf;
        this.idade = idade;
    }
    
    // Getter for CPF
    public String getCpf() {
        return cpf;
    }

    // Setter for CPF
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter for idade
    public int getIdade() {
        return idade;
    }

    // Setter for idade
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    // Display information
    @Override
    public void exibir() {
        super.exibir(); // Display information from the base class
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }
    
    // Getter for serialVersionUID
    @Override
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}