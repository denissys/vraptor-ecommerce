$(document).ready(function() {
	
	$('#price').priceFormat({
		prefix: '',
		centsSeparator: '.',
		thousandsSeparator: '',
        limit: 8,
        centsLimit: 2
    });	 
	
	$("#form-register").validate({
		
		submitHandler:function(form) {
			
			var registerData = {
					"product.name"         : $('#name').val(),
					"product.description"  : $('#description').val(),
					"product.price"  : $('#price').val()
				};
			
			$.ajax({
				  type: "POST",
				  url: "/produtos/salvar",
				  data: registerData,
				  dataType: "json",
				  success: function(data) {
					  var response = data.jsonViewResponse; 
					  
					  if(response.success == false) {
						  alert(response.message);
					  } else {
						  $("#name").prop("readonly",true);
						  $("#description").prop("readonly",true);
						  $("#price").prop("readonly",true);
						  $('#register-action').hide();
						  $('#next-step').show();
					  }
				  }
				});
		},
			
		rules: {
						
			name: {
				required: true,
				minlength: 2,
				maxlength: 150
			},
			
			description: {
				required: false,
				minlength: 5,
				maxlength: 150
			},
			
			price: {
				required: true
			}
			
		}
		
	});
	
});

$(function() {
    $('#file_upload').uploadify({
        'swf'       : '/assets/js/uploadify/uploadify.swf',
        'cancelImg' : '/assets/js/uploadify/uploadify-cancel.png',
        'uploader'  : 'http://localhost:8080/produtos/novo/upload-imagem',
        'buttonText': 'Selecione a imagem',
        'auto'      : true,
        'sizeLimit' : 1024*1024, //1 MB limit
        'fileExt'   : '*.jpeg;*.gif;*.png;*.jpg;*.bmp',
        'onUploadComplete' : function(file) {
            $(".uploaded-filename").html(file.name);
            $(".upload-message").show();
        }
    });
});