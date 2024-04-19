package cadastropoo;

import cadastropoo.model.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.File;

public class CadastroPOOParte2 {
    
    private static final Logger LOGGER = Logger.getLogger(CadastroPOOParte2.class.getName());
    private static final String RESOURCE_DIRECTORY = "resources/";
    private Scanner inputScanner;
    private PessoaFisicaRepo pfRepository;
    private PessoaJuridicaRepo pjRepository;
    
    public CadastroPOOParte2() {
        inputScanner = new Scanner(System.in);
        pfRepository = new PessoaFisicaRepo();
        pjRepository = new PessoaJuridicaRepo();
    }
    
    private void run() {
        while (true) {
            printMenu();
            String choice = getStringInput("Choice: ");
            if (choice.equals("0")) {
                break;
            }
            handleChoice(choice);
        }
    }
    
    private void handleChoice(String choice) {
        switch (choice) {
            case "1":
                addPerson();
                break;
            case "2":
                modifyPerson();
                break;
            case "3":
                deletePerson();
                break;
            case "4":
                searchById();
                break;
            case "5":
                displayAllPeople();
                break;
            case "6":
                persistData();
                break;
            case "7":
                recoverData();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }
    
    private void addPerson() {
        System.out.println("Type of person to add: F - Pessoa Fisica | J - Pessoa Juridica");
        String personType = getStringInput("Choice: ").toUpperCase();
        
        if (personType.equals("F")) {
            PessoaFisica newPessoaFisica = createPessoaFisica();
            pfRepository.inserir(newPessoaFisica);
        } else if (personType.equals("J")) {
            PessoaJuridica newPessoaJuridica = createPessoaJuridica();
            pjRepository.inserir(newPessoaJuridica);
        } else {
            System.out.println("Error: Invalid choice!");
        }
    }
    
    private PessoaFisica createPessoaFisica() {
        int id = getIntInput("Enter Pessoa Fisica ID: ");
        String name = getStringInput("Enter Pessoa Fisica name: ");
        String cpf = getStringInput("Enter Pessoa Fisica CPF: ");
        int age = getIntInput("Enter Pessoa Fisica age: ");
        return new PessoaFisica(id, name, cpf, age);
    }
    
    private PessoaJuridica createPessoaJuridica() {
        int id = getIntInput("Enter Pessoa Juridica ID: ");
        String name = getStringInput("Enter Pessoa Juridica name: ");
        String cnpj = getStringInput("Enter Pessoa Juridica CNPJ: ");
        return new PessoaJuridica(id, name, cnpj);
    }
    
    private void modifyPerson() {
        System.out.println("Type of person to modify: F - Pessoa Fisica | J - Pessoa Juridica");
        String personType = getStringInput("Choice: ").toUpperCase();
        
        if (personType.equals("F")) {
            modifyPessoaFisica();
        } else if (personType.equals("J")) {
            modifyPessoaJuridica();
        } else {
            System.out.println("Error: Invalid choice!");
        }
    }
    
    private void modifyPessoaFisica() {
        int id = getIntInput("Enter Pessoa Fisica ID to modify: ");
        PessoaFisica pf = pfRepository.obter(id);
        if (pf != null) {
            pf.setNome(getStringInput("Enter new Pessoa Fisica name: "));
            pf.setCpf(getStringInput("Enter new Pessoa Fisica CPF: "));
            pf.setIdade(getIntInput("Enter new Pessoa Fisica age: "));
            pfRepository.alterar(pf);
            System.out.println("Pessoa Fisica updated successfully.");
        } else {
            System.out.println("ID not found!");
        }
    }
    
    private void modifyPessoaJuridica() {
        int id = getIntInput("Enter Pessoa Juridica ID to modify: ");
        PessoaJuridica pj = pjRepository.obter(id);
        if (pj != null) {
            pj.setNome(getStringInput("Enter new Pessoa Juridica name: "));
            pj.setCnpj(getStringInput("Enter new Pessoa Juridica CNPJ: "));
            pjRepository.alterar(pj);
            System.out.println("Pessoa Juridica updated successfully.");
        } else {
            System.out.println("ID not found!");
        }
    }
    
    private void deletePerson() {
        System.out.println("Type of person to delete: F - Pessoa Fisica | J - Pessoa Juridica");
        String personType = getStringInput("Choice: ").toUpperCase();
        
        if (personType.equals("F")) {
            int id = getIntInput("Enter Pessoa Fisica ID to delete: ");
            boolean isDeleted = pfRepository.excluir(id);
            System.out.println(isDeleted ? "Pessoa Fisica deleted successfully." : "ID not found.");
        } else if (personType.equals("J")) {
            int id = getIntInput("Enter Pessoa Juridica ID to delete: ");
            boolean isDeleted = pjRepository.excluir(id);
            System.out.println(isDeleted ? "Pessoa Juridica deleted successfully." : "ID not found.");
        } else {
            System.out.println("Error: Invalid choice!");
        }
    }
    
    private void searchById() {
        System.out.println("Type of person to search: F - Pessoa Fisica | J - Pessoa Juridica");
        String personType = getStringInput("Choice: ").toUpperCase();
        
        if (personType.equals("F")) {
            int id = getIntInput("Enter Pessoa Fisica ID to search: ");
            PessoaFisica pf = pfRepository.obter(id);
            if (pf != null) {
                pf.exibir();
            } else {
                System.out.println("ID not found!");
            }
        } else if (personType.equals("J")) {
            int id = getIntInput("Enter Pessoa Juridica ID to search: ");
            PessoaJuridica pj = pjRepository.obter(id);
            if (pj != null) {
                pj.exibir();
            } else {
                System.out.println("ID not found!");
            }
        } else {
            System.out.println("Error: Invalid choice!");
        }
    }
    
    private void displayAllPeople() {
        System.out.println("\nAll Pessoa Fisica:");
        for (PessoaFisica pf : pfRepository.obterTodos()) {
            pf.exibir();
        }
        System.out.println("\nAll Pessoa Juridica:");
        for (PessoaJuridica pj : pjRepository.obterTodos()) {
            pj.exibir();
        }
    }
    
    private void persistData() {
        String prefix = getStringInput("Enter file prefix: ");
        String pfFilename = RESOURCE_DIRECTORY + prefix + ".fisica.bin";
        String pjFilename = RESOURCE_DIRECTORY + prefix + ".juridica.bin";
        pfRepository.persistir(pfFilename);
        pjRepository.persistir(pjFilename);
        System.out.println("Data persisted successfully.");
    }
    
    private void recoverData() {
        String prefix = getStringInput("Enter file prefix: ");
        String pfFilename = RESOURCE_DIRECTORY + prefix + ".fisica.bin";
        String pjFilename = RESOURCE_DIRECTORY + prefix + ".juridica.bin";
        File pfFile = new File(pfFilename);
        File pjFile = new File(pjFilename);
        
        if (pfFile.exists() && pjFile.exists()) {
            pfRepository.recuperar(pfFilename);
            pjRepository.recuperar(pjFilename);
            System.out.println("Data recovered successfully.");
        } else {
            System.out.println("Invalid prefix. File not found.");
        }
    }
    
    private void printMenu() {
        System.out.println("\n==============================");
        System.out.println("1 - Add Person");
        System.out.println("2 - Modify Person");
        System.out.println("3 - Delete Person");
        System.out.println("4 - Search by ID");
        System.out.println("5 - Display All People");
        System.out.println("6 - Persist Data");
        System.out.println("7 - Recover Data");
        System.out.println("0 - Exit");
        System.out.println("==============================");
    }
    
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return inputScanner.nextLine();
    }
    
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = inputScanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
    
    public static void main(String[] args) {
        new CadastroPOOParte2().run();
    }
}
