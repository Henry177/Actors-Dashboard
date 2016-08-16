var myevents = angular.module('environmentsApp', []);

myevents.controller("EnvironmentsController", function ($scope, $http) {
	$http.get('http://localhost:8080/PassiveDisplay/Dashboard').
    success(function (data) {
        $scope.environments = data;
    });
	
	$http.get('http://localhost:8080/PassiveDisplay/MsBuildServlet').
    success(function (data) {
        $scope.msbuilds = data;
    });
	
	$http.get('http://localhost:8080/PassiveDisplay/RedmineServlet').
    success(function (data) {
        $scope.redminList = data;
    });
	
	$scope.getLength = function(obj) {
	    return Object.keys(obj).length;
	}
});

