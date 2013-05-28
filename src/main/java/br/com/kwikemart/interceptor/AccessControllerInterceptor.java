package br.com.kwikemart.interceptor;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.bronx.vraptor.restrictrex.annotation.Roles;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.com.kwikemart.enums.Role;
import br.com.kwikemart.session.LoggedUser;

/**
 * Logged User Validate
 * 
 * @author Denis Santos
 */
@Intercepts
public class AccessControllerInterceptor implements Interceptor {

	private Result result;
	private LoggedUser loggedUser;

	public AccessControllerInterceptor(LoggedUser loggedUser, Result result) {
		this.result = result;
		this.loggedUser = loggedUser;
	}

	public boolean accepts(ResourceMethod method) {
		return method.containsAnnotation(LoggedIn.class);
	}

	public void intercept(InterceptorStack stack,
			ResourceMethod resourceMethod, Object resourceInstance)
			throws InterceptionException {

		if (!loggedUser.hasLogged()) {
			this.result.use(Results.http()).sendError(403);
		} else {
			if (resourceMethod.containsAnnotation(Roles.class)) {
				Roles annotation = resourceMethod.getMethod().getAnnotation(Roles.class);
				if (Role.contains(annotation, loggedUser.getUser().getRole())) {
					stack.next(resourceMethod, resourceInstance);
					return;
				}
				this.result.use(Results.http()).sendError(403);
			}
			stack.next(resourceMethod, resourceInstance);
		}
	}

}