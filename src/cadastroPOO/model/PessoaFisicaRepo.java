package cadastropoo.model;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaFisicaRepo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PessoaFisicaRepo.class.getName());
    
    private ArrayList<PessoaFisica> pessoasFisicas;

    // Constructor
    public PessoaFisicaRepo() {
        this.pessoasFisicas = new ArrayList<>();
    }
    
    // Method to insert a new PessoaFisica object
    public boolean inserir(PessoaFisica pf) {
        if (pessoasFisicas.contains(pf)) {
            return false;
        }
        return pessoasFisicas.add(pf);
    }
        
    // Method to modify an existing PessoaFisica object
    public boolean alterar(PessoaFisica pf) {
        int index = pessoasFisicas.indexOf(pf);
        if (index != -1) {
            pessoasFisicas.set(index, pf);
            return true;
        }
        return false;
    }
    
    // Method to remove a PessoaFisica by ID
    public boolean excluir(int id) {
        PessoaFisica pfToRemove = obter(id);
        if (pfToRemove != null) {
            return pessoasFisicas.remove(pfToRemove);
        }
        return false;
    }
    
    // Method to obtain a PessoaFisica by ID
    public PessoaFisica obter(int id) {
        return pessoasFisicas.stream()
                             .filter(pf -> pf.getId() == id)
                             .findFirst()
                             .orElse(null);
    }
    
    // Method to obtain all PessoaFisica objects
    public ArrayList<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas);
    }
    
    // Method to persist the data to a file
    public void persistir(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(pessoasFisicas);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to persist data: " + e.getMessage(), e);
        }
    }
    
    // Method to recover the data from a file
    public void recuperar(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, "Class not found during recovery: " + e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to recover data: " + e.getMessage(), e);
        }
    }
    
    // Getter for serialVersionUID (Optional, but included for completeness)
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}
