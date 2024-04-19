package cadastropoo.model;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PessoaFisicaRepoTest {
    
    private PessoaFisicaRepo pessoaFisicaRepo;
    
    @Before
    public void setUp() {
        pessoaFisicaRepo = new PessoaFisicaRepo();
    }
    
    @After
    public void tearDown() {
        // Clean up resources if necessary
        pessoaFisicaRepo = null;
    }

    @Test
    public void testInserir() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "João", "12345678901", 30);
        boolean result = pessoaFisicaRepo.inserir(pessoaFisica);
        assertTrue("The insertion should succeed", result);
    }

    @Test
    public void testInserirDuplicate() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "João", "12345678901", 30);
        pessoaFisicaRepo.inserir(pessoaFisica);
        // Attempt to insert a duplicate entry
        boolean result = pessoaFisicaRepo.inserir(pessoaFisica);
        assertFalse("Insertion of duplicate should fail", result);
    }

    @Test
    public void testAlterar() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "João", "12345678901", 30);
        pessoaFisicaRepo.inserir(pessoaFisica);
        
        pessoaFisica.setNome("João Updated");
        pessoaFisica.setIdade(35);
        
        boolean result = pessoaFisicaRepo.alterar(pessoaFisica);
        assertTrue("The update should succeed", result);
        
        PessoaFisica updatedPessoaFisica = pessoaFisicaRepo.obter(1);
        assertEquals("João Updated", updatedPessoaFisica.getNome());
        assertEquals(35, updatedPessoaFisica.getIdade());
    }

    @Test
    public void testExcluir() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "João", "12345678901", 30);
        pessoaFisicaRepo.inserir(pessoaFisica);
        
        boolean result = pessoaFisicaRepo.excluir(1);
        assertTrue("The deletion should succeed", result);
        
        PessoaFisica deletedPessoaFisica = pessoaFisicaRepo.obter(1);
        assertNull("The PessoaFisica should be null after deletion", deletedPessoaFisica);
    }

    @Test
    public void testObter() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "João", "12345678901", 30);
        pessoaFisicaRepo.inserir(pessoaFisica);
        
        PessoaFisica result = pessoaFisicaRepo.obter(1);
        assertNotNull("Should return a valid PessoaFisica", result);
        assertEquals("João", result.getNome());
        assertEquals("12345678901", result.getCpf());
        assertEquals(30, result.getIdade());
    }

    @Test
    public void testObterTodos() {
        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "João", "656263565", 25);
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Maria", "87665612", 28);
        
        pessoaFisicaRepo.inserir(pessoaFisica1);
        pessoaFisicaRepo.inserir(pessoaFisica2);
        
        ArrayList<PessoaFisica> result = pessoaFisicaRepo.obterTodos();
        assertEquals("The size should be 2", 2, result.size());
        assertTrue("Should contain João", result.contains(pessoaFisica1));
        assertTrue("Should contain Maria", result.contains(pessoaFisica2));
    }

    @Test
    public void testPersistirAndRecuperar() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "João", "542", 20);
        pessoaFisicaRepo.inserir(pessoaFisica);
        
        String filename = "test_pessoa_fisica_repo.bin";
        pessoaFisicaRepo.persistir(filename);
        
        PessoaFisicaRepo newRepo = new PessoaFisicaRepo();
        newRepo.recuperar(filename);
        
        PessoaFisica result = newRepo.obter(1);
        assertNotNull("PessoaFisica should be restored", result);
        assertEquals("João", result.getNome());
        assertEquals("12345678901", result.getCpf());
        assertEquals(30, result.getIdade());
        
        // Clean up test file
        File file = new File(filename);
        file.delete();
    }

    @Test
    public void testGetSerialVersionUID() {
        long expectedSerialVersionUID = 1L; // Assume the serial version UID of PessoaFisicaRepo is 1L
        long actualSerialVersionUID = pessoaFisicaRepo.getSerialVersionUID();
        assertEquals("SerialVersionUID should match", expectedSerialVersionUID, actualSerialVersionUID);
    }
}
Here are the changes and improvements:

Initialization