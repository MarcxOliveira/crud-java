package br.edu.sp.agenda.aplication;

import java.util.Date;

import br.edu.sp.agenda.dao.ContatoDAO;
import br.edu.sp.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Ana");
		contato.setIdade(20);
		contato.setDataCadastro(new Date());
		
		contatoDao.save(contato);
	}

}
