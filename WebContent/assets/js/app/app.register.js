$(document).ready(function() {
	
	$("#cpf").mask("999.999.999-99");
	
	$("#form-register").validate({
		
		submitHandler:function(form) {
			
			var registerData = {
					"user.firstName" : $('#firstName').val(),
					"user.lastName"  : $('#lastName').val(),
					"user.document"  : $('#cpf').val(),
					"user.email"     : $('#newEmail').val(),
					"user.password"  : $('#newPassword').val(),
					"receiveEmail"   : $('#recebaEmail').val(),
					"decisionRoute"  : $('#decisionRoute').val(),
				};
			
			$.ajax({
				  type: "POST",
				  url: "/cadastro/salvar",
				  data: registerData,
				  dataType: "json",
				  success: function(data) {
					  //jsonViewResponse: {redirect:true, urlRedirect:/criar-loja, success:true}
					  var response = data.jsonViewResponse; 
					  
					  if(response.success == false) {
						  alert(response.message);
					  } else if(response.redirect == true) {
						  location.href = response.urlRedirect;
					  }
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
			},
			
			newEmail: {
				required: true,
				email: true,
				maxlength: 300,
				minlength: 5
			},
			emailConfirm: {
                required: true, 
                equalTo: "#newEmail" 
              
         	 }, 
         	 newPassword: {
				required: true,
				maxlength: 200,
				minlength: 5
				//notPartOf: $('#name')
			},
			passwordConfirm: {
                required: true, 
                equalTo: "#newPassword", 
                minlength: 5
         	 }, 
         	 
         	regAspectos: {
                required: true, 
         	 }, 
         	regPromocao: {
                required: true, 
         	 }, 
		},
		messages: {
			password: {
				minlength: "Sua senha deve conter pelo menos {0} caracteres.",
	    	},
	    	passwordConfirm: "As senhas não coincidem.",
	    	
			emailConfirm: "Digite o mesmo e-mail informado no campo anterior."
		}
		
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

jQuery.validator.addMethod("notPartOf", function(value, element, params) {
	return this.optional(element) || $('#name').val().indexOf(value)<0;
	}, "Sua senha deve ser mais segura.");

jQuery.validator.addMethod("hasSpace", function(value, element, params) {
	return this.optional(element) || value.indexOf(' ')>=0;
	}, "Você deve fornecer seu nome completo");

jQuery.validator.addMethod("isAlpha", function(value, element, params) {
	var str = value
	if(/^[a-zA-Z- ãáâéêíóôõúÃÁÂÉÊÍÓÔÕÚçÇ]*$/.test(str) == false) {
	    return false;
	}
	return true;
	}, "Não utilizar números e caracteres especiais.");