package br.com.kwikemart.roles;

import java.util.ArrayList;
import java.util.List;

import br.com.bronx.vraptor.restrictrex.interfaces.Profile;

public class Role implements Profile {

    private int accessLevel;
    private List<String> roles = new ArrayList<String>();
    private boolean loggedIn;


    public int getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}
