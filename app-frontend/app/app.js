var app = angular.module('myApp', ['ngRoute']);

app.controller("HttpCtrl", function($scope, $http){

$scope.getProduct = function(id) {

      var response = $http.get('http://localhost:8080/myapp/products/'+ id);

      response.success(function(data) {
          $scope.prod = data;
        })

      response.error(function(data, status, headers, config) {
        alert("Failed to get data, status=" + status);
      }
  )};
});
