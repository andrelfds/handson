package com.handson.infra;


import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.handson.ejb.UserBean;
import com.handson.entity.User;


@Named
@RequestScoped
public class LogonMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	SessionMB sessionMB;
	
	@Inject
	UserBean userBean;
	
//	@Inject 
//	Logger logger;
	
	@Inject
	MessageProvider messageProvider;
	
	// Actions

	/**
	 * Efetua logon.
	 * @param login 
	 * 
	 * @return
	 */
	public void logon(User login) {
		User user;
		try {
			user = userBean.findUserByPassword(login);
			if (user != null) {
//			user.setSessionId(getSessionId());
				montaSessionMB(user);
//			montaMDC(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void montaMDC(User user) {
//		MDC.put("user-id", user.getId());
//		MDC.put("user-name", user.getName());
//		Map<String, Object> properties = user.getProperties();
//		Set<String> keySet = properties.keySet();
//		for (String k : keySet) {
//			MDC.put(k, (String) properties.get(k));
//		}
//	}

	/**
	 * Altera a senha do usu�rio
	 * 
	 */
	public void alteraSenha() {
//		final String senha = credential.get("senhaAtual");
//		final String novaSenha = credential.get("novaSenha");
//		final String novaSenhaConfirma = credential.get("novaSenhaConfirma");
//		if (!novaSenha.equals(novaSenhaConfirma)) {
//			throw new RNException("novaSenha", messageProvider.getMessage("seguranca.senha.confirma"));
//		}
//		sessionMB.getUser().setStatus(UserStatus.OK); // muda de PRAZO_SENHA_EXPIRADO para OK
	}
	
	/**
	 * Monta a sess�o do usu�rio informado.
	 * 
	 * Caso o usu�rio n�o tenha nenhuma permiss�o no sistema, lan�a RNException.
	 * 
	 * @param user
	 */
	private void montaSessionMB(User user) {
		sessionMB.setUser(user);
		sessionMB.setDthLogon(Calendar.getInstance());
		sessionMB.setNroIP(getRemoteAddr());
	}

	// Getters & Setters

	private String getRemoteAddr() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			return request.getRemoteAddr();
		} catch (Exception e) {
//			logger.warn("N�o foi poss�vel obter o IP do usu�rio.");
			return null;
		}
	}
	
	private String getSessionId() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			return request.getSession().getId();
		} catch (Exception e) {
//			logger.warn("N�o foi poss�vel obter o Id da sess�o do usu�rio.");
			return null;
		}
	}
	
}
