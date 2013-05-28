package br.com.kwikemart.enums;

import org.apache.commons.lang.ArrayUtils;

import br.com.bronx.vraptor.restrictrex.annotation.Roles;

public enum Role {

	ADMIN, DEFAULT;

	public static boolean contains(Roles annotation, Role role) {
    	return ArrayUtils.toString(annotation.roles()).contains(role.toString());
    }
}
