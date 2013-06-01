$(document).ready(function() {
	
	$("#update-status").click(function() {

		var orderId = $(this).data('id');
		
		var paginationData = {
			"id"     : orderId,
			"status" : $("#select-status-"+orderId).val()
		};
		
		$.ajax({
			  type: "POST",
			  url: "/pedidos/atualizar-status",
			  data: paginationData,
			  dataType: "json",
			  success: function(data) {
				  alert("Status atualizado com sucesso.");
			  }
			});
	});
	
	$("#select-status").change(function() {
		if($(this).val() != "") {
			$("#form-filter").submit();
		}
	});
	
});