function montaPaciente (trPacientes) {
	percorreArray(trPacientes, function (pacienteTr) {

		var tdNome = pacienteTr.getElementsByClassName("info-nome")[0];
		var tdPeso = pacienteTr.getElementsByClassName("info-peso")[0];
		var tdAltura = pacienteTr.getElementsByClassName("info-altura")[0];
		var tdImc = pacienteTr.getElementsByClassName("info-imc")[0];

		var paciente = {nome : tdNome.textContent, peso : tdPeso.textContent, altura : tdAltura.textContent, imc : tdImc, pegaImc : function () {
			if(this.altura != 0) {
				this.imc.textContent = this.peso / (this.altura * this.altura);
			} else {
				console.log("Erro! Não é possivel calcular o imc pois a alutra informada é 0")
			}
		}};

		paciente.pegaImc();
	});
}