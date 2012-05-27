/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author rafaelpoveda
 */
public class FuncionarioControllerTest {
    
    private Funcionario funcionario;
    //private static Departamento departamento;
    private boolean result;
    private List<Funcionario> _lst;
    
    public FuncionarioControllerTest() {
    }

    private static Departamento bindDepartamento(){
        Funcionario f = new Funcionario();
        f.setNomeComplet("Chefe RH");
        f.setNumeroMatricula(123);
        Departamento d = new Departamento();
        d.setCodigoDepartamento(1);
        d.setNomeDepartamento("RH");
        d.setChefeDepartamento(f);
        f.setDepartamento(d);
        
        return d;
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        funcionario = new Funcionario();
        _lst = new ArrayList<Funcionario>();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    public void inserirFuncionarioComTodosOsDados(){
        Departamento d = new Departamento();
        d.setChefeDepartamento(new Funcionario());
        d.setCodigoDepartamento(1);
        funcionario.setNomeComplet("Funcionario do teste");
        funcionario.setNumeroMatricula(123456789);
        funcionario.setDepartamento(d);
        result = new FuncionarioController().insert(funcionario);
        
        assertEquals(true, result);
    }
}
