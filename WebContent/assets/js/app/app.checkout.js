$(document).ready(function() {
	
	$("#form-address").validate({
		
		submitHandler:function(form) {
			
			var addressData = {
					"address.street"     : $('#street').val(),
					"product.number"     : $('#streetNumber').val(),
					"product.complement" : $('#complement').val()
				};
			
			$.ajax({
				  type: "POST",
				  url: "/meu-carrinho/pedido",
				  data: addressData,
				  dataType: "json",
				  success: function(data) {
					  var response = data.jsonViewResponse;
					  
					  if(response.success == true) {
						  $(".ordered").hide();
						  $("#ordered-number").html(response.message);
						  $(".finish").show();
					  } else {
						  alert("Ocorreu um erro, tente mais tarde.");
					  }
				  }
				});
		},
			
		rules: {
			street: {
				required: true,
				minlength: 4,
				maxlength: 100
			},
			
			streetNumber: {
				required: false,
				minlength: 1,
				maxlength: 5
			},
			
			complement: {
				required: false,
				minlength: 1,
				maxlength: 10
			}
		}
		
	});
	
});