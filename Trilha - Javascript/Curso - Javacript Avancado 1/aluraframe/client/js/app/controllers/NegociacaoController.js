class NegociacaoController {
 
    constructor() {
        let $ = document.querySelector.bind(document);
        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        this._listaNegociacao = new ListaNegociacao();
        this._negociacaoView = new NegociacaoView($('#negociacao'));
        this._negociacaoView.update(this._listaNegociacao.negociacoes);
        this._mensagem = new Mensagem();
        this._mensagemView = new MensagemView($('#mensagem'));    
    }    
    
    adiciona(event) {
        event.preventDefault(); 
        this._listaNegociacao.adiciona(this._criaNegociacao());        
        this._negociacaoView.update(this._listaNegociacao.negociacoes);
        this._mensagem.texto = 'Negociação cadastrada com sucesso';
        this._mensagemView.update(this._mensagem);
        this._restauraForm();
    }
    
    _criaNegociacao() {
        return new Negociacao(DateHelper.textoParaData(this._inputData.value), this._inputQuantidade.value, this._inputValor.value);
    }
    
    _restauraForm() {
        this._inputData.value = '';
        this._inputQuantidade.value = 1;
        this._inputValor.value = 0.0;
        this._inputData.focus();
    }    
    
}