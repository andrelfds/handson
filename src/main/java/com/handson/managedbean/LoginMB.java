/**
 * 
 */
package com.handson.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import com.handson.controller.ControladorAcesso;
import com.handson.ejb.UserBean;
import com.handson.entity.User;
import com.handson.infra.FacesUtil;
import com.handson.infra.LogonMB;

/**
 * @author cassio
 * 
 */

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final String	LOGIN_SUCESS		= "sample.xhtml";
	public static final String	LOGIN_FAIL			= "login_falha";
	public static final String	SESSION_NOT_EXIST	= "sessao_invalida";
	private static final String	OUTCOME_LOGOUT		= "logout";
	public static final String	SESSION_USER		= "usuario";

	private User				login;

//	@EJB
//	private UserBeanRemote		ejb;
	
	@Inject
	private UserBean ejb;
	
	@Inject
	LogonMB logonMB;

	private ControladorAcesso	controladorAcesso;

	public LoginMB() {
	}
	
	private static final int EXPIRA_EM = 60 * 60 * 24 * 365;
	
	@PostConstruct
	public void inicializar() {
		login = new User();
		controladorAcesso = new ControladorAcesso();
		Logger.getLogger(LoginMB.class).log(Level.INFO, ">>>>>>>>>>>>> Inicializando um bean de login.");
	}

	/**
	 * Utilizado para tentativas de login no sistema, confrontando dados
	 * fornecidos * pelo usu�rio com registros de usu�rios cadastrados.
	 * 
	 * @return Outcome associado a fracasso ou sucesso na tentativa de login.
	 * @throws Exception
	 */
	public String doLogin() throws Exception {

//		activeUsers.addUser(sessionMB.getUser());
		FacesUtil.setCookieValue("nome", login.getName(), EXPIRA_EM);
		FacesUtil.setCookieValue("senha", login.getPassword(), EXPIRA_EM);
		if (!ejb.findUserLogado(login)) {
			logonMB.logon(login);
			User usuarioLogado = ejb.findUserByPassword(login);
			usuarioLogado.setStatus(User.ATIVO);
			HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			sessao.setAttribute(SESSION_USER, usuarioLogado);
			controladorAcesso.configurarAcesso();
			// new ServicoAtivarUsuario(usuarioLogado).cadastrar();
			Logger.getLogger(LoginMB.class).log(Level.INFO, ">>>>>>>>>>>>> Logado Usuario: " + usuarioLogado.getName());
			doRedirect();
			return LOGIN_SUCESS;
		}
		return LOGIN_FAIL;
	}
	

	private void doRedirect() {
		
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/";

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * * Utilizado para finalizar uma sess�o de um usu�rio no sistema. * * @return
	 * Outcome associado a fracasso ou sucesso na tentativa de logout.
	 */
	public String doLogout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User usuarioSessao = (User) sessao.getAttribute(SESSION_USER);
		if (usuarioSessao != null) {
			usuarioSessao.setStatus(User.INATIVO);
			// new ServicoDesativarUsuario(usuarioSessao).cadastrar();
		}
		context.getExternalContext().invalidateSession();
		
		 FacesMessage msg = new FacesMessage("LOGOUT  " + usuarioSessao.getName());
         FacesContext.getCurrentInstance().addMessage(null, msg);
		return OUTCOME_LOGOUT;
		
	}

	/**
	 * * M�todo utilizado para verificar se um usu�rio tentando logar na
	 * aplica��o * j� n�o possui alguma sess�o aberta em outro navegador ou
	 * outra aba. A * aplica��o est� barrando m�ltiplos acessos simult�neos de
	 * um usu�rio. * * @return <code>true</code> se j� existir uma sess�o ativa
	 * para o usu�rio. * <code>false</code> caso contr�rio.
	 */

	public ControladorAcesso getControladorAcesso() {
		return controladorAcesso;
	}

	public User getLogin() {
		return login;
	}

	public void setLogin(User login) {
		this.login = login;
	}

}
