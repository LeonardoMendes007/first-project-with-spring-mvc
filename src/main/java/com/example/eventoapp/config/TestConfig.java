package com.example.eventoapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.eventoapp.model.entities.Convidado;
import com.example.eventoapp.model.entities.Evento;
import com.example.eventoapp.model.repositories.ConvidadoRepository;
import com.example.eventoapp.model.repositories.EventoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Evento evento1 = new Evento("Carros Eletricos", "Expo Center", "15/09/2020", "15:00");
		Evento evento2 = new Evento("BGS", "Expo Center", "15/07/2020", "13:00");
		
		eventoRepository.saveAll(Arrays.asList(evento1,evento2));
		
		Convidado con1 = new Convidado("99999999", "Ivana Maria", evento1);
		Convidado con2 = new Convidado("55555555", "Guilherme Mendes", evento2);
		Convidado con3 = new Convidado("77777777", "Gustavo Mendes", evento2);
		Convidado con4 = new Convidado("33333333", "Jéssica Mendes", evento1);
		
		convidadoRepository.saveAll(Arrays.asList(con1,con2,con3,con4));
	}

}
