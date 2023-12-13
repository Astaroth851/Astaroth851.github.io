/**
 * create a new module named 'soundapp'
 */


(function() {
	var soundapp = angular.module('soundapp', ['ngRoute']);

soundapp.config(function($routeProvider) {
		$routeProvider
			.when("/work", {
				templateUrl: "work.html",
				controller: "workController"
			})
			.when("/create", {
				templateUrl: "create.html",
				controller: "createController"
			})
			.when("/update/:movieId", {
				templateUrl: "update.html",
				controller: "updateController"
			})
			.when("/photos", {
				templateUrl: "photos.html"
			})
			.when("/rates", {
				templateUrl: "rates.html"
			})
			.when("/contact", {
				templateUrl: "contact.html"
			})
			.when("/success", {
				templateUrl: "success.html"
			})
			.when("/stack", {
				templateUrl: "stack.html"
			})
			.when("/resume", {
				templateUrl: "resume.html"
			})
			.otherwise({
				templateUrl: "soundmain.html"
			});
	});
})()