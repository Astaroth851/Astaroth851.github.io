(function() {
	var soundapp = angular.module('soundapp');
	soundapp.controller('createController', function($scope, $http) {
		$scope.productions = ['Short','Documentary','Feature','Commercial','Podcast','Concept','Corporate','ENG'];
		
		$scope.createMovie = function() {
			
		  const file = document.getElementById('fileUploadField').files[0];
		  console.log('File:', file);
		  const fileReader = new FileReader();
		  
		  		// event handler that is called with the load event is fired
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
				 $scope.postMovie();    
				 }    
				 // when the readAsDataURL is finished, then the onload event is called 
				 if (file !== undefined) {      
					fileReader.readAsDataURL(file);    
					} else {
						$scope.movie.image = '';
						$scope.postMovie()
						}
		}
		
		$scope.postMovie = function() {
			console.log('postMovie function called');
			 console.log('Sending HTTP POST request to create movie');
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
			
			console.log('clear function called');
			$scope.movie.title = '';
			$scope.movie.releaseYear = '';
			$scope.movie.production = '';
			$scope.movie.link = '';
			$scope.movie.image = '';
			
			$scope.createForm.$setUntouched();
			$scope.createForm.$setPristine();
			
			$scope.disableCreate = false;
		}
	});
})()
