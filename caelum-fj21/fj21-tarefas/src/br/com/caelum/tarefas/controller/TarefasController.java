package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefasController {
	
	@Autowired
	TarefaDao dao; 
	
	/*@RequestMapping("login")
	public String login () {
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		//List<Tarefa> tarefas = dao.lista();
		//model.addAttribute("tarefas", tarefas);
		return "tarefa/login";
	}*/

	@RequestMapping("listaTarefas")
	public String lista (Model model) {
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefas")
	public String remove (Tarefa tarefa) {
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefas")
	public String mostra (Long id, Model model) {
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa",dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefas")
	public String finaliza (Long id, Model model) {
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa",dao.buscaPorId(id));
		return "tarefa/mostra";
	}

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult br) {
		if (br.hasErrors()) {
			return "tarefa/formulario";
		}
		
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	
}
