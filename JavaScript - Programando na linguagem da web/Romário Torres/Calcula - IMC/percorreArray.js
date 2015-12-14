function percorreArray (trPacientes, comportamento) {
	for (var i = 0; i < trPacientes.length; i++) {
		var pacienteTr = trPacientes[i];
		comportamento(pacienteTr);
	}
}