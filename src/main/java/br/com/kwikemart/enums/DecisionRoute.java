package br.com.kwikemart.enums;

import static br.com.kwikemart.controller.CartController.CHECKOUT_PATH;
import static br.com.kwikemart.controller.UserController.MY_ACCOUNT_PATH;
import lombok.Getter;

public enum DecisionRoute {

	DEFAULT(MY_ACCOUNT_PATH), CHECKOUT(CHECKOUT_PATH);

	@Getter
	private String path;

	private DecisionRoute(String path) {
		this.path = path;
	}
}
