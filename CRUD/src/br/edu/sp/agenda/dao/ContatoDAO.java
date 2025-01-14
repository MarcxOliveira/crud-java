package br.edu.sp.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.sp.agenda.factory.ConnetionFactory;
import br.edu.sp.agenda.model.Contato;

public class ContatoDAO {


	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnetionFactory.createConnectionToMysql();
			
			//Criamos uma PrepareStatement, para executar uma query
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores
			pstm.setNString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Contato salvo com sucesso!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<Contato> getContatos;{
		
	String sql = "SELECT * FROM contatos";
	
	List<Contato> contatos = new ArrayList<Contato>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	//Classe que vai recuperar os dados do banco
	ResultSet rset = null;
	
	try {
		conn = ConnetionFactory.createConnectionToMysql();
		
		pstm = conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			
			Contato contato = new Contato();
			
			//Recuperar o id
			contato.setId(rset.getInt("id"));
			//Recuperar o Nome
			contato.setNome(rset.getString("nome"));
			//Recuperar a idade
			contato.setIdade(rset.getInt("idade"));
			//Recuperar a data de cadastro
			contato.setDataCadastro(rset.getDate("datacadastro"));
			
			
			contatos.add(contato);
		}	
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
		
			if(rset!=null) {
				rset.close();
			}
			
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
	}	catch (Exception e) {
		e.printStackTrace();
	}
	}
	}
}

