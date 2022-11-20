package com.wassabi.wassabiapp.repository;

import java.io.File;
import java.util.HashSet;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import com.wassabi.wassabiapp.model.Cartao;
import com.wassabi.wassabiapp.model.Categoria;
import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.model.Produto;
import com.wassabi.wassabiapp.model.Usuario;
import com.wassabi.wassabiapp.model.UsuarioTipo;
import com.wassabi.wassabiapp.model.Venda;
import com.wassabi.wassabiapp.service.CategoriaService;
import com.wassabi.wassabiapp.service.ClienteService;
import com.wassabi.wassabiapp.service.ProdutoService;
import com.wassabi.wassabiapp.service.UsuarioService;
import com.wassabi.wassabiapp.service.VendaService;
import com.wassabi.wassabiapp.util.FileToMultipartFile;

@SpringBootTest
public class Populate {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    VendaService vendaService;

    @Test
    public void populatePromocao(){
        MultipartFile file = getImageFileSystem("bd/images/melhor_lig.png");
        Categoria categoria = new Categoria("Promoção", "Promoção");
        categoria = categoriaService.saveCategoria(categoria);
        Produto produto1 = new Produto(categoria, "Combo Promo 01 (15 Peças)", 40.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto1, file);
        Produto produto2 = new Produto(categoria, "Combo Promo 02 (15 Peças)", 53.90, "4 Sashimi de Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto2, file);
        Produto produto3 = new Produto(categoria, "Combo Promo 03 (15 Peças)", 49.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto3, file);
        Produto produto4 = new Produto(categoria, "Combo Promo 04 (15 Peças)", 48.50, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto4, file);
    }

    @Test
    public void populateTemaki(){
        MultipartFile file = getImageFileSystem("bd/images/melhor_lig.png");
        Categoria categoria = new Categoria("Temaki", "Não tem");
        categoria = categoriaService.saveCategoria(categoria);
        Produto produto1 = new Produto(categoria, "Temaki 01 (15 Peças)", 40.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto1, file);
        Produto produto2 = new Produto(categoria, "Temaki 02 (15 Peças)", 53.90, "4 Sashimi de Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto2, file);
        Produto produto3 = new Produto(categoria, "Temaki 03 (15 Peças)", 49.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto3, file);
        Produto produto4 = new Produto(categoria, "Temaki 04 (15 Peças)", 48.50, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto4, file);
    }


    @Test
    public void populateEntradas(){
        MultipartFile file = getImageFileSystem("bd/images/melhor_lig.png");
        Categoria categoria = new Categoria("Entradas", "Não tem");
        categoria = categoriaService.saveCategoria(categoria);
        Produto produto1 = new Produto(categoria, "Entradas 01 (15 Peças)", 40.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto1, file);
        Produto produto2 = new Produto(categoria, "Entradas 02 (15 Peças)", 53.90, "4 Sashimi de Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto2, file);
        Produto produto3 = new Produto(categoria, "Entradas 03 (15 Peças)", 49.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto3, file);
        Produto produto4 = new Produto(categoria, "Entradas 04 (15 Peças)", 48.50, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto4, file);
    }


    @Test
    public void populateWassabi(){
        MultipartFile file = getImageFileSystem("bd/images/melhor_lig.png");
        Categoria categoria = new Categoria("Wassabi", "Não tem");
        categoria = categoriaService.saveCategoria(categoria);
        Produto produto1 = new Produto(categoria, "Wassabi 01 (15 Peças)", 40.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto1, file);
        Produto produto2 = new Produto(categoria, "Wassabi 02 (15 Peças)", 53.90, "4 Sashimi de Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto2, file);
        Produto produto3 = new Produto(categoria, "Wassabi 03 (15 Peças)", 49.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto3, file);
        Produto produto4 = new Produto(categoria, "Wassabi 04 (15 Peças)", 48.50, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3");
        produtoService.saveProduto(produto4, file);
    }


    @Test
    public void populateUsuario(){
        Usuario usuario = new Usuario("amgabriel1@hotmail.com", "1234", UsuarioTipo.CONSUMIDOR.toString());
        Cliente cliente = new Cliente("Alfredoo", "Gabriel", "000.000.000-00", "(91) 98448-7808");
        usuario.setCliente(cliente);
        for (int i = 0; i < 10; i++) {
            usuarioService.saveUsuario(usuario);
        }
    }

    @Test
    public void populateEndereco(){
        clienteService.getAllCliente().forEach(cliente -> {
            Endereco end = new Endereco(cliente, "Rua", "bai", "cidade", "estado", "cep", "pais");
            cliente.setEnderecos(new HashSet<Endereco>());
            cliente.setCartaos(new HashSet<Cartao>());
            cliente.addEndereco(end);
            clienteService.saveCliente(cliente);
        });
    }
    
    
    @Test
    public void populateCartao(){
        clienteService.getAllCliente().forEach(cliente -> {
            Cartao cartao = new Cartao(cliente, "0000000000000000");
            cliente.setEnderecos(new HashSet<Endereco>());
            cliente.setCartaos(new HashSet<Cartao>());
            cliente.addCartao(cartao);
            clienteService.saveCliente(cliente);
        });
    }

    @Test
    public void pupulateVenda(){
        Random random = new Random();
        for (Produto produto : produtoService.getAllProduto()) {
            for (Cliente cliente : clienteService.getAllCliente()) {
                Venda venda = new Venda(cliente);
                venda.addProduto(produto, random.nextInt(10));
                vendaService.saveVenda(venda);
            }            
        }
    }


    private FileToMultipartFile getImageFileSystem(String filePath) {
        File file = new File(filePath);
        FileToMultipartFile multi = new FileToMultipartFile(file);
        return multi;
    }
}
