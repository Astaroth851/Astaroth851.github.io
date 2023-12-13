(function() {
	var soundapp = angular.module('soundapp');
	soundapp.controller('createController', function($scope, $http) {
		$scope.productions = ['Short','Documentary','Feature','Commercial','Podcast','Concept','Corporate','ENG'];
		$scope.createMovie = function() {
			$http.post("/RyanBatesSound/webapi/movies", $scope.movie)
				.then(function(response) {
					$scope.createStatus = 'create successful';
					$scope.disableCreate = true;
				}, function(response) {
					$scope.createStatus = 'error trying to create movie';
					console.log('error http POST movies: ' + response.status);
				});
		}
		$scope.clear = function() {
			$scope.movie.title = '';
			$scope.movie.releaseYear = '';
			$scope.movie.production = '';
			
			$scope.createForm.$setUntouched();
			$scope.createForm.$setPristine();
			
			$scope.disableCreate = false;
		}
	});
})()