/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author rafaelpoveda
 */
public class EditoraControllerTest {
    
    private Editora editora;
    private boolean result;
    private List<Editora> _lst;
    
    public EditoraControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //new EditoraController().TruncaTable();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        //new EditoraController().TruncaTable();
    }
    
    @Before
    public void setUp() {
        
        editora = new Editora();
        editora.setNomeEditora("Editora de teste");
        editora.setCidadeEditora("Sorocaba");
        new EditoraController(editora).insert();
        _lst = new ArrayList<Editora>();
    }
    
    @After
    public void tearDown() {
        new EditoraController().TruncaTable();
        editora = null;
        result = false;
        _lst = null;
    }
    
    /**
     * Test of insert method, of class EditoraController.
     */
    @Test
    public void inserirEditoraComTodosOsCampos() {
        //System.out.println("insert com todos os campos");
        editora.setNomeEditora("Editora test");
        editora.setCidadeEditora("Sao Paulo");
        boolean result = new EditoraController(editora).insert();
        assertEquals(true, result);
    }
    
    @Test
    public void inserirEditoraSemNome(){
        //System.out.println("insert sem nome editora");
        editora.setNomeEditora(null);
        editora.setCidadeEditora("Sao Paulo");
        result = new EditoraController(editora).insert();
        assertEquals(false, result);
    }
    
    @Test
    public void inserirEditoraSemCidade(){
        editora.setNomeEditora("Editora teste");
        editora.setCidadeEditora(null);
        result = new EditoraController(editora).insert();
        assertEquals(false, result);
    }
    @Test
    public void inserirEditoraSemNomESemCidade(){
        editora.setNomeEditora(null);
        editora.setCidadeEditora(null);
        result = new EditoraController(editora).insert();
        assertEquals(false, result);
    }
    
    @Test
    public void alterarEditoraCompleta(){
        editora.setCodigoEditora(1);
        editora.setNomeEditora("Editora de teste");
        editora.setCidadeEditora("Sorocaba");
        result = new EditoraController(editora).alter();
        assertEquals(true, result);
    }
    @Test
    public void alterarEdiotraSemCodigo(){
        //editora.setCodigoEditora(0);
        editora.setNomeEditora("Editora de teste");
        editora.setCidadeEditora("Sorocaba");
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    @Test
    public void alterarEditoraComCodigoZero(){
        editora.setCodigoEditora(0);
        editora.setNomeEditora("Editora de teste");
        editora.setCidadeEditora("Sorocaba");
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    @Test
    public void alterarEditoraSemNome(){
        editora.setCodigoEditora(1);
        editora.setNomeEditora(null);
        editora.setCidadeEditora("Sorocaba");
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    @Test
    public void alterarEditoraSemCidade(){
        editora.setCodigoEditora(2);
        editora.setNomeEditora("Editora de teste");
        editora.setCidadeEditora(null);
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    @Test
    public void alterarEditoraSemInformacao(){
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    @Test
    public void alterarEditoraComInfomarcaoNull(){
        editora.setCodigoEditora(0);
        editora.setNomeEditora(null);
        editora.setCidadeEditora(null);
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    @Test
    public void alterarEditoraInexistente(){
        editora.setCodigoEditora(50);
        editora.setNomeEditora("Editora que nao existe");
        editora.setCidadeEditora("Sorocaba");
        result = new EditoraController(editora).alter();
        assertEquals(false, result);
    }
    
    @Test
    public void excluirEditoraInexistente(){
        result = new EditoraController().delete(50);
        assertEquals(false, result);
    }
    @Test
    public void excluirEditoraSemInformarCodigo(){
        result = new EditoraController().delete(0);
        assertEquals(false, result);
    }
    @Test
    public void excluirEditoraExistente(){
        result = new EditoraController().delete(1);
        assertEquals(true, result);
    }
    
    @Test
    public void selecionaSemParametros(){
        _lst = new EditoraController(new Editora()).select();
        assertNotNull(_lst);
    }
    @Test
    public void selecionaEditoraPorCodigo(){
        editora.setCodigoEditora(1);
        _lst = new EditoraController(this.editora).select();
        assertEquals(false, _lst.isEmpty());
    }
    @Test
    public void selecionaEditoraComCodigoInexistente(){
        editora.setCodigoEditora(50);
        _lst = new EditoraController(this.editora).select();
        assertEquals(true, _lst.isEmpty());
    }
    @Test
    public void selecionaEditoraPorNome(){
        editora.setNomeEditora("Editora de teste");
         _lst = new EditoraController(this.editora).select();
        assertEquals(false, _lst.isEmpty());
    }
    @Test
    public void selecionaEditoraComNomeInexistente(){
        editora.setNomeEditora("Essa ediroa nao existe");
        _lst = new EditoraController(this.editora).select();
        assertEquals(true,_lst.isEmpty());
    }
    @Test
    public void selecionaEditoraPorCidade(){
        editora.setCidadeEditora("Sorocaba");
        _lst = new EditoraController(this.editora).select();
        assertEquals(false, _lst.isEmpty());
    }
    @Test
    public void selecionaEditoraComCidadeInexistente(){
        editora.setCidadeEditora("Rio de Janeiro");
        _lst = new EditoraController(this.editora).select();
        assertEquals(true, _lst.isEmpty());
    }
    
    @Test
    public void selecionaTodasEditoras() {
        _lst = new EditoraController().selectAll();
        editora = _lst.get(0);
        assertEquals(1, editora.getCodigoEditora());
    }
}
