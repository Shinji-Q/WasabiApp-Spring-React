package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.model.EnderecoId;
import com.wassabi.wassabiapp.service.EnderecoService;


@RestController
public class EnderecoController {

    private EnderecoService enderecoService;

    @Autowired
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

    @GetMapping("/endereco")
    public Iterable<Endereco> getAllEndereco(){
        return enderecoService.getAllEndereco();
    }

    @RequestMapping(value = "/endereco", params = {"enderecoId", "enderecoCliente"}, method = RequestMethod.GET)
    public Endereco getEndereco(@RequestParam("enderecoId") int enderecoId, @RequestParam("enderecoCliente") int enderecoCliente){
        return enderecoService.getEndereco(new EnderecoId(enderecoId, enderecoCliente));
    }

    @PostMapping(value="/endereco")
    public Endereco createEndereco(@RequestBody Endereco endereco) {
        return enderecoService.saveEndereco(endereco);
    }

    @PutMapping(value="/endereco")
    public Endereco updateEndereco(@RequestBody Endereco endereco) {
        endereco = enderecoService.saveEndereco(endereco);
        return endereco;
    }

    @DeleteMapping(value="/endereco")
    public void deleteEndereco(@RequestBody Endereco endereco) {
        enderecoService.deleteEndereco(endereco);
    }    
    
}
