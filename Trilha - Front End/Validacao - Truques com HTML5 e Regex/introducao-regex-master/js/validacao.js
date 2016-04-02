$('#telefone').bind("change paste keyup", function(e) {
	var number = this.value.replace(/[^\d]/g, '');
	var match = number.match(/\d{8,11}/);
	if (match) {
		console.log(match[0]);
		number = match[0].replace(/(\d\d)?(\d{4,5})(\d{4})/, (number.length > 9 ? "($1)" : "") + "$2-$3");
		console.log(number);
	}
});