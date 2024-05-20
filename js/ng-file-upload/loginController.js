(function() {
    var soundapp = angular.module('soundapp');

    soundapp.controller('loginController', function($scope, $http, $location) {
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

        $scope.logout = function() {
            $http.get('/RyanBatesSound/LogoutServlet')
                .then(function(response) {
                    $scope.isAdmin = false;
                    $scope.userRole = null;
                    $location.path('/login'); // Redirect to login page
                }, function(error) {
                    console.error('Error:', error);
                });
        };
    });
})();