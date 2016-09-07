var myevents = angular.module('environmentsApp', []);

myevents.controller("EnvironmentsController", function ($scope, $http) {
	$scope.getLength = function(obj) {
		if(obj) {
			return Object.keys(obj).length;
		}
		return 0;
	}
	
	$http.get('http://localhost:8080/PassiveDisplay/Dashboard').
    success(function (data) {
			
		var enviro= [];		
		var trunk = data.CoreTrunkCI;
		var preprod = data.CorePreProd;
		
		var building = "#feff54";
		var success = "#7efa69";
		var broken = "#ff5454";		
		
		if(trunk)
		{
			if (trunk.Building)
			{
				trunk.backgroundCol = building;
			}
			else
			{
				if (trunk.Result == "FAILURE")
				{
					trunk.backgroundCol = broken;
				}
				else
				{
					trunk.backgroundCol = success;
				}
			}
			
		}
		if(preprod)
		{
			if (preprod.Building)
			{
				preprod.backgroundCol = building;
			}
			else
			{
				if (preprod.Result == "FAILURE")
				{
					preprod.backgroundCol = broken;
				}
				else
				{
					preprod.backgroundCol = success;
				}
			}
		}
		enviro[0] = trunk;
		enviro[1] = preprod;
		if($scope.getLength($scope.msbuilds) > 2)
		{
			enviro[2] = "";
		}
		
		$scope.environments = enviro;
    }).	
	error(function(error, status){
		alert('error:\n' + error + "\nstatus:\n" + status);
	});
	
	$http.get('http://localhost:8080/PassiveDisplay/MsBuildServlet').
    success(function (data) {
        $scope.msbuilds = data;
    }).	
	error(function(error, status){
		alert('error:\n' + error + "\nstatus:\n" + status);
	});	
	
	$http.get('http://localhost:8080/PassiveDisplay/RedmineServlet').
    success(function (data) {
        $scope.redminList = data;
    }).	
	error(function(error, status){
		alert('error:\n' + error + "\nstatus:\n" + status);
	});
});

