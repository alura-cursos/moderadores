class ListaNegociacao {
    
    constructor() {
        this._negociacoes = [];
    }
    
    get negociacoes() {
        return [].concat(this._negociacoes);
    }
    
    adiciona(negociacao) {
        this._negociacoes.push(negociacao);
    }
    
}