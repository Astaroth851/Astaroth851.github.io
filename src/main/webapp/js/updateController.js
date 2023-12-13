/**
 * Access the previously created module.
 */


(function() {
 var soundapp = angular.module('soundapp');
 
 soundapp.controller('updateController', function($scope, $http, $routeParams, $location) {
	
		$scope.productions = ['Short','Documentary','Feature','Commercial','Podcast','Concept','Corporate','ENG'];
	
		$scope.getMoviesById = function() {
			$http.get("/RyanBatesSound/webapi/movies/" + $routeParams.movieId)
			.then(function(response) {
				var movies = response.data;
				if (movies.length == 1) {
					$scope.movie = movies[0];
				} else {
					//TODO error message
				}				
			}, function(response) {
				console.log('error http GET movies by id: ' + response.status);
			});
		}

		$scope.getMoviesById();
		
		$scope.updateMovie = function() {
			$http.put("/RyanBatesSound/webapi/movies", $scope.movie)
			.then(function(response) {				
				$scope.updateStatus = 'update successful';			
			}, function(response) {
				$scope.updateStatus = 'error trying to update movie';	
				console.log('error http PUT movies: ' + response.status);
			});
		}
		
		$scope.deleteMovie = function() {
			$http.delete("/RyanBatesSound/webapi/movies/" + $scope.movie.id)
			.then(function(response) {				
				$scope.updateStatus = 'delete successful';	
				$scope.disableUpdate = true;
			}, function(response) {
				$scope.updateStatus = 'error trying to delete movie';	
				console.log('error http DELETE movies: ' + response.status);
			});
		}
		
		$scope.goToWorkView = function() {
			$location.path('/work');
		}
		
 	})
 })()
 

 
