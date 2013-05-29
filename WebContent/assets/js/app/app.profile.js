$(document).ready(function() {
	
	$("#cpf").mask("999.999.999-99");
	
	$("#form-update").validate({
		
		submitHandler:function(form) {
			
			var registerData = {
					"user.firstName" : $('#firstName').val(),
					"user.lastName"  : $('#lastName').val(),
					"user.document"  : $('#cpf').val(),
					"decisionRoute"  : $('#decisionRoute').val(),
				};
			
			$.ajax({
				  type: "POST",
				  url: "/perfil/atualizar",
				  data: registerData,
				  dataType: "json",
				  success: function(data) {
					  var response = data.jsonViewResponse; 
					  alert(response.message);
				  }
				});
		},
			
		rules: {
						
			firstName: {
				required: true,
				isAlpha: true,
				maxlength: 30
			},
			
			lastName: {
				required: true,
				isAlpha: true,
				maxlength: 30
			},
			
			cpf: {
				required: true, 
				verificaCPF: true
			}
		}
		
	});
	
	$("#form-change-password").validate({
		
		submitHandler:function(form) {
			
			var registerData = {
					"password"  : $('#password').val(),
					"newPassword"  : $('#newPassword').val()
				};
			
			$.ajax({
				  type: "POST",
				  url: "/perfil/alterar-senha",
				  data: registerData,
				  dataType: "json",
				  success: function(data) {
					  var response = data.jsonViewResponse; 
					  alert(response.message);
					  if(response.success) {
						  $("#password").val("");
						  $("#newPassword").val("");
						  $("#newPasswordConfirm").val("");
						  $(".change-password").hide();
					  } else {
						  $("#password").val("");
					  }
				  }
				});
		},
			
		rules: {
			password: {
	 				required: true,
	 				minlength: 5,
	 				maxlength: 20
			},
			
        	newPassword: {
 				required: true,
 				minlength: 5,
 				maxlength: 20
 			},
 			
 			newPasswordConfirm: {
                 required: true, 
                 equalTo: "#newPassword", 
                 minlength: 5
          	}
		},
		
		messages: {
			password: {
				minlength: "Sua senha deve conter pelo menos {0} caracteres.",
	    	},
	    	newPassword: {
				minlength: "Sua senha deve conter pelo menos {0} caracteres.",
	    	},
	    	newPasswordConfirm: "As senhas novas não coincidem."
		}
		
	});
	
	$(".btn-update").click(function() {
		$(".box-hide-item").hide();
		$(".edit").show();
	});

	$(".btn-change-passowrd").click(function() {
		$(".box-hide-item").hide();
		$(".change-password").show();
	});
});

jQuery.validator.addMethod("verificaCPF", function(value, element) {
	value = value.replace('.','');
	value = value.replace('.','');
	cpf = value.replace('-','');
	while(cpf.length < 11) cpf = "0"+ cpf;
	
	var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
	var a = [];
	var b = new Number;
	var c = 11;
	
	for (i=0; i<11; i++){
	    a[i] = cpf.charAt(i);
	    if (i < 9) b += (a[i] * --c);
	}
	
	if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
	b = 0;
	c = 11;
	for (y=0; y<10; y++) b += (a[y] * c--);
	if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }
	if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) return false;
	return true;
	}, "Informe um CPF válido.");

jQuery.validator.addMethod("isAlpha", function(value, element, params) {
	var str = value
	if(/^[a-zA-Z- ãáâéêíóôõúÃÁÂÉÊÍÓÔÕÚçÇ]*$/.test(str) == false) {
	    return false;
	}
	return true;
	}, "Não utilizar números e caracteres especiais.");