$(document).ready(function() {
	
	$("#form-add").validate({
		
		submitHandler:function(form) {
			
			var cartData = {
					"item.product.id" : $('#productId').val(),
					"item.quantity"   : $('#quantity').val()
				};
			
			$.ajax({
				  type: "POST",
				  url: "/meu-carrinho/adicionar",
				  data: cartData,
				  dataType: "json",
				  success: function(data) {
					  alert("Produto adicionado ao carrinho com sucesso.");
				  }
			});
		},
			
		rules: {
						
			quantity: {
				required: true,
				isNumeric: true,
				isGreaterZero: true,
				maxlength: 2
			} 
		},
		messages: {
			required: {
				required: "Informe quantos produtos você quer adicionar.",
				isNumeric: "Informe apenas números no campo quantidade.",
				isGreaterZero: "Informe pelo menos 1 item para adicionar ao carrinho.",
				maxlength: "Oops, você não pode adicionar mais que 99 items desse produto."
	    	}
		}
		
	});
	
	$("#clear-cart").click(function() {
	
		$.ajax({
			  type: "POST",
			  url: "/meu-carrinho/limpar",
			  dataType: "json",
			  success: function(data) {
				  $(".total").html("R$ 0,00");
				  $(".product-item").remove();
				  $("#clear-cart").remove();
				  $("#buy-cart").remove();
			  }
			});
	});
	
	$("#remove-cart").click(function(e) {
		
		var cartData = {
			"productId" : $(this).data('id')
		};
	
		$.ajax({
			  type: "POST",
			  url: "/meu-carrinho/remover",
			  data: cartData,
			  dataType: "json",
			  success: function(data) {
				  location.reload();
			  }
			});
		
	});
	
	$("#buy-cart").click(function(e) {
		location.href = "/meu-carrinho/comprar";
	});
	
});

jQuery.validator.addMethod("isNumeric", function(value, element, params) {
	return $.isNumeric(value);
	}, "Utilizar apenas números."
);

jQuery.validator.addMethod("isGreaterZero", function(value, element, params) {
	return $.isNumeric(value) && value > 0;
	}, "Utilizar apenas números maior que zero."
);