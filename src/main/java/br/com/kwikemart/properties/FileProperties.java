package br.com.kwikemart.properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.ResourceBundle.getBundle;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import lombok.Getter;

public class FileProperties {
	
	public enum Type {

		EMAIL("email"), MESSAGE("message"), SYSTEM("system");

		@Getter
		private String file;

		private Type(String file) {
			this.file = file;
		}
	}
	
	private static ResourceBundle RESOURCE_BUNDLE;

	public FileProperties(Type type) {
		RESOURCE_BUNDLE = getBundle(type.getFile());
	}

	public String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

	public Integer getInteger(String key) {
        try {
            return parseInt(getString(key));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

	public Long getLong(String key) {
        try {
            return parseLong(getString(key));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

	public Boolean getBoolean(String key) {
        try {
            return parseBoolean(RESOURCE_BUNDLE.getString(key));
        } catch (MissingResourceException e) {
            return null;
        }
    }
    
}
