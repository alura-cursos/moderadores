class MensagemView extends View {
    
    template(mensagem) {
        return mensagem.texto ? `<p class="alert alert-info">${mensagem.texto}</p>` : '';
    }
    
}