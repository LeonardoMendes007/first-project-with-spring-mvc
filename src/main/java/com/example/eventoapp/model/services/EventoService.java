package com.example.eventoapp.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventoapp.model.entities.Evento;
import com.example.eventoapp.model.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;

	public List<Evento> findAll() {
		return repository.findAll();
	}

	public Evento insert(Evento evento) {
		return repository.save(evento);
	}

	public Evento findById(Long id) {
		Optional<Evento> obj = repository.findById(id);
		return obj.orElseThrow(null);
	}
}
