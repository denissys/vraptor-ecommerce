$(document).ready(function() {
	
	$("#form-login").validate({
		
		submitHandler:function(form) {
			
			var registerData = {
					"user.email"     : $('#email').val(),
					"user.password"  : $('#password').val(),
					"decisionRoute"  : $('#decisionRoute').val()
				};
			
			$.ajax({
				  type: "POST",
				  url: "/auth",
				  data: registerData,
				  dataType: "json",
				  success: function(data) {
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
						
			email: {
				required: true,
				email: true,
				maxlength: 300,
				minlength: 5
			},
			password: {
				required: true,
				maxlength: 200,
				minlength: 5
			} 
         	 
		},
		messages: {
			password: {
				minlength: "Sua senha deve conter pelo menos {0} caracteres.",
	    	}
		}
		
	});
});