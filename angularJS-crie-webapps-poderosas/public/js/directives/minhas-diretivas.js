angular.module('minhasDiretivas', [])
.directive('meuPainel', function() {

  var ddo = {};

  ddo.restrict = "AE";
  ddo.transclude = true;

  ddo.scope = {
    titulo: '@'
  };

  ddo.templateUrl = 'js/directives/meu-painel.html';

  return ddo;
})
.directive('minhaFoto', function () {
  var ddo = {};

  ddo.restrict = "AE";
  ddo.scope = {
    url: '@',
    titulo: '@'
  }

  ddo.templateUrl = 'js/directives/minha-foto.html';

  return ddo;
})
.directive('meuBotaoPerigo', function () {
  var ddo = {};

  ddo.restrict = "AE";
  ddo.scope = {
    nome: '@',
    acao: '&'
  };

  ddo.template = '<button class="btn btn-danger btn-block" ng-click="acao()">{{nome}}</button>';

  return ddo;
})
.directive('meuFocus', function () {
  var ddo = {};
  ddo.restrict = "A";
  /*ddo.scope = {
    focado = "="
  };*/

  ddo.link = function (scope, element) {
    scope.$on('fotoCadastrada', function () {
      element[0].focus();
      console.log('focus');
    });
  };

  return ddo;
})
.directive('minhaCharada', function() {
  var ddo = {};
  ddo.restrict = 'E';
  ddo.scope = {
    test: '@'
  };
  ddo.template = '<p>{{test}}</p>';

  return ddo;
})
.directive('meusTitulos', function() {
  var ddo = {};
  ddo.restrict = 'E';
  ddo.template = '<ul><li ng-repeat="titulo in titulos">{{titulo}}</li></ul>';
  ddo.controller = function($scope, recursoFoto) {
    recursoFoto.query(function(fotos) {
      $scope.titulos = fotos.map(function(foto) {
        return foto.titulo;
      });
    });
  };
  return ddo;
});