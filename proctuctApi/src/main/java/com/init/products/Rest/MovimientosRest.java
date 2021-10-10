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

import com.init.products.daos.MovimientosDaos;
import com.init.products.entitys.Movimientos;

@RestController
@RequestMapping("/movimientos")
public class MovimientosRest {
	@Autowired
	private MovimientosDaos movimientosDaos;
	
	@GetMapping
	public ResponseEntity<List<Movimientos>> getMovimientos(){
		
		List<Movimientos> Movimientos = movimientosDaos.findAll();
		
		return ResponseEntity.ok(Movimientos);
	}

	@RequestMapping(value="{Id}", method=RequestMethod.GET)
	public ResponseEntity<Movimientos> getMovimientosById(@PathVariable("Id") Long movimientoId){
		
		Optional<Movimientos> optionalMovimientos = movimientosDaos.findById(movimientoId);
		
		if (optionalMovimientos.isPresent()){
			return ResponseEntity.ok(optionalMovimientos.get());
		}else {
			return ResponseEntity.noContent().build();
		}	
	
	}
	
	@PostMapping
	public ResponseEntity<Movimientos> crearMovimiento(@RequestBody Movimientos movimiento){
		
		Movimientos newMovimiento = movimientosDaos.save(movimiento);
		return ResponseEntity.ok(newMovimiento);
	}
	
	@DeleteMapping(value="{Id}")
	public ResponseEntity<Void> deleteMovimiento(@PathVariable("Id") Long Id){
		
		movimientosDaos.deleteById(Id);
		return ResponseEntity.ok(null);
	}
	
	
	@PutMapping
	public ResponseEntity<Movimientos> updateProduct(@RequestBody Movimientos movimiento){
		Optional<Movimientos> optionalMovimiento = movimientosDaos.findById(movimiento.getId());
		
		if (optionalMovimiento.isPresent()){
			Movimientos updateMovimiento = optionalMovimiento.get();
			
			updateMovimiento.setMov_cli_cedula(movimiento.getMov_cli_cedula());
			updateMovimiento.setMov_fecha(movimiento.getMov_fecha());
			updateMovimiento.setMov_tipo(movimiento.getMov_tipo());
			updateMovimiento.setMov_usu_id(movimiento.getMov_usu_id());
			updateMovimiento.setArti_id(movimiento.getArti_id());
			
			movimientosDaos.save(updateMovimiento);
			return ResponseEntity.ok(updateMovimiento);
 		}else {
			return ResponseEntity.notFound().build();
 		}
	}
}
