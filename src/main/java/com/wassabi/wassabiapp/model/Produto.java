package com.wassabi.wassabiapp.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Produto generated by hbm2java
 */
@Entity
@Table(name = "Produto", catalog = "wassabi")
public class Produto implements java.io.Serializable {

	private Integer produtoId;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categoria categoria;
	private String produtoNome;
	private double produtoPreco;
	private String produtoDescricao;
    private String produtoImagem;

    
    @JsonIgnore
	private Set<VendaHasProduto> vendaHasProdutos = new HashSet<VendaHasProduto>(0);

	public Produto() {
	}

	public Produto(Categoria categoria, String produtoNome, double produtoPreco, String produtoDescricao) {
		this.categoria = categoria;
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.produtoDescricao = produtoDescricao;
	}

	public Produto(Categoria categoria, String produtoNome, double produtoPreco, String produtoDescricao,
			Set<VendaHasProduto> vendaHasProdutos) {
		this.categoria = categoria;
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.produtoDescricao = produtoDescricao;
		this.vendaHasProdutos = vendaHasProdutos;
	}

	
    /** 
     * @return Integer
     */
    @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "produto_id", unique = true, nullable = false)
	public Integer getProdutoId() {
		return this.produtoId;
	}

	
    /** 
     * @param produtoId
     */
    public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	
    /** 
     * @return Categoria
     */
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_categoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	
    /** 
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
    /** 
     * @return String
     */
    @Column(name = "produto_nome", nullable = false, length = 30)
	public String getProdutoNome() {
		return this.produtoNome;
	}

	
    /** 
     * @param produtoNome
     */
    public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	
    /** 
     * @return double
     */
    @Column(name = "produto_preco", nullable = false, precision = 30)
	public double getProdutoPreco() {
		return this.produtoPreco;
	}

	
    /** 
     * @param produtoPreco
     */
    public void setProdutoPreco(double produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	
    /** 
     * @return String
     */
    @Column(name = "produto_descricao", nullable = false, length = 80)
	public String getProdutoDescricao() {
		return this.produtoDescricao;
	}

	
    /** 
     * @param produtoDescricao
     */
    public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	
    /** 
     * @return Set<VendaHasProduto>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", orphanRemoval = true)
	public Set<VendaHasProduto> getVendaHasProdutos() {
		return this.vendaHasProdutos;
	}

	
    /** 
     * @param vendaHasProdutos
     */
    public void setVendaHasProdutos(Set<VendaHasProduto> vendaHasProdutos) {
		this.vendaHasProdutos = vendaHasProdutos;
	}


    @Column(name = "produto_imagem", length = 100)
    public String getProdutoImagem() {
        return produtoImagem;
    }


    public void setProdutoImagem(String produtoImagem) {
        this.produtoImagem = produtoImagem;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Produto [produtoId=" + produtoId + ", categoria=" + categoria + ", produtoNome=" + produtoNome
                + ", produtoPreco=" + produtoPreco + ", produtoDescricao=" + produtoDescricao + "]";
    }

}
