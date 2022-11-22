package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Venda;
import com.wassabi.wassabiapp.service.VendaService;

@CrossOrigin(origins = "http://localhost:80")
@RestController
public class VendaController {
    private VendaService vendaService;

    @Autowired
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}

    @GetMapping("/venda")
    public Iterable<Venda> getAllVenda(){
        return vendaService.getAllVenda();
    }

    @GetMapping("/venda/{vendaId}")
    public Venda getVenda(@PathVariable int vendaId){
        return vendaService.getVenda(vendaId);
    }

    @PostMapping(value="/venda")
    public Venda createVenda(@RequestBody Venda venda) {
        return vendaService.saveVenda(venda);
    }

    @PutMapping(value="/venda")
    public Venda updateVenda(@RequestBody Venda venda) {
        venda = vendaService.saveVenda(venda);
        return venda;
    }

    @DeleteMapping(value="/venda")
    public void deleteVenda(@RequestBody Venda venda) {
        vendaService.deleteVenda(venda);
    }
}
