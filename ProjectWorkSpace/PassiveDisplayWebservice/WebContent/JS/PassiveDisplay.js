var myevents = angular.module('environmentsApp', []);

myevents.controller("EnvironmentsController", function ($scope, $http) {
    $http.get('http://localhost:8080/TestWebservice/HalloWorld').
    success(function (data) {
        $scope.environments = data;
    });
});