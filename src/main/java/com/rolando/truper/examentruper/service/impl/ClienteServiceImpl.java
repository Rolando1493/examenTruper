package com.rolando.truper.examentruper.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolando.truper.examentruper.model.Cliente;
import com.rolando.truper.examentruper.repository.IClienteRepository;
import com.rolando.truper.examentruper.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Override
	public Cliente createCliente(Cliente cliente) {
		return iClienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> readClienteById(Long idCliente) {
		return iClienteRepository.findById(idCliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
	return iClienteRepository.save(cliente);
	}

	@Override
	public void deleteClienteById(Long idCliente) {
		iClienteRepository.deleteById(idCliente);
	}

}
