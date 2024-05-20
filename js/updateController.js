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
        };

        $scope.getMoviesById();

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

        $scope.updateMovie = function() {
            if (!$scope.isAdmin) {
                console.log('User is not an admin. Cannot update movie.');
                return;
            }
            
            const file = document.getElementById('fileUploadField').files[0];
            console.log('File:', file);
            const fileReader = new FileReader();

            // event handler that is called when the load event is fired
            fileReader.onload = function(event) {      
                var data = fileReader.result;      
                if (data !== undefined && data.length > 0) { 
                    // data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAZkAAAHVCAIAAACs 
                    // XRGOAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjw...      
                    // remove the 'data' name/value      
                    $scope.movie.image = data.split(',')[1];
                } else {      
                    $scope.movie.image = '';
                }      
                $scope.postUpdatedMovie();    
            };    

            // when the readAsDataURL is finished, then the onload event is called 
            if (file !== undefined) {      
                fileReader.readAsDataURL(file);    
            } else {
                $scope.movie.image = '';
                $scope.postUpdatedMovie();
            }
        };

        $scope.postUpdatedMovie = function() {
            console.log('updateMovie function called');
            $http.put("/RyanBatesSound/webapi/movies", $scope.movie)
            .then(function(response) {                
                $scope.updateStatus = 'update successful';            
            }, function(response) {
                $scope.updateStatus = 'error trying to update movie';    
                console.log('error http PUT movies: ' + response.status);
            });
        };

        $scope.deleteMovie = function() {
            if (!$scope.isAdmin) {
                console.log('User is not an admin. Cannot delete movie.');
                return;
            }
            
            $http.delete("/RyanBatesSound/webapi/movies/" + $scope.movie.id)
            .then(function(response) {                
                $scope.updateStatus = 'delete successful';    
                $scope.disableUpdate = true;
            }, function(response) {
                $scope.updateStatus = 'error trying to delete movie';    
                console.log('error http DELETE movies: ' + response.status);
            });
        };

        $scope.goToWorkView = function() {
            $location.path('/work');
        };

        $scope.checkAdmin();
    });
})();
