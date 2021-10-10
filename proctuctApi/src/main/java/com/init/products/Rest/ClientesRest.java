package com.init.products.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.products.daos.ClienteDaos;  
import com.init.products.entitys.Clientes;



@RestController
@RequestMapping("clientes")
public class ClientesRest {

	@Autowired
	private ClienteDaos clienteDaos;
	
	
	@GetMapping
	public ResponseEntity<List<Clientes>> getProduct(){
			List<Clientes> clientes =  clienteDaos.findAll();
			return ResponseEntity.ok(clientes);
	}
	@RequestMapping(value="{clientesId}", method=RequestMethod.GET)
	public ResponseEntity<Clientes> getClientesId(@PathVariable("clientesId") Long clientesId){
		
		Optional<Clientes> OptionalClientes = clienteDaos.findById(clientesId);
		
		if(OptionalClientes.isPresent()) {
			return ResponseEntity.ok(OptionalClientes.get());
		}
		else  
			return ResponseEntity.noContent().build();
		}
		
	@PostMapping 
	public ResponseEntity<Clientes> crearClientes(@RequestBody Clientes clientes){
		Clientes newClientes = clienteDaos.save(clientes);
		return ResponseEntity.ok(newClientes);
	
	}
	
	@PutMapping
	ResponseEntity<Clientes> UpdateClientes(@RequestBody Clientes clientes){
		
		Optional<Clientes> OptionalClientes = clienteDaos.findById(clientes.getId());
		
		if(OptionalClientes.isPresent()) {
			
			Clientes updateclientes = OptionalClientes.get();
			
			updateclientes.setNombreCli(clientes.getNombreCli());
			updateclientes.setAddressCli(clientes.getAddressCli());
			updateclientes.setCiudadCli(clientes.getCiudadCli());
			updateclientes.setEmailCli(clientes.getEmailCli());
			updateclientes.setTelefonoCli(clientes.getTelefonoCli());
			
			clienteDaos.save(updateclientes);
			return ResponseEntity.ok(updateclientes);
					
		}else 
			return ResponseEntity.notFound().build();
					
		}	
	
	@DeleteMapping(value="{clientesId}")
	public ResponseEntity<Void> borrarClientes(@PathVariable("clientesId") Long clientesId){
	clienteDaos.deleteById(clientesId);
	return ResponseEntity.ok(null);
	}

}
