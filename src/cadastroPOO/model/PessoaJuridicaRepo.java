package cadastropoo.model;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaJuridicaRepo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PessoaJuridicaRepo.class.getName());
    
    private ArrayList<PessoaJuridica> pessoasJuridicas;

    // Constructor initializes an empty list of PessoaJuridica
    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }
    
    // Method to insert a new PessoaJuridica object
    public boolean inserir(PessoaJuridica pj) {
        return !pessoasJuridicas.contains(pj) && pessoasJuridicas.add(pj);
    }
    
    // Method to modify an existing PessoaJuridica object
    public boolean alterar(PessoaJuridica pj) {
        int index = pessoasJuridicas.indexOf(pj);
        if (index != -1) {
            pessoasJuridicas.set(index, pj);
            return true;
        }
        return false;
    }
    
    // Method to remove a PessoaJuridica by ID
    public boolean excluir(int id) {
        PessoaJuridica pjToRemove = obter(id);
        if (pjToRemove != null) {
            return pessoasJuridicas.remove(pjToRemove);
        }
        return false;
    }
    
    // Method to obtain a PessoaJuridica by ID
    public PessoaJuridica obter(int id) {
        return pessoasJuridicas.stream()
                               .filter(pj -> pj.getId() == id)
                               .findFirst()
                               .orElse(null);
    }
    
    // Method to obtain all PessoaJuridica objects
    public ArrayList<PessoaJuridica> obterTodos() {
        return new ArrayList<>(pessoasJuridicas);
    }
    
    // Method to persist the list of PessoaJuridica objects to a file
    public void persistir(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(pessoasJuridicas);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to persist data: " + e.getMessage(), e);
        }
    }
    
    // Method to recover the list of PessoaJuridica objects from a file
    public void recuperar(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) ois.readObject();
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

