package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class MedicamentoPrescritoController {

	@Autowired
	private EnderecoService service;

}