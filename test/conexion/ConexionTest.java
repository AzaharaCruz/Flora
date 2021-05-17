/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Azahara
 */
public class ConexionTest {
    
    public ConexionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class Conexion.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        Conexion instance = new Conexion();
        Connection result = instance.conectar();
        assertNotNull(result);
    }

    /**
     * Test of login method, of class Conexion.
     */
    @Test
    public void testLoginOk() {
        System.out.println("login");
        String usuario = "Azahara";
        String pass = "1234";
        Conexion instance = new Conexion();
        Usuario result = instance.login(usuario, pass);
        if(result == null || !result.getNombre().equals(usuario) || !result.getPass().equals(pass))
        {
            fail("El usuario no se ha logeado correctamente");
        }
    }

@Test
    public void testLoginKo() {
        System.out.println("login");
        String usuario = "Azahara";
        String pass = "123423";
        Conexion instance = new Conexion();
        Usuario result = instance.login(usuario, pass);
        if(result != null)
        {
            fail("El usuario no se ha logeado correctamente");
        }
    }

    /**
     * Test of buscarPlantas method, of class Conexion.
     */
    @Test
    public void testBuscarPlantas() {
        System.out.println("buscarPlantas");
        String nombrePlanta = "Salicornia";
        Conexion instance = new Conexion();
        List<Planta> result = instance.buscarPlantas(nombrePlanta);
        assertNotNull(result);
    }

    /**
     * Test of detallePlanta method, of class Conexion.
     */
    @Test
    public void testDetallePlanta() {
        System.out.println("detallePlanta");
        String nombre_cientifico = "Sarcocornia perennis";
        Conexion instance = new Conexion();
        Planta result = instance.detallePlanta(nombre_cientifico);
        assertNotEquals(nombre_cientifico, result.getNombre_cientifico());
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of detallePlanta method, of class Conexion.
     */
    @Test
    public void testPlantaNoExiste() {
        System.out.println("detallePlanta");
        String nombre_cientifico = "Sarcocornia penniasd";
        Conexion instance = new Conexion();
        Planta result = instance.detallePlanta(nombre_cientifico);
        assertNotEquals(result.getNombre_comun(), "");
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
