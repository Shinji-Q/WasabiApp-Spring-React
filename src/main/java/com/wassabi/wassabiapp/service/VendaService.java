package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Venda;
import com.wassabi.wassabiapp.model.VendaHasProduto;
import com.wassabi.wassabiapp.repository.VendaRepository;

@Service("VendaService")
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaHasProdutoService vendaHasProdutoService;

    @Transactional
    public Venda saveVenda(Venda venda){
        venda = vendaRepository.save(venda);
        System.out.println(venda);
        for (VendaHasProduto vendaHasProduto : venda.getVendaHasProdutos()) {
            vendaHasProduto.getId().setVendaId(venda.getVendaId());
            System.out.println(vendaHasProduto);
            System.out.println("quantidadeeeeeeeeeeee" + vendaHasProduto.getQuantidade());
            
        }
        vendaHasProdutoService.saveVendaHasProdutoAll(venda.getVendaHasProdutos());
        return venda;
    }

    @Transactional
    public Iterable<Venda> getAllVenda(){
        return vendaRepository.findAll();
    }

    @Transactional
    public Venda getVenda(int vendaId){
        return vendaRepository.findById(vendaId).get();
    }

    @Transactional
    public void deleteVenda(Venda venda) {
        vendaRepository.delete(venda);
    }
}
