package com.handson.client;

import java.math.BigDecimal;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.handson.entity.ServicoPrazo;
import com.handson.entity.ServicoPreco;
import com.handson.stateless.CorreioFacadeImpStateless;
import com.handson.stateless.CorreioFacadeStateless;


public class RemoteEJB3Client {

	public static void main(String[] args) throws Exception {
		testRemoteEJB();

	}

	private static void testRemoteEJB() throws NamingException {

		ServicoPrazo servico = new ServicoPrazo("41106", "92330350", "99400000");
//		final CorreioFacadeStateful ejbStateful = lookupRemoteStatefulEJB();
//		ServicoPrazo retornaCalculaPrazo = ejbStateful.retornaCalculaPrazo(servico);
//		
//		final int NUM_TIMES = 5;
//		System.out.println("incrementado " + NUM_TIMES);
//		for (int i = 0; i < NUM_TIMES; i++) {
//			System.out.println("incrementando");
//			ejbStateful.increment();
//			System.out.println("Valor Final " + ejbStateful.getCount() + "dentro do EJB");
//		}
//		
//		System.out.println("decrementado " + NUM_TIMES);
//		for (int i = NUM_TIMES; i > 0; i--) {
//			System.out.println("decrementando");
//			ejbStateful.decrement();
//			System.out.println("Valor Final " + ejbStateful.getCount() + "dentro do EJB");
//		}

//		System.out.println(retornaCalculaPrazo.getCodigo());
//		System.out.println(retornaCalculaPrazo.getPrazoEntrega());
//		System.out.println(retornaCalculaPrazo.getEntregaDomiciliar());
//		System.out.println(retornaCalculaPrazo.getEntregaSabado());
		
		ServicoPreco preco = new ServicoPreco("", "", "41106", "92330-350", "99400-000", "20", 
				1, new BigDecimal(60), new BigDecimal(60), new BigDecimal(60), new BigDecimal(60), 
				"S", new BigDecimal(0), "");
		
		final CorreioFacadeStateless ejbStateless = lookupRemoteStatelessEJB();
		ServicoPreco retornaCalculaPreco = ejbStateless.retornaCalculaPreco(preco);
		
		
		System.out.println(retornaCalculaPreco.getCodigo());
		System.out.println(retornaCalculaPreco.getValor());
		System.out.println(retornaCalculaPreco.getValorMaoPropria());
		System.out.println(retornaCalculaPreco.getValorAvisoRecebimento());
		System.out.println(retornaCalculaPreco.getValorValorDeclarado());
		System.out.println(retornaCalculaPreco.getValorSemAdicionais());
		
	}

	private static CorreioFacadeStateless lookupRemoteStatelessEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		final Context context = new InitialContext(jndiProperties);
		
		
		final String appName = "";
		final String moduleName = "handson";
		final String distinctName = "";
		final String beanName = CorreioFacadeImpStateless.class.getSimpleName();
		
		final String viewClassName = CorreioFacadeStateless.class.getName();
		System.out.println("Looking EJB via JNDI ");
		System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		
		return (CorreioFacadeStateless) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		
		
	}

}
