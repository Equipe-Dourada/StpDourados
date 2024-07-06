package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeService service;

}
