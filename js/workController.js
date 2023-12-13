/**
 * Access the previously created module.
 */


(function() {
	var soundapp = angular.module('soundapp');

	soundapp.controller('workController', function($scope, $http, $location) {

		$scope.showSpinner = true;

		$scope.getAllMovies = function() {
			$scope.showSpinner = true;
			$scope.IsVisible = false;
			$http.get("/RyanBatesSound/webapi/movies")
				.then(function(response) {
					$scope.movies = response.data;
					console.log('number of movies: ' + $scope.movies.length);
					$scope.showSpinner = false;
				}, function(response) {
					console.log('error http GET movies: ' + response.status);
				});
				
			$scope.movies = [
				{ movieId: 1, Name: "Pursuit", Photo: "images/35.jpg" },
			]

			$scope.IsVisible = true;	
		};

		

		$scope.goToUpdateView = function(movieId) {
			$location.path('/update/' + movieId);
		}

		$scope.getAllMovies();

		$scope.orderByColumn = function(column) {
			$scope.orderByValue = column;
			if ($scope.reverse) {
				$scope.reverse = false;
			} else {
				$scope.reverse = - true;
			}
		}
		$scope.reverse = false;
		$scope.orderByColumn('releaseYear');

	})
})()



