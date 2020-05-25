package com.example.eventoapp.model.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventoapp.model.entities.Convidado;
import com.example.eventoapp.model.entities.Evento;
import com.example.eventoapp.model.repositories.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	
	public Convidado insert(Convidado convidado) {
		return repository.save(convidado);
	}
	
	public void delete(Convidado convidado) {
		repository.delete(convidado);
	}
	
	public List<Convidado> findAll() {
		return repository.findAll();
	}
	
	public Convidado findById(Long id) {
		Optional<Convidado> obj = repository.findById(id);
		return obj.orElseThrow(() -> null);
	}
	
	public List<Convidado> findByEvento(Evento evento){
		
		List<Convidado> convidados = findAll();
		
		convidados = convidados.stream().filter(x -> x.getEvento().equals(evento)).collect(Collectors.toList());
		
		return convidados;
	}

	
}
