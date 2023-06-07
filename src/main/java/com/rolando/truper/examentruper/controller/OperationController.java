package com.rolando.truper.examentruper.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rolando.truper.examentruper.bean.ListaCompraMO;
import com.rolando.truper.examentruper.bean.ProductoMO;
import com.rolando.truper.examentruper.bean.Response;
import com.rolando.truper.examentruper.exception.ResourceNotFound;
import com.rolando.truper.examentruper.model.Cliente;
import com.rolando.truper.examentruper.model.Key;
import com.rolando.truper.examentruper.model.ListaCompra;
import com.rolando.truper.examentruper.model.ListaCompraDetalle;
import com.rolando.truper.examentruper.model.Producto;
import com.rolando.truper.examentruper.service.IListaCompraDetalleService;
import com.rolando.truper.examentruper.service.IListaCompraService;



@RestController
@RequestMapping("api/v1")
public class OperationController {
	
	private  Logger log = LoggerFactory.getLogger(OperationController.class); 
	
	@Autowired
	private IListaCompraDetalleService iListaCompraDetalleService;
	
	@Autowired
	private IListaCompraService iListaCompraService;
	
	private static final String MESSAGEEXITO = "SUCCESSFUL OPERATION";
	private Long timeInit;
	private Long timeFinish;
	private Long timeFinal;
	
	
	@PostMapping("/listaCompra")
	public ResponseEntity<?> createListaCompraDetalle(@RequestBody List<ListaCompraMO> requets) throws ResourceNotFound{
		timeInit = System.currentTimeMillis();
		try {
			for(ListaCompraMO item : requets) {
				this.procesarListaCompra(item, "Alta");
			}
			timeFinish = System.currentTimeMillis();
			timeFinal = timeFinish - timeInit;
			log.info("Tiempo de ejecucion {}", timeFinal);
			return new ResponseEntity<> (getResponseExito(), HttpStatus.OK);
			
		}catch (Exception e) {
			throw new ResourceNotFound(e.getMessage());
		}
	}
	
	@GetMapping("/listaCompra/{idCustomer}")
	public ResponseEntity<?> getListaCompraByIdCustomer(@RequestParam(value="idCustomer") Long idCustomer) throws ResourceNotFound{
		try {
			return ResponseEntity.ok(iListaCompraService.getCompraByIdCustomer(idCustomer));
		}catch (Exception e) {
			throw new ResourceNotFound("No se encontro datos con el idCustomer: "+idCustomer);
		}
	}
	
	@PutMapping("/listaCompra")
	public ResponseEntity<?> updateListCompra(@RequestBody ListaCompraMO requets) throws ResourceNotFound{
		timeInit = System.currentTimeMillis();
		try {
			procesarListaCompra(requets, "update");
			timeFinish = System.currentTimeMillis();
			timeFinal = timeFinish - timeInit;
			log.info("Tiempo de ejecucion {}", timeFinal);
			return new ResponseEntity<> (getResponseExito(), HttpStatus.OK);
		}catch (Exception e) {
			throw new ResourceNotFound(e.getMessage());
		}
	}
	
	@DeleteMapping("listaCompra/{idListaCompra}")
	public ResponseEntity<?> deleteListaCompraById(Long idListaCompra) throws ResourceNotFound{
		timeInit = System.currentTimeMillis();
		Optional<ListaCompra> existeListaCompra = iListaCompraService.readListaCompraById(idListaCompra);
		if(existeListaCompra.isPresent()) {
			ListaCompra lista = existeListaCompra.get();
			lista.setActivo(false);
			iListaCompraService.updateListaCompra(lista);
			timeFinish = System.currentTimeMillis();
			timeFinal = timeFinish - timeInit;
			log.info("Tiempo de ejecucion {}", timeFinal);
			return new ResponseEntity<> (getResponseExito(), HttpStatus.OK);
		}else {
			throw new ResourceNotFound("No se encontro la lista a eliminar");
		}
	}
	
	
	private void procesarListaCompra(ListaCompraMO request, String accion) {
		ListaCompra compra;
		if(accion.equals("update")) {
			Optional<ListaCompra> existeLista = iListaCompraService.getLastListaCompraByCustomer(request.getCliente());
			if(existeLista.isPresent()) {
				compra = existeLista.get();
				compra.setNombre(request.getNombreLista());
				compra = iListaCompraService.updateListaCompra(compra);
				for(ProductoMO itemProducto : request.getProducto()) {
					saveProduct(compra, itemProducto);
				}
			}
		}else {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(request.getCliente());
			compra = new ListaCompra();
			compra.setCliente(cliente);
			compra.setFechaRegistro(new Date());
			compra.setActivo(true);
			compra.setNombre(request.getNombreLista());
			compra = iListaCompraService.createListaCompra(compra);
			for(ProductoMO itemProducto : request.getProducto()) {
				saveProduct(compra, itemProducto);
			}
		}
		
	}
	private void saveProduct(ListaCompra compra, ProductoMO productoMO) {
		Key key = new Key();
		key.setIdListaCompra(compra.getIdLista());
		key.setCodigoProducto(productoMO.getIdProducto());
		ListaCompraDetalle detalle = new ListaCompraDetalle();
		detalle.setKey(key);
		detalle.setCantidad(productoMO.getCantidad());
		Producto producto = new  Producto();
		producto.setIdProducto(producto.getIdProducto());
		detalle.setProducto(producto);
		detalle.setListaCompra(compra);
		iListaCompraDetalleService.createListaCompraDetalle(detalle);
	}
	
	private Response getResponseExito() {
		Response response = new Response();
		response.setFecha(new Date());
		response.setMessage(MESSAGEEXITO);
		return response;
	}
}
