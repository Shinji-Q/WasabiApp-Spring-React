package com.wassabi.wassabiapp.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Cartao", catalog = "wassabi")
public class Cartao implements java.io.Serializable {

	private CartaoId id;
    @JsonIgnore
	private Cliente cliente;
	private String cartaoNumero;

	public Cartao() {
	}

	public Cartao(CartaoId id, Cliente cliente, String cartaoNumero) {
		this.id = id;
		this.cliente = cliente;
		this.cartaoNumero = cartaoNumero;
	}

    public Cartao(Cliente cliente, String cartaoNumero) {
        this.id = new CartaoId();
		this.cliente = cliente;
		this.cartaoNumero = cartaoNumero;
	}


	
    /** 
     * @return CartaoId
     */
    @EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cartaoId", column = @Column(name = "cartao_id", nullable = false)),
			@AttributeOverride(name = "cartaoCliente", column = @Column(name = "cartao_cliente", nullable = false)) })
	public CartaoId getId() {
		return this.id;
	}

	
    /** 
     * @param id
     */
    public void setId(CartaoId id) {
		this.id = id;
	}

	
    /** 
     * @return Cliente
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartao_cliente", nullable = false, insertable = false, updatable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	
    /** 
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
    /** 
     * Retorna o número do cartão de credito.
     * @return String
     */
    @Column(name = "cartao_numero", nullable = false, length = 16)
	public String getCartaoNumero() {
		return this.cartaoNumero;
	}

	
    /** 
     * Define o número do cartão de Credito.
     * @param cartaoNumero
     */
    public void setCartaoNumero(String cartaoNumero) {
		this.cartaoNumero = cartaoNumero;
	}

    
    /** 
     * Sobreescreve a forma de representação do Cartão de credito.
     * @return String
     */
    @Override
    public String toString() {
        return "Cartao [id=" + id + ", cliente=" + cliente + ", cartaoNumero=" + cartaoNumero + "]";
    }

}
