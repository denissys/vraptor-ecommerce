package br.com.kwikemart.session;

import static br.com.kwikemart.enums.Role.DEFAULT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.kwikemart.entity.User;
import br.com.kwikemart.roles.Role;

@Component
@SessionScoped
public class LoggedUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    public LoggedUser() {
    }

    
    public void doLogin(User user) {
        this.user = user;
    }

    public void doLogoff() {
        this.user = null;
    }

	public User getUser() {
        return user;
    }
    
    public boolean hasLogged() {
        return user != null && user.getId() != null;
    }
    
    public Role getRole() {
        Role role = new Role();
        if (getUser() != null) {
            role.setLoggedIn(true);
            //role.setAccessLevel(0);
            List<String> roles = new ArrayList<String>();
            if (getUser().getRole() == null) {
                roles.add(DEFAULT.toString());
            }
            role.setRoles(roles);
        }
        return role; 
    }

    public void setUser(User user) {
        this.user = user;
    }

}