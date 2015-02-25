package com.handson.infra;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.handson.entity.User;

@Named
@SessionScoped
public class SessionMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
//	@Inject
//	Logger logger;
	
	
//	@Inject
//	ActiveUsers activeUsers;
	
//	@Inject
//	ApplicationProperties applicationProperties;

	private User user;
	private Calendar ultimoAcesso;
	private Calendar dthLogon;
	private String nroIP;
	private Calendar dthUltimaValidacaoTicket;

//	// Cache de permiss�es
//	private Set<String> authorized = new HashSet<>(); // autorizadas
//	private Set<String> unauthorized = new HashSet<>(); //n�o autorizadas
	
	@PostConstruct
	public void load() {
//		logger.trace("Criando nova sess�o");
	}
	
//	public boolean hasPermission(String key) {
//		if (!isLogged()) {
//			return false;
//		}
//
//		final String keyupper = key.toUpperCase();
//		
//		// Testa se a permiss�o est� no cache de autorizadas
//		if (authorized != null && authorized.contains(keyupper)) {
//			return true;
//		}
//		
//		// Testa se a permiss�o est� no cache de n�o autorizadas
//		if (unauthorized != null && unauthorized.contains(keyupper)) {
//			return false;
//		}
//		
//		// Se n�o estiver no cache, vai no sistema de seguran�a e adiciona o cache adequado
//		if (seguranca.verificaPermissao(user, keyupper)) {
//			authorized.add(keyupper);
//			return true;
//		} else {
//			unauthorized.add(keyupper);
//			return false;
//		}
//	}

	/**
	 * Faz a valida��o do ticket no sistema de seguran�a de X em X minutos.
	 * O tempo pode ser configurado via application.properties.
	 * 
	 */
//	public boolean validaTicket() {
//		Calendar now = Calendar.getInstance();
//		now.add(Calendar.MINUTE, - applicationProperties.getTempoRevalidacaoTicket());
//		if(dthUltimaValidacaoTicket == null || dthUltimaValidacaoTicket.before(now)) {
//			dthUltimaValidacaoTicket = Calendar.getInstance();
//			return seguranca.validaTicket(user);
//		}
//		return true;
//	}
	
	/**
	 * Verifica se o usu�rio possui uma sess�o ativa.
	 * 
	 * @return
	 */
//	public boolean isLogged() {
//		if (user != null && user.getStatus().equals(UserStatus.OK)) {
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean isPrazoSenhaExpirado() {
//		if (user != null && user.getStatus().equals(UserStatus.PRAZO_SENHA_EXPIRADO)) {
//			return true;
//		}
//		return false;
//	}
//
//	public boolean isDocumentoDuplicado() {
//		if (user != null && user.getStatus().equals(UserStatus.DOCUMENTO_DUPLICADO)) {
//			return true;
//		}
//		return false;
//	}
	
//	public boolean isSessaoEncerradaPorOutroLogon() {
//		if (applicationProperties.isLogonUnicoPorUsuario()) {
//			if (activeUsers.possuiAlgumaSessaoAtiva(user)) {
//				if (!user.getSessionId().equals(activeUsers.getUserSessionId(user))) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	// Getters & Setters

	public String getNroIP() {
		return nroIP;
	}

	public void setNroIP(String nroIP) {
		this.nroIP = nroIP;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Set<String> getAuthorized() {
//		return authorized;
//	}

	public Calendar getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Calendar ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Calendar getDthLogon() {
		return dthLogon;
	}

	public void setDthLogon(Calendar dthLogon) {
		this.dthLogon = dthLogon;
	}

}