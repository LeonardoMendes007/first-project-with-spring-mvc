package com.example.eventoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.eventoapp.model.entities.Convidado;
import com.example.eventoapp.model.entities.Evento;
import com.example.eventoapp.model.services.ConvidadoService;
import com.example.eventoapp.model.services.EventoService;

@Controller
public class EventoController {

	@Autowired
	private EventoService eventoRepository;

	@Autowired
	private ConvidadoService convidadoRepository;

	@RequestMapping("/eventos")
	public ModelAndView ListaEventos() {
		ModelAndView mav = new ModelAndView("index");
		Iterable<Evento> eventos = eventoRepository.findAll();
		mav.addObject("eventos", eventos);
		return mav;
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {

		eventoRepository.insert(evento);

		return "redirect:/cadastrarEvento";
	}

	

}
