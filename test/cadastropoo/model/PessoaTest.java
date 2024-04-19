/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cadastropoo.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PessoaTest {
    
    public PessoaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Pessoa.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Pessoa instance = new Pessoa();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Pessoa.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Pessoa instance = new Pessoa();
        instance.setId(id);
    }

    /**
     * Test of getNome method, of class Pessoa.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Pessoa.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Pessoa instance = new Pessoa();
        instance.setNome(nome);
    }

    /**
     * Test of exibir method, of class Pessoa.
     */
    @Test
    public void testExibir() {
        System.out.println("exibir");
        Pessoa instance = new Pessoa();
        instance.exibir();
    }

    /**
     * Test of getSerialVersionUID method, of class Pessoa.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        Pessoa instance = new Pessoa();
        long expResult = instance.getSerialVersionUID();
        long result = instance.getSerialVersionUID();
        assertEquals(expResult, result);
    }
    
}
