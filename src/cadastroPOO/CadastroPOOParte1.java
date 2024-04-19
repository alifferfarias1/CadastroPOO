package cadastropoo;

import cadastropoo.model.*;

public class CadastroPOOParte1 {
    
    private final String pfFilePath;
    private final String pjFilePath;
    
    public CadastroPOOParte1() {
        this.pfFilePath = "resources/pf.dat";
        this.pjFilePath = "resources/pj.dat";
    }
    
    // Entry point for running the application
    public void run() {
        performPessoaFisicaTests();
        performPessoaJuridicaTests();
    }
    
    // Method to test PessoaFisica operations
    private void performPessoaFisicaTests() {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pf1 = new PessoaFisica(1, "Ana Maria", "128", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "João", "55", 52);
        
        repo1.inserir(pf1);
        repo1.inserir(pf2);
        repo1.persistir(pfFilePath);
        System.out.println("Pessoa Fisica data stored.");
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar(pfFilePath);
        System.out.println("Pessoa Fisica data retrieved.");
        
        for (PessoaFisica pf : repo2.obterTodos()) {
            pf.exibir();
        }
    }
    
    // Method to test PessoaJuridica operations
    private void performPessoaJuridicaTests() {
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridica pj1 = new PessoaJuridica(3, "X22", "3332");
        PessoaJuridica pj2 = new PessoaJuridica(4, "ZPT", "4442");
        
        repo3.inserir(pj1);
        repo3.inserir(pj2);
        repo3.persistir(pjFilePath);
        System.out.println("Pessoa Juridica data stored.");
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar(pjFilePath);
        System.out.println("Pessoa Juridica data retrieved.");
        
        for (PessoaJuridica pj : repo4.obterTodos()) {
            pj.exibir();
        }
    }
    
    // Entry point of the application
    public static void main(String[] args) {
        new CadastroPOOParte1().run();
    }
}
