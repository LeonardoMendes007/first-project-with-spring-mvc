package com.example.eventoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.eventoapp.model.entities.Convidado;
import com.example.eventoapp.model.entities.Evento;
import com.example.eventoapp.model.services.ConvidadoService;
import com.example.eventoapp.model.services.EventoService;

@Controller
@RequestMapping("/")
public class DetalhesEventoController {

	@Autowired
	ConvidadoService convidadoRepository;
	
	@Autowired
	EventoService eventoRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("id") Long id, Convidado convidado) {

		Evento evento = eventoRepository.findById(id);

		convidado.setEvento(evento);
		convidado.setId(null);

		convidadoRepository.insert(convidado);

		return "redirect:/{id}";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") Long id) {

		Evento evento = eventoRepository.findById(id);
		ModelAndView mav = new ModelAndView("evento/detalhesEvento");
		mav.addObject("evento", evento);

		List<Convidado> convidados = convidadoRepository.findByEvento(evento);
		mav.addObject("convidados", convidados);

		return mav;
	}
	
	@RequestMapping(value = "{id}/delete")
	public String deletarConvidado(Long id) {

		Convidado convidado = convidadoRepository.findById(id);

		convidadoRepository.delete(convidado);

		return "redirect:/" + convidado.getEvento().getId();
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editar(Convidado con) {
		
		Convidado convidado = convidadoRepository.findById(con.getId());
	
		convidado.setNome(con.getNome());
		convidado.setRg(con.getRg());
		
		convidadoRepository.insert(convidado);
		
		return "redirect:/" + convidado.getEvento().getId();
	}

}
