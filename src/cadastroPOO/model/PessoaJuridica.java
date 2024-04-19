package cadastropoo.model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String cnpj;

    // Default constructor
    public PessoaJuridica() {
        this("", 0, "");
    }
    
    // Constructor with CNPJ
    public PessoaJuridica(String cnpj) {
        this(0, "", cnpj);
    }
    
    // Full parameterized constructor
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome); // Initialize Pessoa
        this.cnpj = cnpj;
    }

    // Getter for CNPJ
    public String getCnpj() {
        return cnpj;
    }

    // Setter for CNPJ
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Display PessoaJuridica's information
    @Override
    public void exibir() {
        super.exibir(); // Call the base class's exibir method
        System.out.println("CNPJ: " + cnpj);
    }

    // Getter for serialVersionUID (Optional, but included for completeness)
    @Override
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}
