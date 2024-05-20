/**
 * Access the previously created module.
 */


(function() {
	var soundapp = angular.module('soundapp');

	soundapp.controller('workController', function($scope, $http, $location) {
		
		 $scope.checkAdmin = function() {
			 
		$http.get("webapi/checkAdminRole")
            .then(function(response) {
				  console.log('checkAdminRole called');
                // If the user is an admin, set isAdmin to true
                $scope.isAdmin = (response.data.role === 'admin');
              
                console.log(response.data.role);
            })
            .catch(function(error) {
                // Handle error
                console.log('checkAdminRole error');
                console.error('Error checking admin role:', error);
              
            });
    };
    
    	 $scope.checkAdmin();

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
