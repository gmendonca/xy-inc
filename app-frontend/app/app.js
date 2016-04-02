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
        controller: 'ProductsCtrl'
        }).
        when('/addproduct', {
        templateUrl: 'partials/addproducts.html',
        controller: 'HttpCtrl'
        }).
        otherwise({
        redirectTo: '/'
        });
    }
]);

app.controller("HttpCtrl", function($scope, $http){
    $scope.getProduct = function(id) {

      var response = $http.get('http://localhost:8080/myapp/products/'+ id);

      response.success(function(data) {
          $scope.prod = data;
      });

      response.error(function(data, status, headers, config) {
          alert("Failed to get data, status = " + status);
      });
    };

    $scope.updateProduct = function(id) {
      var jsonObj = angular.toJson($scope.prod, false);
      var response = $http.put('http://localhost:8080/myapp/products/'+ id, jsonObj);

      response.success(function(data) {
          $scope.prod = data;
          $scope.message = "Product updated!"
      });

      response.error(function(data, status, headers, config) {
          alert("Failed to get data, status = " + status);
      });
    };

    $scope.deleteProduct = function(id) {
      var jsonObj = angular.toJson($scope.prod, false);
      var response = $http.delete('http://localhost:8080/myapp/products/'+ id);

      response.success(function(data) {
          $scope.message = data;
      });

      response.error(function(data, status, headers, config) {
          alert("Failed to get data, status = " + status);
      });
    };

    $scope.addProduct = function() {
      var jsonObj = angular.toJson($scope.prod, false);
      var response = $http.post('http://localhost:8080/myapp/products/add', jsonObj);

      response.success(function(data) {
          $scope.prod = data;
          $scope.message = "Product added";
      });

      response.error(function(data, status, headers, config) {
          alert("Failed to get data, status = " + status);
      });
    };
});

app.controller("ProductsCtrl", function($scope, $http){

      var response = $http.get('http://localhost:8080/myapp/products/all');

      response.success(function(data) {
          $scope.products = data;
      });

      response.error(function(data, status, headers, config) {
          alert("Failed to get data, status = " + status);
      });

});
