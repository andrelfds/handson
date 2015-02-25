package com.handson.infra;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageProvider {

	private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public String getMessage(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return "??"+key+"??";
		}
	}
	
    public String getMessage(String key, Object... params) {
        return MessageFormat.format(getMessage(key), params);
    }
	
}
