package cadastropoo.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaFisicaTest {
    
    private PessoaFisica pessoaFisica;
    
    @Before
    public void setUp() {
        // Initialize a new PessoaFisica object with test values
        pessoaFisica = new PessoaFisica(1, "John Doe", "12345678901", 25);
    }
    
    @Test
    public void testGetCpf() {
        // Expected CPF is "12345678901"
        assertEquals("12345678901", pessoaFisica.getCpf());
    }

    @Test
    public void testSetCpf() {
        // Change CPF to "98765432109"
        pessoaFisica.setCpf("98765432109");
        // Verify that CPF was updated correctly
        assertEquals("98765432109", pessoaFisica.getCpf());
    }

    @Test
    public void testGetIdade() {
        // Expected age is 25
        assertEquals(25, pessoaFisica.getIdade());
    }

    @Test
    public void testSetIdade() {
        // Change age to 30
        pessoaFisica.setIdade(30);
        // Verify that age was updated correctly
        assertEquals(30, pessoaFisica.getIdade());
    }

    @Test
    public void testExibir() {
        // Test the exibir method by checking the console output
        pessoaFisica.exibir();
        // Typically, testing console output can be done using a specific library or tool, but in general unit tests shouldn't rely on console output.
    }

    @Test
    public void testGetSerialVersionUID() {
        // Expected serialVersionUID should match the PessoaFisica class value
        long expectedSerialVersionUID = PessoaFisica.serialVersionUID;
        assertEquals(expectedSerialVersionUID, pessoaFisica.getSerialVersionUID());
    }
}
Here are the changes and improvements: