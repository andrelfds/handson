package com.handson.entity;

import java.io.Serializable;

public class ServicoPrazo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	
	private String prazoEntrega;
	
	private String entregaDomiciliar;
	
	private String entregaSabado;
	
	private String cepOrigem;
	
	private String cepDestino;

	public ServicoPrazo(String codigo, String prazoEntrega,
			String entregaDomiciliar, String entregaSabado) {
		super();
		this.codigo = codigo;
		this.prazoEntrega = prazoEntrega;
		this.entregaDomiciliar = entregaDomiciliar;
		this.entregaSabado = entregaSabado;
	}
	
	public ServicoPrazo(String codigo, String cepOrigem, String cepDestino) {
		super();
		this.codigo = codigo;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
	}



	public ServicoPrazo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getEntregaDomiciliar() {
		return entregaDomiciliar;
	}

	public void setEntregaDomiciliar(String entregaDomiciliar) {
		this.entregaDomiciliar = entregaDomiciliar;
	}

	public String getEntregaSabado() {
		return entregaSabado;
	}

	public void setEntregaSabado(String entregaSabado) {
		this.entregaSabado = entregaSabado;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	
	

}
