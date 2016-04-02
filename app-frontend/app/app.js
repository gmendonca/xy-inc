var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/getproduct', {
        templateUrl: 'partials/getproduct.html',
        controller: 'HttpCtrl'
      }).
      when('/getproducts', {
        templateUrl: 'partials/getproducts.html',
        controller: 'HttpCtrl'
      }).
      when('/addproduct', {
        templateUrl: 'partials/addproducts.html',
        controller: 'HttpCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);

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

app.controller("ProductsCtrl", function($scope, $http){

$scope.getProduct = function(id) {

      var response = $http.get('http://localhost:8080/myapp/products/');

      response.success(function(data) {
          $scope.products = data;
        })

      response.error(function(data, status, headers, config) {
        alert("Failed to get data, status=" + status);
      }
  )};
});
