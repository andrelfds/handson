package com.handson.stateless;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWS;

import com.handson.entity.ServicoPreco;

@Stateless
@Remote(CorreioFacadeStateless.class) 
public class CorreioFacadeImpStateless implements CorreioFacadeStateless {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private org.tempuri.CalcPrecoPrazoWS soap;
	private org.tempuri.CalcPrecoPrazoWSSoap service;


	public org.tempuri.CalcPrecoPrazoWSSoap getService() {
		URL portAddress;
		try {
			if(service == null){
				portAddress = new URL("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?WSDL");
				soap = new CalcPrecoPrazoWS(portAddress);
				service = soap.getCalcPrecoPrazoWSSoap();				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return service;
	}
	
	
	public ServicoPreco retornaCalculaPreco(ServicoPreco servico) {
		CResultado calcPreco = getService().calcPreco(servico.getEmpresa(), servico.getSenha(), servico.getServico(), servico.getCepOrigem(), servico.getCepDestino(), 
				servico.getVlPeso(), servico.getCdFormato(), servico.getVlComprimento(), servico.getVlAltura(), servico.getVlLargura(), 
				servico.getVlDiametro(), servico.getCdMaoPropria(), servico.getVlValorDeclarado(), servico.getCdAvisoRecebimento());
		
		CServico cServico = calcPreco.getServicos().getCServico().get(0);
		ServicoPreco preco =  new ServicoPreco(String.valueOf(cServico.getCodigo()), cServico.getValor(), cServico.getValorMaoPropria(), 
				cServico.getValorAvisoRecebimento(), cServico.getValorValorDeclarado(), cServico.getValorSemAdicionais());
		return preco;
		
	}

}
