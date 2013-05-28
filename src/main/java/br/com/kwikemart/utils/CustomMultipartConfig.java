package br.com.kwikemart.utils;

import br.com.caelum.vraptor.interceptor.multipart.DefaultMultipartConfig;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class CustomMultipartConfig extends DefaultMultipartConfig {

	private static final int ONE_MEGABYTE = 1 * 1024 * 1024;

	public long getSizeLimit() {
		return ONE_MEGABYTE;
	}

}