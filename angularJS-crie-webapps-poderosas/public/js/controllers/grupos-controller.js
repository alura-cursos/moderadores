angular.module('alurapic').controller('GruposController', function ($scope, $http, $log) {
	$http.get('v1/grupos')
  .success(function (data) {
    $scope.grupos = data;
    $log.info(data);
  }).error(function(erro) {
    $log.error(erro);
  });
});