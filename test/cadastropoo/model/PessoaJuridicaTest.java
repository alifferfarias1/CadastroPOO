package cadastropoo.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaJuridicaTest {

    private PessoaJuridica instance;

    @Before
    public void setUp() {
        // Initialize a new instance of PessoaJuridica with valid data before each test
        instance = new PessoaJuridica(1, "Company A", "11111111111111");
    }

    @Test
    public void testGetCnpj() {
        // Test getting CNPJ
        String expectedCnpj = "11111111111111";
        String actualCnpj = instance.getCnpj();
        assertEquals("Should return the CNPJ", expectedCnpj, actualCnpj);
    }

    @Test
    public void testSetCnpj() {
        // Test setting CNPJ
        String newCnpj = "22222222222222";
        instance.setCnpj(newCnpj);
        assertEquals("CNPJ should be updated", newCnpj, instance.getCnpj());
    }

    @Test
    public void testExibir() {
        // The exibir method does not return a value, so it's hard to test directly.
        // You might need to manually check the console output or modify the method to facilitate testing.
        instance.exibir();
    }

    @Test
    public void testGetSerialVersionUID() {
        // Assuming you have a specific serialVersionUID value in PessoaJuridica
        long expectedSerialVersionUID = 1L;  // Replace with actual serialVersionUID of PessoaJuridica
        assertEquals(expectedSerialVersionUID, instance.getSerialVersionUID());
    }
}