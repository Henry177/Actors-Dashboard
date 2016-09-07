var myevents = angular.module('environmentsApp', []);

myevents.controller("MSBuildController", function ($scope, $http) {
	$scope.showMSBuildController = false;
	$http.get('http://localhost:8080/PassiveDisplay/MsBuildServlet').
    success(function (data) {
    	$scope.showMSBuildController = true;
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

myevents.controller("JenkinsControler", function ($scope, $http, $interval) {
	$scope.showJenkinsControler = false;
	$scope.reload = function () {
		$http.get('http://localhost:8080/PassiveDisplay/Dashboard').
	    success(function (data) {		
	    	
			var building = "#feff54";
			var success = "#7efa69";
			var broken = "#ff5454";		

			$scope.environments = data;
			$scope.showJenkinsControler = true;
			//alert(JSON.stringify($scope.showJenkinsControler));
			angular.forEach($scope.environments, function(item){
	            if (item.Building)
				{
			    	item.backgroundCol = building;
				}
				else
				{
					if (item.Result == "FAILURE") {
						item.backgroundCol = broken;
					}
					else
					{
						item.backgroundCol = success;
					}
				}
	        });		
	    }).	
		error(function(error, status){
			alert('error:\n' + error + "\nstatus:\n" + status);
		});
	};
	
	$scope.reload();
	$interval($scope.reload, 6000);
});


