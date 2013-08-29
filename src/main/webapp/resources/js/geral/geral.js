function successHandler(data) {
	alert(data.mensagem);
	resetForm();
}

function errorHandler(data) {
	alert(data);
}

function resetForm(formId) {
	$('#' + formId).each (function(){
		this.reset();
	});
}