package br.com.isadora.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isadora.entities.Conta;
import br.com.isadora.services.ContaService;

@RestController
@RequestMapping("conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping
	public List<Conta> buscarTodasContas() {
		return contaService.buscarTodasContas();
	}

	@GetMapping("/{id}")
	public Conta buscarContaPorId(@PathVariable Integer id) {
		return contaService.buscarPorId(id);
	}

	@GetMapping("/listarSaldoTotal")
	public Double listarSaldoTotal(@RequestParam Integer id) {
		return contaService.listarSaldo(id);
	}

	@PostMapping
	public Integer criarConta(@RequestBody Conta conta) {
		return contaService.criar(conta);
	}

	@PutMapping
	public Integer atualizarConta(@RequestParam Integer id, @RequestBody Conta conta) {
		return contaService.atualizar(id, conta);
	}

	@DeleteMapping
	public Integer deletarConta(@RequestParam Integer id) {
		return contaService.deletar(id);
	}

	@PutMapping("/transferir")
	public Boolean tranferir(@RequestParam Integer contaPagante, @RequestParam Integer contaRecebente,
			@RequestParam Double valor) {
		return contaService.transferirSaldo(contaPagante, contaRecebente, valor);
	}
}