package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Cartao;
import com.wassabi.wassabiapp.model.CartaoId;
import com.wassabi.wassabiapp.repository.CartaoRepository;

@Service("CartaoService")
public class CartaoService {
    
    @Autowired
    private CartaoRepository cartaoRepository;

    @Transactional
    public Cartao saveCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    @Transactional
    public Iterable<Cartao> getAllCartao(){
        return cartaoRepository.findAll();
    }

    @Transactional
    public Cartao getCartao(CartaoId cartaoId){
        return cartaoRepository.findById(cartaoId).get();
    }

    @Transactional
    public void deleteCartao(Cartao cartao) {
        cartaoRepository.delete(cartao);
    }
}
