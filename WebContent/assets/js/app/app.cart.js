$("#add-cart").click(function() {
  
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