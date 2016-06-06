class NegociacaoController {
 
    constructor() {
        let $ = document.querySelector.bind(document);
        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        this._listaNegociacao = new Bind(new ListaNegociacao(), new NegociacaoView($('#negociacao')), 'adiciona', 'esvazia');
        this._mensagem = new Bind(new Mensagem(), new MensagemView($('#mensagem')), 'texto');
        this._negociacaoService = new NegociacaoService();
    }    
    
    adiciona(event) {
        event.preventDefault(); 
        this._listaNegociacao.adiciona(this._criaNegociacao());        
        this._mensagem.texto = 'Negociação cadastrada com sucesso';
        this._restauraForm();
    }
    
    apaga() {
        this._listaNegociacao.esvazia();
        this._mensagem.texto = 'Negociações apagadas com sucesso';
    }
    
    importarNegociacoes() {
        this._negociacaoService.obterNegociacoes().then(negociacoes => negociacoes.forEach(negociacao => {
            this._listaNegociacao.adiciona(negociacao);
            this._mensagem.texto = 'Negociações importadas com sucesso';
        })).catch(erro => this._mensagem.texto = erro);
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