package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.VendaHasProduto;
import com.wassabi.wassabiapp.model.VendaHasProdutoId;
import com.wassabi.wassabiapp.repository.VendaHasProdutoRepository;

@Service("VendaHasProdutoService")
public class VendaHasProdutoService {
    
    @Autowired
    private VendaHasProdutoRepository vendaHasProdutoRepository;

    @Transactional
    public VendaHasProduto saveVendaHasProduto(VendaHasProduto vendaHasProduto){
        vendaHasProduto = vendaHasProdutoRepository.save(vendaHasProduto);
        return vendaHasProduto;
    }

    @Transactional
    public Iterable<VendaHasProduto> saveVendaHasProdutoAll(Iterable<VendaHasProduto> vendaHasProduto){
        vendaHasProduto = vendaHasProdutoRepository.saveAll(vendaHasProduto);
        return vendaHasProduto;
    }

    @Transactional
    public Iterable<VendaHasProduto> getAllVendaHasProduto(){
        return vendaHasProdutoRepository.findAll();
    }

    @Transactional
    public VendaHasProduto getVendaHasProduto(VendaHasProdutoId vendaHasProdutoId){
        return vendaHasProdutoRepository.findById(vendaHasProdutoId).get();
    }

    @Transactional
    public void deleteVendaHasProduto(VendaHasProduto vendaHasProduto) {
        vendaHasProdutoRepository.delete(vendaHasProduto);
    }
}
