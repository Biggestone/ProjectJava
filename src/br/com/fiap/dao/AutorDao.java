package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.Conexao;
import br.com.fiap.model.Autor;

public class AutorDao {
	
	private Autor autor;
	private List<Autor> listaAutor;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql="";
	
	public void inserir(Autor autor){
		
		sql = "INSERT INTO AUTOR value(?,?,?)";
		connection = Conexao.getConnection();
		
		try{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, autor.getNome());
			ps.setString(3, autor.getSobrenome());
			ps.execute();
		}catch (SQLException e) {
			System.out.println("Erro ao inserir usuario"+e);
		}
	}
	
	public void alterar(Autor autor){
		sql = "UPDATE autor SET nome = ?,"
				+ "sobrenome = ?"
				+ "WHERE id = ?";
		connection = Conexao.getConnection();
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,autor.getNome());
			ps.setString(2, autor.getSobrenome());
			ps.setInt(3, autor.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar usuario"+e);
		}
		
	}
	
	public void deletar(int id){
		sql = "DELETE FROM AUTOR WHERE ID=?";
		connection = Conexao.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao deletar usuario"+e);
		}
		
	}
	
	public Autor pesquisar(int id){
		
		sql = "SELECT * FROM autor WHERE id = ?";
		connection = Conexao.getConnection();
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				autor = new Autor();
				autor.setNome(rs.getString("nome"));
				autor.setSobrenome(rs.getString("sobrenome"));			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	return autor;}
	
	public List<Autor> listar(){
		sql = "SELECT * FROM autor";
		connection = Conexao.getConnection();	
		listaAutor = new ArrayList<Autor>();
		
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				autor = new Autor();
				autor.setNome(rs.getString("nome"));
				autor.setSobrenome(rs.getString("sobrenome"));
				listaAutor.add(autor);				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar usuarios"+e);
		}
	return listaAutor;}

}
