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

import com.wassabi.wassabiapp.model.Cartao;
import com.wassabi.wassabiapp.model.CartaoId;
import com.wassabi.wassabiapp.service.CartaoService;

@RestController
public class CartaoController {
    private CartaoService cartaoService;

    @Autowired
	public CartaoController(CartaoService cartaoService) {
		this.cartaoService = cartaoService;
	}

    @GetMapping("/cartao")
    public Iterable<Cartao> getAllCartao(){
        return cartaoService.getAllCartao();
    }

    @RequestMapping(value = "/cartao", params = {"cartaoId", "cartaoCliente"}, method = RequestMethod.GET)
    public Cartao getCartao(@RequestParam("cartaoId") int cartaoId, @RequestParam("cartaoCliente") int cartaoCliente){
        return cartaoService.getCartao(new CartaoId(cartaoId, cartaoCliente));
    }

    @PostMapping(value="/cartao")
    public Cartao createCartao(@RequestBody Cartao cartao) {
        return cartaoService.saveCartao(cartao);
    }

    @PutMapping(value="/cartao")
    public Cartao updateCartao(@RequestBody Cartao cartao) {
        cartao = cartaoService.saveCartao(cartao);
        return cartao;
    }

    @DeleteMapping(value="/cartao")
    public void deleteCartao(@RequestBody Cartao cartao) {
        cartaoService.deleteCartao(cartao);
    }
}
