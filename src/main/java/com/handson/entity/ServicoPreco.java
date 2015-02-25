package com.handson.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.tempuri.CServico;

public class ServicoPreco implements Serializable{
	
	private String empresa;
	private String senha;
	private String servico;
	private String cepOrigem;
	private String cepDestino;
	private String vlPeso;
	private int cdFormato;
	private BigDecimal vlComprimento;
	private BigDecimal vlAltura;
	private BigDecimal vlLargura;
	private BigDecimal vlDiametro;
	private String cdMaoPropria;
	private BigDecimal vlValorDeclarado;
	private String cdAvisoRecebimento;
	
	private String codigo;
	private String valor;
	private String valorMaoPropria;
	private String valorAvisoRecebimento;
	private String valorValorDeclarado;
	private String valorSemAdicionais;
	
	public ServicoPreco(String codigo, String valor, String valorMaoPropria,
			String valorAvisoRecebimento, String valorValorDeclarado,
			String valorSemAdicionais) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.valorMaoPropria = valorMaoPropria;
		this.valorAvisoRecebimento = valorAvisoRecebimento;
		this.valorValorDeclarado = valorValorDeclarado;
		this.valorSemAdicionais = valorSemAdicionais;
	}

	public ServicoPreco() {
	}

	public ServicoPreco(String empresa, String senha, String servico,
			String cepOrigem, String cepDestino, String vlPeso, int cdFormato,
			BigDecimal vlComprimento, BigDecimal vlAltura,
			BigDecimal vlLargura, BigDecimal vlDiametro, String cdMaoPropria,
			BigDecimal vlValorDeclarado, String cdAvisoRecebimento) {
		super();
		this.empresa = empresa;
		this.senha = senha;
		this.servico = servico;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.vlPeso = vlPeso;
		this.cdFormato = cdFormato;
		this.vlComprimento = vlComprimento;
		this.vlAltura = vlAltura;
		this.vlLargura = vlLargura;
		this.vlDiametro = vlDiametro;
		this.cdMaoPropria = cdMaoPropria;
		this.vlValorDeclarado = vlValorDeclarado;
		this.cdAvisoRecebimento = cdAvisoRecebimento;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
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

	public String getVlPeso() {
		return vlPeso;
	}

	public void setVlPeso(String vlPeso) {
		this.vlPeso = vlPeso;
	}

	public int getCdFormato() {
		return cdFormato;
	}

	public void setCdFormato(int cdFormato) {
		this.cdFormato = cdFormato;
	}

	public BigDecimal getVlComprimento() {
		return vlComprimento;
	}

	public void setVlComprimento(BigDecimal vlComprimento) {
		this.vlComprimento = vlComprimento;
	}

	public BigDecimal getVlAltura() {
		return vlAltura;
	}

	public void setVlAltura(BigDecimal vlAltura) {
		this.vlAltura = vlAltura;
	}

	public BigDecimal getVlLargura() {
		return vlLargura;
	}

	public void setVlLargura(BigDecimal vlLargura) {
		this.vlLargura = vlLargura;
	}

	public BigDecimal getVlDiametro() {
		return vlDiametro;
	}

	public void setVlDiametro(BigDecimal vlDiametro) {
		this.vlDiametro = vlDiametro;
	}

	public String getCdMaoPropria() {
		return cdMaoPropria;
	}

	public void setCdMaoPropria(String cdMaoPropria) {
		this.cdMaoPropria = cdMaoPropria;
	}

	public BigDecimal getVlValorDeclarado() {
		return vlValorDeclarado;
	}

	public void setVlValorDeclarado(BigDecimal vlValorDeclarado) {
		this.vlValorDeclarado = vlValorDeclarado;
	}

	public String getCdAvisoRecebimento() {
		return cdAvisoRecebimento;
	}

	public void setCdAvisoRecebimento(String cdAvisoRecebimento) {
		this.cdAvisoRecebimento = cdAvisoRecebimento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorMaoPropria() {
		return valorMaoPropria;
	}

	public void setValorMaoPropria(String valorMaoPropria) {
		this.valorMaoPropria = valorMaoPropria;
	}

	public String getValorAvisoRecebimento() {
		return valorAvisoRecebimento;
	}

	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		this.valorAvisoRecebimento = valorAvisoRecebimento;
	}

	public String getValorValorDeclarado() {
		return valorValorDeclarado;
	}

	public void setValorValorDeclarado(String valorValorDeclarado) {
		this.valorValorDeclarado = valorValorDeclarado;
	}

	public String getValorSemAdicionais() {
		return valorSemAdicionais;
	}

	public void setValorSemAdicionais(String valorSemAdicionais) {
		this.valorSemAdicionais = valorSemAdicionais;
	}
	
}
