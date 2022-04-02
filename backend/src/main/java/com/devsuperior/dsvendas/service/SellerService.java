package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		/*
			Retorna o findAll() para uma variável do tipo List<Seller>
			O atributo repository trabalha com as entidades
		*/
		List<Seller> result = repository.findAll();
		
		/*
			Abaixo, converte a lista de Seller para SellerDTO
			Função map coverte a coleção original em uma nova coleção, que pode ser de outro tipo também
			Para cada 'x' da lista original crie um novo objeto SellerDTO passando 'x' como argumento, chamando o construtor SellerDTO(Seller entity)
			Para concluir a operação, converta stream() para list novamente com 'collect(Collectors.toList())'
		*/
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
