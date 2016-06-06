class NegociacaoService {
    
    constructor() {
        this._http = new HttpService();
    }
    
    obterNegociacoes() {
        return new Promise((resolve, reject) => {
            Promise.all([
                this.obterNegociacoesSemana(),
                this.obterNegociacoesSemanaAnterior(),
                this.obterNegociacoesSemanaRetrasada()
            ]).then(periodos => {
                resolve(periodos.reduce((novoArray, array) => novoArray.concat(array), []).map(negociacao => new Negociacao(new Date(negociacao.data), negociacao.quantidade, negociacao.valor)));
            }).catch(erro => this._mensagem.texto = erro);            
        });
    }
    
    obterNegociacoesSemana() {
        return new Promise((resolve, reject) => {
            this._http.get('negociacoes/semana')
                .then(dados => resolve(dados.map(dados => new Negociacao(new Date(dados.data), dados.quantidade, dados.valor))))
                .catch(erro => reject('Não foi possível importar as requisições da semana'));            
        });
    }
    
    obterNegociacoesSemanaAnterior() {
        return new Promise((resolve, reject) => {
            this._http.get('negociacoes/anterior')
                .then(dados => resolve(dados.map(dados => new Negociacao(new Date(dados.data), dados.quantidade, dados.valor))))
                .catch(erro => reject('Não foi possível importar as requisições da semana anteriorerro => '));            
        });
    }
    
    obterNegociacoesSemanaRetrasada() {
        return new Promise((resolve, reject) => {
            this._http.get('negociacoes/retrasada')
                .then(dados => resolve(dados.map(dados => new Negociacao(new Date(dados.data), dados.quantidade, dados.valor))))
                .catch(erro => reject('Não foi possível importar as requisições da semana retrasada'));            
        });
    }
    
}