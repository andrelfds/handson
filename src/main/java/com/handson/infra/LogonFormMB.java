package com.handson.infra;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * Managed Bean para suporte as p�ginas de logon e altera��o de senha.
 * 
 * @author mauricio-wodarski
 *
 */
@Named
//@ViewAccessScoped
public class LogonFormMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final int EXPIRA_EM = 60 * 60 * 24 * 365; // 1 ano
	
	@Inject
	LogonMB logonMB;

	@Inject
	SessionMB sessionMB;
	
	@Inject
	MessageProvider messageProvider;
	
	LogonForm ed;

	List<String> listaOrganizacao;
	
	// P�gina de redirecionamento quando sess�o expira
	String page;

	String focus;

	private boolean encerrado = false;

	// Actions

	@PostConstruct
	public void init() {
		// Carrega informa��es do cookie
		ed = new LogonForm();
		ed.setOrganizacao(FacesUtil.getCookieValue("ORGANIZACAO"));
		ed.setMatricula(FacesUtil.getCookieValue("MATRICULA"));
//		defineFocus();
	}

	public void logonOrganizacao() {
//		Map<String, String> map = logonMB.getCredential();
//		map.put(ORGANIZACAO, ed.getOrganizacao());
//		map.put(MATRICULA, ed.getMatricula());
//		map.put(SENHA, ed.getSenha());
//		logonMB.logon();
//		activeUsers.addUser(sessionMB.getUser());
		FacesUtil.setCookieValue("ORGANIZACAO", ed.getOrganizacao(), EXPIRA_EM);
		FacesUtil.setCookieValue("MATRICULA", ed.getMatricula(), EXPIRA_EM);
		FacesUtil.setCookieValue("LOGON_POR", "0", EXPIRA_EM);
		doRedirect();
	}
	
	public void limpaOrganizacao() {
		ed.setOrganizacao(null);
		ed.setMatricula(null);
		FacesUtil.removeCookie("ORGANIZACAO");
		FacesUtil.removeCookie("MATRICULA");
	}

	
	/**
	 * Logon por certificado � chamado via POST da aplica��o /cert 
	 * na p�gina logon.xhtml do sistema.
	 *  
	 * @return
	 */
//	public void logonCertificado() {
//		// Pega os par�metros passados pelo /cert
//		final HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//		String desafioAssinado = req.getParameter("response");
//		String sessionId = req.getParameter("sessionId");
//		String certificadoOrganizacao = req.getParameter("certificadoOrganizacao");
//		
//		Map<String, String> map = logonMB.getCredential();
//		map.put("desafioAssinado", desafioAssinado);
//		map.put("sessionId", sessionId);
//		map.put("certificadoOrganizacao", certificadoOrganizacao);
//		ed.setLogonPor("3");
//		logonMB.logon();
//		FacesUtil.setCookieValue(LOGON_POR, "3", EXPIRA_EM);
//
//		// Monta modal para sele��o de Organiza��o
//		if (sessionMB.isDocumentoDuplicado()) {
//			return;
//		}
//
//		activeUsers.addUser(sessionMB.getUser());
//		FacesUtil.setCookieValue(CERTIFICADO_ORGANIZACAO, sessionMB.getUser().getProperties().get("organizacao").toString(), EXPIRA_EM);
//		doRedirect();
//	}

//	public void limpaCertificado() {
//		ed.setCertificadoOrganizacao(null);
//		FacesUtil.removeCookie(CERTIFICADO_ORGANIZACAO);
//	}
	
//	public void logonTicket() {
//		final HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//		String ticket = req.getParameter("ticket");
//		
//		Map<String, String> map = logonMB.getCredential();
//		map.put("ticket", ticket);
//		logonMB.logon();
//
//		activeUsers.addUser(sessionMB.getUser());
//		doRedirect();
//	}

//	public String alteraSenhaLogon() {
//		alteraSenha();
//
//		// Busca permiss�es do usu�rio
//		Set<String> permissoes = seguranca.listaPermissoes(sessionMB.getUser());
//		if (applicationProperties.isVerificaPermissaoLogon() && permissoes != null && permissoes.isEmpty()) {
//			sessionMB.setUser(null);
//			FacesUtil.addErrorMessage(messageProvider.getMessage("seguranca.nao.autorizado"));
//			return "/logon?faces-redirect=true";
//		}
//
//		sessionMB.getAuthorized().addAll(permissoes);
//		return "/index?faces-redirect=true";
//	}
	
