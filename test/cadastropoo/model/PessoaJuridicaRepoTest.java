package cadastropoo.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class PessoaJuridicaRepoTest {

    private PessoaJuridicaRepo repo;

    @Before
    public void setUp() {
        // Initialize a new repository object before each test
        repo = new PessoaJuridicaRepo();
    }

    @Test
    public void testInserir() {
        // Test inserting a new PessoaJuridica
        PessoaJuridica pj = new PessoaJuridica(1, "Company A", "11111111111111");
        boolean inserted = repo.inserir(pj);
        assertTrue("Should insert the new PessoaJuridica", inserted);
        
        // Check that the PessoaJuridica is now in the repository
        PessoaJuridica retrievedPJ = repo.obter(1);
        assertEquals("Retrieved PessoaJuridica should match inserted", pj, retrievedPJ);
    }

    @Test
    public void testAlterar() {
        // Insert a PessoaJuridica to test updating
        PessoaJuridica pj = new PessoaJuridica(1, "Company A", "11111111111111");
        repo.inserir(pj);
        
        // Update PessoaJuridica details
        pj.setNome("Company B");
        pj.setCnpj("22222222222222");
        boolean updated = repo.alterar(pj);
        assertTrue("Should update the existing PessoaJuridica", updated);
        
        // Verify the updated details
        PessoaJuridica updatedPJ = repo.obter(1);
        assertEquals("Updated name should be 'Company B'", "Company B", updatedPJ.getNome());
        assertEquals("Updated CNPJ should be '22222222222222'", "22222222222222", updatedPJ.getCnpj());
    }

    @Test
    public void testExcluir() {
        // Insert a PessoaJuridica to test deletion
        PessoaJuridica pj = new PessoaJuridica(1, "Company A", "11111111111111");
        repo.inserir(pj);
        
        // Delete PessoaJuridica
        boolean deleted = repo.excluir(1);
        assertTrue("Should delete the existing PessoaJuridica", deleted);
        
        // Verify that PessoaJuridica no longer exists
        PessoaJuridica retrievedPJ = repo.obter(1);
        assertNull("PessoaJuridica should no longer exist", retrievedPJ);
    }

    @Test
    public void testObter() {
        // Insert a PessoaJuridica to test retrieval
        PessoaJuridica pj = new PessoaJuridica(1, "Company A", "11111111111111");
        repo.inserir(pj);
        
        // Retrieve the PessoaJuridica by ID
        PessoaJuridica retrievedPJ = repo.obter(1);
        assertEquals("Retrieved PessoaJuridica should match inserted", pj, retrievedPJ);
    }

    @Test
    public void testObterTodos() {
        // Insert multiple PessoaJuridica objects
        repo.inserir(new PessoaJuridica(1, "Company A", "22255555"));
        repo.inserir(new PessoaJuridica(2, "Company B", "5555555555"));
        
        // Retrieve all PessoaJuridica objects
        ArrayList<PessoaJuridica> allPJs = repo.obterTodos();
        assertEquals("Should return 2 PessoaJuridica objects", 2, allPJs.size());
    }

    @Test
    public void testPersistirAndRecuperar() throws Exception {
        // File path for testing
        String filename = "test_pj_repo.dat";

        // Insert a PessoaJuridica to persist
        PessoaJuridica pj = new PessoaJuridica(1, "Company A", "222555555");
        repo.inserir(pj);
        
        // Persist data to file
        repo.persistir(filename);
        
        // Clear the repository
        repo = new PessoaJuridicaRepo();
        
        // Recover data from file
        repo.recuperar(filename);
        
        // Verify data was recovered correctly
        PessoaJuridica retrievedPJ = repo.obter(1);
        assertEquals("Retrieved PessoaJuridica should match persisted", pj, retrievedPJ);
        
        // Clean up test file
        Files.deleteIfExists(new File(filename).toPath());
    }

    @Test
    public void testGetSerialVersionUID() {
        long expectedSerialVersionUID = 1L; // This should match the serialVersionUID of the class
        assertEquals(expectedSerialVersionUID, repo.getSerialVersionUID());
    }
}