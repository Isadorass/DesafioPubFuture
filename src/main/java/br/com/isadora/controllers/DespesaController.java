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

import br.com.isadora.entities.Despesa;
import br.com.isadora.enums.TipoDespesa;
import br.com.isadora.services.DespesaService;

@RestController
@RequestMapping("despesa")
public class DespesaController {

	@Autowired
	private DespesaService despesaService;

	@PostMapping
	public Integer cadastrarDespesa(@RequestBody Despesa despesa) {
		return despesaService.criar(despesa);
	}

	@PutMapping
	public Integer atualizarDespesa(@RequestBody Despesa despesa, @RequestParam Integer id) {
		return despesaService.atualizar(despesa, id);
	}

	@DeleteMapping
	public Integer deletarDespesa(@RequestParam Integer id) {
		return despesaService.deletar(id);
	}

	@GetMapping
	public List<Despesa> buscarTodasDespesas() {
		return despesaService.buscarTodas();
	}

	@GetMapping("/{id}")
	public Despesa buscarPorId(@PathVariable Integer id) {
		return despesaService.buscarPorId(id);
	}

	@GetMapping("/totalDespesas")
	public Integer buscarTotalDespesas() {
		return despesaService.buscarTotalDeDespesas();
	}

	@GetMapping("/tipoDespesa")
	public List<Despesa> buscarTipoDespesa(@RequestParam TipoDespesa tipoDespesa) {
		return despesaService.buscarTipoDespesa(tipoDespesa);
	}

	@GetMapping("/dataPagamento")
	public List<Despesa> buscarPorDataPagamento(
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataFinal) {
		return despesaService.buscarPorPeriodoDataPagamento(dataInicial, dataFinal);
	}

	@GetMapping("/dataPagamentoEsperado")
	public List<Despesa> buscarPorDataPagamentoEsperado(
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dataFinal) {
		return despesaService.buscarPorPeriodoDataPagamentoEsperado(dataInicial, dataFinal);
	}
}