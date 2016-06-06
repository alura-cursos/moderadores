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
    
    esvazia() {
        this._negociacoes = [];
    }
    
    get volumeTotal() {
        return this._negociacoes.reduce((total, n) => total + n.volume, 0.0);
    }
    
}