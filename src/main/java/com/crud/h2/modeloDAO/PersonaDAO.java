package com.crud.h2.modeloDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.h2.modelo.Persona;

@Repository
public class PersonaDAO implements IPersona {

	@Autowired
	private JdbcTemplate template;

	public List<Persona> listar() {
		String sql = "select * from persona";
		List<Persona> personas = template.query(sql, new BeanPropertyRowMapper<Persona>(Persona.class));
		return personas;
	}

	public Persona listPersonaId(int id) {
		String sql="select * from persona where id=?";
		Persona per=template.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Persona>(Persona.class));
		return per;

	}

	
	public int agregar(Persona p) {
		String sql = "insert into persona(name)values(?)";
		int res = template.update(sql, p.getName());
		return res;
	}

	
	public int editar(Persona p) {
		String sql="update persona set name=? where id=?";
		int res=template.update(sql,p.getName(),p.getId());
		return res;
	}

	
	public void delete(int id) {
		String sql="delete from persona where id=?";
		template.update(sql,id);
	}

}
