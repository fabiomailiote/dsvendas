package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;

//Notação para indicar que a classe será um controlador Rest
@RestController
//Notação para indicar o caminho do recurso Web
@RequestMapping(value = "/sellers")
public class SellerController {

	@Autowired
	private SellerService service;
	
	/*
		Método para representar o EndPoint, para chamar o caminho no navegador
		ResponseEntity é um tipo especial de resposta do Spring
	*/
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list); //Método 'ok' vai indicar a resposta 200 (Sucesso)
	}
}
