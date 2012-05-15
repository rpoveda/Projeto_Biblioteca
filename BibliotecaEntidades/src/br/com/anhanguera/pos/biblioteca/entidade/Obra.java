package br.com.anhanguera.pos.biblioteca.entidade;

import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class Obra {

    private int codigoObra = 0;
    private String tituloObra = "";
    private Autor autorPrincipal;
    private List<Autor> todosAutores;
    private int anoPublicacao = 0;
    private SituacaoObra situacaoObra;
    private Editora editoraObra;
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Autor getAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(Autor autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public int getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(int codigoObra) {
        this.codigoObra = codigoObra;
    }

    public Editora getEditoraObra() {
        return editoraObra;
    }

    public void setEditoraObra(Editora editoraObra) {
        this.editoraObra = editoraObra;
    }

    public SituacaoObra getSituacaoObra() {
        return situacaoObra;
    }

    public void setSituacaoObra(SituacaoObra situacaoObra) {
        this.situacaoObra = situacaoObra;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }
    
    public List<Autor> getTodosAutores() {
        return todosAutores;
    }

    public void setTodosAutores(List<Autor> todosAutores) {
        this.todosAutores = todosAutores;
    }
}
