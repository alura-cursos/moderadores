class MensagemView extends View {
    
    template(mensagem) {
        return `<p class="alert alert-info">${mensagem.texto}</p>`;
    }
    
}