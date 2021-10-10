package com.init.products;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class controles {

	
	@GetMapping({"/" , "login"})
	public String getIndex() {
	
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
	
		return "menu";
	}
	
	@GetMapping("/user")
	public String user() {
	
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
	
		return "admin";
	}
	

	@GetMapping("/menu/formproducto")
	public String formproducto() {
	
		return "formproducto";
	}
	
	@GetMapping("/menu/formclientes")
	public String formclientes() {
	
		return "formclientes";
	}
	
	@GetMapping("/menu/formmovimientos")
	public String formmovimientos() {
	
		return "formmovimientos";
	}
	
	@GetMapping("/menu/formprove")
	public String formprove(){
	
		return "formprove";
	}
	
}
