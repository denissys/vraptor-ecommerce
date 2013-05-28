package br.com.kwikemart.bo;

import java.io.Serializable;

/**
 * This object instruct the json request reply.
 * 
 * @author Denis Santos
 */
public class JsonViewResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean redirect;

	private String urlRedirect;

	private boolean success;

	private String message;

	public JsonViewResponse(boolean redirect, String urlRedirect,
			boolean success) {
		super();
		this.redirect = redirect;
		this.urlRedirect = urlRedirect;
		this.success = success;
	}

	/**
	 * Message constructor
	 * 
	 * @param success
	 * @param message
	 */
	public JsonViewResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public JsonViewResponse(boolean redirect, String urlRedirect,
			boolean success, String message) {
		super();
		this.redirect = redirect;
		this.urlRedirect = urlRedirect;
		this.success = success;
		this.message = message;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getUrlRedirect() {
		return urlRedirect;
	}

	public void setUrlRedirect(String urlRedirect) {
		this.urlRedirect = urlRedirect;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
