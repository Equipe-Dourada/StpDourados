package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.service.DocumentoTransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentoTransferencia")
public class DocumentoTransferenciaController {

	@Autowired
	private DocumentoTransferenciaService service;

	
}
