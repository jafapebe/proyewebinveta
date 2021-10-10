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

import com.init.products.daos.ProveedoresDaos;
import com.init.products.entitys.Proveedores;

@RestController
@RequestMapping("proveedores")
public class ProveedoresRest {
  
	@Autowired
	private ProveedoresDaos proveedoresDaos;
	
	
	@GetMapping
	public ResponseEntity<List<Proveedores>> getProduct(){
			List<Proveedores> proveedores =  proveedoresDaos.findAll();
			return ResponseEntity.ok(proveedores);
	}
	@RequestMapping(value="{proveedoresId}", method=RequestMethod.GET)
	public ResponseEntity<Proveedores> getProveedoresId(@PathVariable("proveedoresId") Long proveedoresId){
		
		Optional<Proveedores> OptionalProveedores = proveedoresDaos.findById(proveedoresId);
		
		if(OptionalProveedores.isPresent()) {
			return ResponseEntity.ok(OptionalProveedores.get());
		}
		else  
			return ResponseEntity.noContent().build();
		}
		
	@PostMapping 
	public ResponseEntity<Proveedores> crearProveedores(@RequestBody Proveedores proveedores){
		Proveedores newProveedores = proveedoresDaos.save(proveedores);
		return ResponseEntity.ok(newProveedores);
	
	}
	
	@DeleteMapping(value="{proveedoresId}")
	public ResponseEntity<Void> deleteProveedores(@PathVariable("proveedoresId") Long proveedoresId){
	proveedoresDaos.deleteById(proveedoresId);
	return ResponseEntity.ok(null);
	}
	
	@PutMapping
	ResponseEntity<Proveedores> UpdateProveedores(@RequestBody Proveedores proveedores){
		
		Optional<Proveedores> OptionalProveedores = proveedoresDaos.findById(proveedores.getId());
		
		if(OptionalProveedores.isPresent()) {
			
			Proveedores updateproveedores = OptionalProveedores.get();
			
			updateproveedores.setNombreProv(proveedores.getNombreProv());
			updateproveedores.setAddressProv(proveedores.getAddressProv());
			updateproveedores.setCiudadProv(proveedores.getCiudadProv());
			updateproveedores.setEmailProv(proveedores.getEmailProv());
			updateproveedores.setTelefonoProv(proveedores.getTelefonoProv());
			
			
			
			proveedoresDaos.save(updateproveedores);
			return ResponseEntity.ok(updateproveedores);
			
		}else 
			return ResponseEntity.notFound().build();
		
			
		}	
}
