package com.handson.infra;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class OperadorMB implements Serializable{
	
//	private static final long serialVersionUID = 1L;
//	
//	@Inject
//	private SessionMB sessionMB;
//
//	public OperadorMB() {
//	}
//
//	public OperadorMB(FuncionarioPgeED funcionario, SessionMB sessionMB) {
//		this.funcionario = funcionario;
//		this.sessionMB = sessionMB;
//	}
//
//	@PostConstruct
//	public void init() {
//		setFuncionario(funcionarioPgeRN.consultaPorMatricula(Long.valueOf(getSessionMB().getUser().getProperties().get("matricula").toString())));
//		getFuncionario().setCpf(getSessionMB().getUser().getProperties().get("cpf")!=null?getSessionMB().getUser().getProperties().get("cpf").toString():null);
//		atualizaGruposFuncionario();
//		atualizaAtuacoesPendentes();
//		atualizaTempoLimiteSessao();
//		
//		funcionarioPgeWidgetsED = new FuncionarioPgeWidgetsED();
//		funcionarioPgeWidgetsED.setFuncionarioPge(this.getFuncionario());
//		verificaSeOperadorTemWidgetNaDashboard(funcionarioPgeWidgetsED);
//	}
//	
//	/**Seta o atributo widgetSelecionada como true se o operador possui widgets, caso contrário, seta false.
//	 * Este método observa os métodos inclui e exclui do bean funcionarioPgeWidgetsRN.
//	 * @param funcionarioPgeWidgetsED
//	 */
//	private void verificaSeOperadorTemWidgetNaDashboard(@Observes FuncionarioPgeWidgetsED funcionarioPgeWidgetsED){
//		setWidgetSelecionada(funcionarioPgeWidgetsRN.listaFuncionarioPgeWidgetsED(funcionarioPgeWidgetsED).isEmpty());
//	}
//
//	/**
//	 * Atualiza o tempo limite da sessao do usuário
//	 */
//	public void atualizaFuncionarioPreferencias() {
//		setFuncionarioPreferenciasED(funcionarioPreferenciasRN.consultaFuncionarioPreferencias(funcionario));
//		
//	}
//	
//	public void atualizaTempoLimiteSessao() {
//		atualizaFuncionarioPreferencias();
//		Long tempoExpSessao = getFuncionarioPreferenciasED().getTempoExpSessao();
//		HttpSession session = WebUtilsCpj.getSession();
//		session.setMaxInactiveInterval(tempoExpSessao.intValue() * 60);	
//	}	
//	
//	public FuncionarioPreferenciasED getFuncionarioPreferenciasED() {
//		return funcionarioPreferenciasED;
//	}
//
//	
//	public SessionMB getSessionMB() {
//		return sessionMB;
//	}
//
//
//	/**
//	 * Retorna o CPF do usuário
//	 * @return cpf do usuário logado
//	 */
//	public String getCpf(){
//		return getFuncionario().getCpf();
//	}
//
//
//	}
//	
//	/**
//	 * Encurta o nome do usuário para o seu primeiro e último nome. 
//	 * Por exemplo: Maria Santos Silva -> Maria Silva
//	 * @return nome do usuario resumido
//	 */
//	public String getNomeUsuarioResumido(){
//		String nomeUsuario = funcionario.getNomeFunc();
//		String nomeUsuarioSplit[]; 
//		if(nomeUsuario.contains(" ")){
//			nomeUsuarioSplit = nomeUsuario.split(" ");
//			nomeUsuario = nomeUsuarioSplit[0] + " " + nomeUsuarioSplit[nomeUsuarioSplit.length - 1];
//		}
//		return nomeUsuario;
//	}
	
}
