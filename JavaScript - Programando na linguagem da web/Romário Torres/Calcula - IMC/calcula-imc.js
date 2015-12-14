var botao = document.getElementById("calcula-imcs");

botao.addEventListener ("click", function () {
	var trPacientes = document.getElementsByClassName("paciente");
	montaPaciente(trPacientes);
});

botao.addEventListener ("click", console.log("O botão foi clicado!"));