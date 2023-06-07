package com.rolando.truper.examentruper.service;

import java.util.Optional;

import com.rolando.truper.examentruper.model.Cliente;

public interface IClienteService {
	
	
	public Cliente createCliente(Cliente cliente);
	
	public Optional<Cliente> readClienteById(Long idCliente);
	
	public Cliente updateCliente(Cliente cliente);
	
	public void deleteClienteById(Long idCliente);
	
}
