(function() {
	var soundapp = angular.module('soundapp');
	soundapp.controller('linkController', function($scope, $http) {
		const entries = [
			{id: 62, link: "https://tubitv.com/movies/672479/pursuit"}
			
		];
		
		const entriesContainer = document.getElementById('entriesContainer');
	
	entries.forEach(entry => {
		 const entryLink = document.createElement('a');
    entryLink.href = `/entry/${entry.id}`; // URL for each entry
    entryLink.textContent = entry.title;
    entryLink.setAttribute('data-entry-id', entry.id); // Store entry ID as a data attribute
    entryLink.addEventListener('click', handleEntryClick); // Add click event listener
    entriesContainer.appendChild(entryLink); // Append link to the container
		
		
		
	});
	
	
	
	});
})()