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
        Categoria categoria = new Categoria("Promoção", "Promoção");
        categoria = categoriaService.saveCategoria(categoria);
        
        Produto produto1 = new Produto(categoria, "Combo Promo 01 (15 Peças)", 40.90, "10 Hol De Salmao Grelhado Com Batata Palha Doce, 3 Niguiris De Skin Com Maionese Wasabi, 2 Gunkans De Biscoitinho Com Geleia");
        MultipartFile file1 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/promocao/ComboPromo01.png");
        produtoService.saveProduto(produto1, file1);
        
        Produto produto2 = new Produto(categoria, "Combo Promo 02 (15 Peças)", 53.90, "4 Sashimi De Salmao, 2 Gunkas Maçaricado Com Molho De Manga, 2 Gunkas De Biscoito Tempura E Geleia De Pimenta, 2 Gunkas De Couve, 5 Hots De Salmao Grelhado Com Pate De Anchova");
        MultipartFile file2 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/promocao/ComboPromo02.png");
        produtoService.saveProduto(produto2, file2);

        Produto produto3 = new Produto(categoria, "Combo Promo 03 (15 Peças)", 49.90, "5 Makimono Skin Com Pesto De Jambu, 5 Hot De Kani Com Pate De Salmao Grelhadoe Cebolinha, 3 Sashimi De Salmao, 2 Biguiri De Polvo");
        MultipartFile file3 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/promocao/ComboPromo03.png");
        produtoService.saveProduto(produto3, file3);
        
        Produto produto4 = new Produto(categoria, "Combo Promo 04 (15 Peças)", 48.50, "3 Gunkan Com Patê De Polvo Apimentado 2 Niguiris De Kani 2 Niguiris De Skin 5 Peças De Salmão Grelhado Com Geléia De Pimenta 3 Sa Shimis De Atum");
        MultipartFile file4 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/promocao/ComboPromo04.png");
        produtoService.saveProduto(produto4, file4);
        
        Produto produto5 = new Produto(categoria, "Combo Promo 05 (15 Peças)", 45.50, "5 Hot De Salmão Com Palha De Couve Doce 2 Niguiris De Atum 3 Niguiris De Salmão 5 Hot Makinono De Camarão Com Patê De Salmão Grelhado Com Cream Cheese Por Cima.");
        MultipartFile file5 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/promocao/ComboPromo05.png");
        produtoService.saveProduto(produto5, file5);
        
        Produto produto6 = new Produto(categoria, "Promo Vegano (15 PEÇAS)", 40.90, "5 Makimono De Shimeji Com Palha De Couve, 5 Hot Manga Com Pipinoe Bicoitinho Tempura,2 Gunkas De Pipino Com Molho De Manga E Pimenta Biquinho, 3 Niguiri De Tofu Maçaricado Com Geleia De Pimenta");
        MultipartFile file6 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/promocao/ComboVegano.png");
        produtoService.saveProduto(produto6, file6);
    }

    @Test
    public void populateTemaki(){
        
        Categoria categoria = new Categoria("Temaki", "Temaki especial");
        categoria = categoriaService.saveCategoria(categoria);
        
        Produto produto1 = new Produto(categoria, "TEMAKI EXOTIC", 41.50, "Salmão, kani, shimeji fritos na manteiga e cream cheese, arroz e alga nori");
        MultipartFile file1 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/temaki/TemakiExotic.png");
        produtoService.saveProduto(produto1, file1);
        
        Produto produto2 = new Produto(categoria, "TEMAKI PORÓ", 42.50, "Salmão misturado com alho poró na casquinha de massa harumaki, arroz e cream cheese.");
        MultipartFile file2 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/temaki/TemakiPoro.png");
        produtoService.saveProduto(produto2, file2);

        Produto produto3 = new Produto(categoria, "TEMAKI SALMÃO ESPECIAL", 43.50, "Salmão grelhado na casquinha de massa harumaki, cream cheese, arroz e biscoitinho tempurá.");
        MultipartFile file3 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/temaki/TemakiSalmaoEspecial.png");
        produtoService.saveProduto(produto3, file3);
        
        Produto produto4 = new Produto(categoria, "TEMAKI WASABI", 46.50, "Salmão grelhado, camarão, cream cheese, arroz, alga nori e cebolinha.");
        MultipartFile file4 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/temaki/TemakiWasabi.png");
        produtoService.saveProduto(produto4, file4);
        
        Produto produto5 = new Produto(categoria, "TEMAKI WASABI ESPECIAL", 45.50, "Recheio de hot bowling de salmão, coberto por cream cheese, arroz, alga nori e biscoitinho tempurá.");
        MultipartFile file5 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/temaki/TemakiWasabiEspecial.png");
        produtoService.saveProduto(produto5, file5);
        
        Produto produto6 = new Produto(categoria, "TEMAKI FILADELFIA MIX", 31.40, "Salmão Batido Com Cream Cheese, arroz, na alga nori E Cebolinha");
        MultipartFile file6 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/temaki/TemakiFiladelfiaMix.png");
        produtoService.saveProduto(produto6, file6);
    }


    @Test
    public void populateEntradas(){
        Categoria categoria = new Categoria("Entradas", "Não tem");
        categoria = categoriaService.saveCategoria(categoria);

        Produto produto1 = new Produto(categoria, "SALMÃO EM CONSUMER", 39.00, "Salmão Em Consumer Com Base De Purê De Batata Doce, Queijo Do Marajó Maçaricado E Toque De Azeite De Trufas Brancas");
        MultipartFile file1 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/entradas/SalmaoConsumer.png");
        produtoService.saveProduto(produto1, file1);
        
        Produto produto2 = new Produto(categoria, "LULA EM ANÉIS GRELHADA", 41.00, "Anéis De Lula Grelhada Em Fogo Brando Com Farofa De Polvo Do Mediterrâneo E Ervas Aromáticas");
        MultipartFile file2 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/entradas/LulaGrelhada.png");
        produtoService.saveProduto(produto2, file2);

        Produto produto3 = new Produto(categoria, "BOLINHAS DE SALMÃO FRITAS", 28.50, "10 unidades de salmão temperado com limão e cebolinha, empanados com farinha panko.");
        MultipartFile file3 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/entradas/BolinhasSalmao.png");
        produtoService.saveProduto(produto3, file3);
        
        Produto produto4 = new Produto(categoria, "GUIOZA (5 UNIDADES)", 32.00, "Pastel oriental de carne. Podendo ser frita ou a vapor.");
        MultipartFile file4 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/entradas/Guioza.png");
        produtoService.saveProduto(produto4, file4);
        
        Produto produto5 = new Produto(categoria, "MISSOSHIRU", 21.50, "Sopa, tofu, aguê e cebolinha.");
        MultipartFile file5 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/entradas/Missoshiru.png");
        produtoService.saveProduto(produto5, file5);
        
        Produto produto6 = new Produto(categoria, "NIKUMAN BOVINO", 30.50, "3 Unidades De Pãozinhos De Origem Chinesa Com Recheio De Carne Bovina.");
        MultipartFile file6 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/entradas/NikumanBovino.png");
        produtoService.saveProduto(produto6, file6);
    }


    @Test
    public void populateWassabi(){
        Categoria categoria = new Categoria("Wassabi", "Não tem");
        categoria = categoriaService.saveCategoria(categoria);

        Produto produto1 = new Produto(categoria, "HOLL TARTAR DE SALMÃO", 46.50, "10 peças de holl de Salmão e cream cheese, arroz, alga nori, gergelim, com tartare de salmão fresco por cima.");
        MultipartFile file1 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/wassabi/HollTartar.png");
        produtoService.saveProduto(produto1, file1);
        
        Produto produto2 = new Produto(categoria, "KASAI", 47.50, "10 peças de holl de Camarão, cream cheese, envolvido por finas camadas de salmão maçaricado e coberto com raspas de limão siciliano, arroz e alga nori");
        MultipartFile file2 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/wassabi/Kasai.png");
        produtoService.saveProduto(produto2, file2);

        Produto produto3 = new Produto(categoria, "MEGASABI", 47.50, "10 peças de holl de Salmão, camarão, cream cheese, gergelim, coberto com pasta de kani e cebolinha, arroz e alga nori");
        MultipartFile file3 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/wassabi/Megasabi.png");
        produtoService.saveProduto(produto3, file3);
        
        Produto produto4 = new Produto(categoria, "SKINMAKI", 42.50, "10 peças de holl de Salmão, cream cheese, arroz, alga nori, gergelim, envolto com salmão skin.");
        MultipartFile file4 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/wassabi/Skinmaki.png");
        produtoService.saveProduto(produto4, file4);
        
        Produto produto5 = new Produto(categoria, "WASABI ESPECIAL FIT 10 PEÇAS", 50.50, "Salmão, cream cheese, alga nori, envolto com salmão maçaricado. (sem arroz).");
        MultipartFile file5 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/wassabi/WasabiEspecialFit.png");
        produtoService.saveProduto(produto5, file5);
        
        Produto produto6 = new Produto(categoria, "WASABI HOLL", 46.50, "10 pecas peças de holl Salmão grelhado, cream cheese, arroz, alga nori, gergelim, coberto com biscoitinho tempurá.");
        MultipartFile file6 = getImageFileSystem("src/test/java/com/wassabi/wassabiapp/repository/wassabi/WasabiRoll.png");
        produtoService.saveProduto(produto6, file6);
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
            System.out.println(cliente);
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
