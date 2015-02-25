package com.handson.stateless;

import java.io.Serializable;

import com.handson.entity.ServicoPreco;

public interface CorreioFacadeStateless extends Serializable {
	
	public abstract ServicoPreco retornaCalculaPreco(ServicoPreco preco);
	
	public abstract org.tempuri.CalcPrecoPrazoWSSoap getService();

}