//	public void alteraSenha() {
//		Map<String, String> map = logonMB.getCredential();
//		map.put("senhaAtual", ed.getSenhaAtual());
//		map.put("novaSenha", ed.getNovaSenha());
//		map.put("novaSenhaConfirma", ed.getNovaSenhaConfirma());
//		logonMB.alteraSenha();
//		FacesUtil.addInfoMessage(messageProvider.getMessage("seguranca.senha.alterada"));
//	}
	
	public String cancelaAlteraSenha() {
		FacesUtil.getSession().invalidate();
		return "/index?faces-redirect=true";
	}
	
	public String cancelaLogonCertificado() {
		FacesUtil.getSession().invalidate();
		return "/index?faces-redirect=true";
	}

	public String logoff() {
		FacesUtil.getSession().invalidate();
		return "/index?faces-redirect=true";
	}
	
	// Utils, Getters & Setters
	
	public String getPage() {
	    return page;
	}

	public void setPage(String page) {
		if (page != null) {
			if(page.contains("&encerrado=true")) {
				page = page.replaceAll("&encerrado=true", "");
				encerrado = true;
			}
		}
		this.page = page;
	}

	public LogonForm getEd() {
		return ed;
	}
	
//	@SuppressWarnings("unchecked")
//	public List<String> getListaOrganizacao() {
//		if (listaOrganizacao == null) {
//			listaOrganizacao = new ArrayList<>();
//			List<String> temp = (List<String>) sessionMB.getUser().getProperties().get("listaOrganizacao");
//			for (String string : temp) {
//				String[] s = string.split(";");
//				listaOrganizacao.add(s[1]);
//			}
//		}
//		return listaOrganizacao;
//	}

	/**
	 * Retorna o index da �ltima aba utilizada com sucesso pelo usu�rio.
	 * 
	 * @return
	 */
//	public String getSelectedTab() {
//		String selectedTab = FacesUtil.getCookieValue(LOGON_POR);
//		if (selectedTab != null) {
//			if ("1".equals(selectedTab) && applicationProperties.isLogonAbaEmail()) {
//				return "1";
//			} else if ("2".equals(selectedTab) && applicationProperties.isLogonAbaDocumento()) {
//				return "2";
//			} else if ("3".equals(selectedTab) && applicationProperties.isLogonAbaCertificado()) {
//				return "3";
//			}
//		}
//		return "0";
//	}
	
//	private void defineFocus() {
//		if (getSelectedTab().equals("0")) {
//			if (ed.getOrganizacao() != null) {
//				focus = "#tabview\\\\:formOrg\\\\:senha";
//			} else {
//				focus = "#tabview\\\\:formOrg\\\\:organizacao";
//			}
//		}
//		
//		if (getSelectedTab().equals("1")) {
//			if (ed.getEmail() != null) {
//				focus = "#tabview\\\\:formEmail\\\\:senhaEmail";
//			} else {
//				focus = "#tabview\\\\:formEmail\\\\:email";
//			}
//		}
//		
//		if (getSelectedTab().equals("2")) {
//			if (ed.getDocumento() != null) {
//				focus = "#tabview\\\\:formDoc\\\\:senhaDocumento";
//			} else {
//				focus = "#tabview\\\\:formDoc\\\\:documento";
//			}
//		}
//
//		if (getSelectedTab().equals("3")) {
//			if (ed.getCertificadoOrganizacao() != null) {
//				focus = "#tabview\\\\:formCert\\\\:certificadoOrganizacao";
//			}
//		}
//
//	}
	
	public String getFocus() {
		return focus;
	}

	private void doRedirect() {
//		// Monta os avisos retornados
//		@SuppressWarnings("unchecked")
//		Set<String> avisos = (Set<String>) sessionMB.getUser().getProperties().get("avisos");
//		if (avisos != null && !avisos.isEmpty()) {
//			for (String aviso : avisos) {
//				//FacesUtil.addMessage(FacesMessage.SEVERITY_WARN, aviso);
//				FacesUtil.addInfoMessage(aviso);
//			}
//		}

		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/";
		if (page != null) {
			url = page;
		} 

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	public String getEnderecoAssinador() {
//		StringBuilder sb = new StringBuilder();
//		sb.append(Propriedades.getInstance("SOE").getValor("assinador.ws.server"));
//		sb.append("/cert");
//		return sb.toString();
//	}
	
	public String getPageEncoded() {
		if (page != null) {
			try {
				return URLEncoder.encode(page, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	public boolean isEncerrado() {
		return encerrado;
	}
	
//	public Integer getTamanhoMaximoSenha() {
//		if (applicationProperties.getSegurancaImpl() == null) {
//			return 8; // soe
//		}
//		return 20; // sca
//	}

}

