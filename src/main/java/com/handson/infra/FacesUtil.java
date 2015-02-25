package com.handson.infra;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.util.ComponentUtils;

/**
 * M�todos utilit�rios para JSF.
 * 
 * @author mauricio-wodarski
 *
 */
public class FacesUtil {

	/**
	 * Adiciona uma Error Message global no FacesContext.
	 * 
	 * @param message
	 */
//	public static void addErrorMessage(String message) {
//		addErrorMessage(null, message);
//	}

	/**
	 * Adiciona uma Error Message espec�fica de um componente e	faz o setValid(false) do mesmo.
	 * Se o componente n�o for encontrado, adiciona uma Error Message global.
	 * 
	 * @param id ID do componente JSF
	 * @param message
	 */
//	public static void addErrorMessage(String id, String message) {
//		createMessage(getContext(), FacesMessage.SEVERITY_ERROR, id, message);
//	}

	/**
	 * Adiciona uma Fatal Message global no FacesContext.
	 * 
	 * @param message
	 */
//	public static void addFatalMessage(String message) {
//		addFatalMessage(null, message);
//	}

	/**
	 * Adiciona uma Fatal Message espec�fica de um componente e	faz o setValid(false) do mesmo.
	 * Se o componente n�o for encontrado, adiciona uma Fatal Message global.
	 * 
	 * @param id ID do componente JSF
	 * @param message
	 */
//	public static void addFatalMessage(String id, String message) {
//		createMessage(getContext(), FacesMessage.SEVERITY_FATAL, id, message);
//	}

	/**
	 * Adiciona uma Info Message global no FacesContext.
	 * 
	 * @param message
	 */
//	public static void addInfoMessage(String message) {
//		addInfoMessage(null, message);
//	}

	/**
	 * Adiciona uma Info Message espec�fica de um componente.
	 * Se o componente n�o for encontrado, adiciona uma Info Message global.
	 * 
	 * @param id ID do componente JSF
	 * @param message
	 */
//	public static void addInfoMessage(String id, String message) {
//		createMessage(getContext(), FacesMessage.SEVERITY_INFO, id, message);
//	}

	/**
	 * Adiciona uma Warn Message global no FacesContext.
	 * 
	 * @param message
	 */
//	public static void addWarnMessage(String message) {
//		addWarnMessage(null, message);
//	}

	/**
	 * Adiciona uma Warn Message espec�fica de um componente.
	 * Se o componente n�o for encontrado, adiciona uma Warn Message global.
	 * 
	 * @param id ID do componente JSF
	 * @param message
	 */
//	public static void addWarnMessage(String id, String message) {
//		createMessage(getContext(), FacesMessage.SEVERITY_WARN, id, message);
//	}

	/**
	 * Adiciona uma Message global no FacesContext.
	 * 
	 * @param severity
	 * @param message
	 */
//	public static void addMessage(Severity severity, String message) {
//		addMessage(severity, null, message);
//	}

	/**
	 * Adiciona uma Message espec�fica de um componente.
	 * Se o componente n�o for encontrado, adiciona uma Message global.
	 * Se a severidade informado for ERROR ou FATAL, faz o setValid(false) no componente.
	 * 
	 * @param severity
	 * @param id ID do componente JSF
	 * @param message
	 */
//	public static void addMessage(Severity severity, String id, String message) {
//		createMessage(getContext(), severity, id, message);
//	}
	
	/**
	 * Encontra um componente na View JSF.
	 * 
	 * @param id ID do componente JSF.
	 * @return
	 */
//	public static UIComponent findComponent(String id) {
//		return findComponent(getContext(), id);
//	}
	
	/**
	 * Encontra um componente na View JSF.
	 * 
	 * @param context FacesContext
	 * @param id ID do componente JSF.
	 * @return
	 */
//	public static UIComponent findComponent(FacesContext context, String id) {
//		if (id == null) {
//			return null;
//		}
//		return ComponentUtils.findComponent(context.getViewRoot(), id);
//	}

	/**
	 * Obt�m o objeto Session.
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return getSession(getContext());
	}
	
	/**
	 * Obt�m o objeto Session a partir do FacesContext informado.
	 * 
	 * @param context
	 * @return
	 */
	public static HttpSession getSession(FacesContext context) {
		return getRequest(context).getSession();
	}
	
	/**
	 * Obt�m o objeto Request a partir do FacesContext informado.
	 * 
	 * @param context
	 * @return
	 */
	public static HttpServletRequest getRequest(FacesContext context) {
		return (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
	/**
	 * Obt�m o objeto Response a partir do FacesContext informado.
	 * 
	 * @param context
	 * @return
	 */
	public static HttpServletResponse getResponse(FacesContext context) {
		return (HttpServletResponse) context.getExternalContext().getResponse();
	}
	
	/**
	 * Obt�m o FacesContext.
	 * 
	 * @return
	 */
	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}
	
	/**
     * Obt�m o valor do cookie informado.
     * 
     * @param name Nome do cookie
     */
    public static String getCookieValue(String name) {
        return getCookieValue(getRequest(getContext()), name);
    }
    
    /**
     * Obt�m o valor do cookie informado.
     * 
     * @param request Objeto Request
     * @param name Nome do cookie 
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
        if (cookies != null && name != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Cria um cookie com o valor e tempo de expira��o informados.
     * 
     * @param name Nome do cookie
     * @param value Valor do cookie
     * @param maxAge Tempo de expira��o em segundos. Se informado zero, expira��o � imediata.
     */
    public static void setCookieValue(String name, String value, int maxAge) {
        setCookieValue(getResponse(getContext()), name, value, maxAge);
    }
    
    /**
     * Cria um cookie com o valor e tempo de expira��o informados.
     *
     * @param response Objeto response
     * @param name Nome do cookie
     * @param value Valor do cookie
     * @param maxAge Tempo de expira��o em segundos. Se informado zero, expira��o � imediata.
     */
    public static void setCookieValue(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
    }
    
    /**
     * Remove o cookie.
     * 
     * @param name Nome do cookie
     */
    public static void removeCookie(String name) {
    	removeCookie(getResponse(getContext()), name);
    	
    }
    
    /**
     * Remove o cookie.
     * 
     * @param response Objeto Response
     * @param name Nome do cookie
     */
    public static void removeCookie(HttpServletResponse response, String name) {
    	setCookieValue(response, name, "", 0);
    }
    
    // Utils
    
//	private static void createMessage(FacesContext context, Severity severity, String id, String message) {
//		UIComponent component = findComponent(context, id);
//		if (component == null) {
//			context.addMessage(null, new FacesMessage(severity, null, message));
//			return;
//		}
//		String clientId = component.getClientId();
//		context.addMessage(clientId, new FacesMessage(severity, null, message));
//		if (severity == FacesMessage.SEVERITY_ERROR || severity == FacesMessage.SEVERITY_FATAL) {
//			setValidFalse(component);
//		}
//	}
	
	private static void setValidFalse(UIComponent comp) {
		if (comp instanceof EditableValueHolder) {
			((EditableValueHolder) comp).setValid(false);
		}
	}

}

