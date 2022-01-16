package br.com.isadora.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isadora.entities.Receita;
import br.com.isadora.enums.TipoReceita;
import br.com.isadora.services.ReceitaService;

@RestController
@RequestMapping("receita")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;

	@PostMapping
	public Integer criarReceita(@RequestBody Receita receita) {
		return receitaService.criar(receita);
	}

	@PutMapping
	public Integer atualizarReceita(@RequestParam Integer id, @RequestBody Receita receita) {
		return receitaService.atualizar(receita, id);
	}

	@DeleteMapping
	public Integer deletarReceita(@RequestParam Integer id) {
		return receitaService.deletar(id);
	}
	
	@GetMapping
	public List<Receita> buscarReceitas() {
		return receitaService.buscarTodas();
	}
	
	@GetMapping("/totalReceitas")
	public Integer buscarTotalReceitas() {
		return receitaService.listarTotalDeReceitas();
	}
	
	@GetMapping("/tipoReceita")
	public List<Receita> buscarPorTipoReceita(@RequestParam TipoReceita tipoReceita){
		return receitaService.buscarPorTipoReceita(tipoReceita);
	} 
	
	@GetMapping("/{id}")
	public Receita buscarPorId(@PathVariable Integer id) {
		return receitaService.buscarPorId(id);
	}
	
	@GetMapping("/dataRecebimento")
	public List<Receita> buscarPorDataRecebimento(
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataFinal) {
		return receitaService.buscarPorPeriodoDataRecebimento(dataInicial, dataFinal);
	}

	@GetMapping("/dataRecebimentoEsperado")
	public List<Receita> buscarPorDataRecebimentoEsperado(
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataFinal) {
		return receitaService.buscarPorPeriodoDataRecebimentoEsperado(dataInicial, dataFinal);
	}
}