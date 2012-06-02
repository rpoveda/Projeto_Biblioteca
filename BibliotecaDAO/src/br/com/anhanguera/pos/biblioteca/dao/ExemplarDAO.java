package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Exemplar;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class ExemplarDAO {

    private Connection conn;
    private PreparedStatement stmt = null;
    
    public ExemplarDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Exemplar exemplar) throws SQLException{
        try{
            String sql = "insert into exemplar (codigoexemplar, codigoobra, dataaquisicaoexemplar, situacaoexemplar) "+
                    " values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, exemplar.getCodigoExemplar());
            stmt.setInt(2, exemplar.getObra().getCodigoObra());
            stmt.setDate(3, UtilDAO.convertDataForDateSql(exemplar.getDataAquisicaoExemplar()));
            stmt.setString(4, exemplar.getSituacaoExemplar());
            stmt.execute();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean alter(Exemplar exemplar) throws SQLException{
        try{
            String sql = "update exemplar set dataaquisicaoexemplar = ? , situacaoexemplar = ? where "+
                    "codigoexemplar = ? and codigoobra = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, (Date)exemplar.getDataAquisicaoExemplar());
            stmt.setString(2, exemplar.getSituacaoExemplar());
            stmt.setInt(3, exemplar.getCodigoExemplar());
            stmt.setInt(4, exemplar.getObra().getCodigoObra());
            stmt.execute();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean delete(int codigoExemplar, int codigoObra) throws SQLException{
        try{
            String sql = "delete from exemplar wherer codigoexemplar = ? and codigoobra = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigoExemplar);
            stmt.setInt(2, codigoObra);
            stmt.execute();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public int nextCodigoExemplar(int codigoObra) throws SQLException{
        try{
            int intCodigoExemplar = 0;
            String sql = "select coalesce(max(codigoexemplar),0) + 1 'codigoexemplar' from exemplar where codigoobra = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigoObra);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                intCodigoExemplar = rs.getInt("codigoexemplar");
            }
            
            return intCodigoExemplar;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Exemplar> selectAll() throws SQLException{
        try{
            List<Exemplar> _lstExemplar = new ArrayList<Exemplar>();
            String sql = " select e.*,o.* from exemplar e " + 
                    " join obra o on o.codigoobra = e.codigoobra ";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Exemplar exemplar = new Exemplar();
                Obra obra = new Obra();
                
                exemplar.setCodigoExemplar(rs.getInt("codigoexemplar"));
                exemplar.setDataAquisicaoExemplar(rs.getDate("dataaquisicaoexemplar"));
                exemplar.setSituacaoExemplar(rs.getString("situacaoexemplar"));
                
                obra.setCodigoObra(rs.getInt("codigoobra"));
                obra.setTituloObra(rs.getString("tituloobra"));
                exemplar.setObra(obra);
                
                _lstExemplar.add(exemplar);
            }
            
            return _lstExemplar;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Exemplar> select(Exemplar pExemplar) throws SQLException{
        try{
            List<Exemplar> _lstExemplar = new ArrayList<Exemplar>();
            String sql = "select e.*, o.* from exemplar e " + 
                    " join obra o on o.codigoobra = e.codigoobra " +
                    " where e.codigoexemplar like ? and o.codigoobra like ? " +
                    " and o.tituloobra like ? ";
            boolean bContemSituacal = false;
            if(!pExemplar.getSituacaoExemplar().equals("")){
                bContemSituacal = true;
                sql += " and e.situacaoexemplar = ?";
            }

            String strCodigoExemplar = pExemplar.getCodigoExemplar() == 0 ? "" : Integer.toString(pExemplar.getCodigoExemplar());
            String strCodigoObra = pExemplar.getObra().getCodigoObra() == 0 ? "" : Integer.toString(pExemplar.getObra().getCodigoObra());
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + strCodigoExemplar + "%");
            stmt.setString(2, "%" +  strCodigoObra + "%");
            stmt.setString(3, "%" +  pExemplar.getObra().getTituloObra() + "%");
            if(bContemSituacal)
                stmt.setString(4, pExemplar.getSituacaoExemplar());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Exemplar exemplar = new Exemplar();
                Obra obra = new Obra();
                
                exemplar.setCodigoExemplar(rs.getInt("codigoexemplar"));
                exemplar.setDataAquisicaoExemplar(rs.getDate("dataaquisicaoexemplar"));
                exemplar.setSituacaoExemplar(rs.getString("situacaoexemplar"));
                
                obra.setCodigoObra(rs.getInt("codigoobra"));
                obra.setTituloObra(rs.getString("tituloobra"));
                exemplar.setObra(obra);
                
                _lstExemplar.add(exemplar);
            }
            
            return _lstExemplar;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
}
