"use strict";

var hackathonApp = require("./bootstrap/ngmodule");

// Import the top-level state definitions for app, welcome, home, login, ...

var app_states = [];
var i=0;
app_states[i++] = require("./app.state");
app_states[i++] = require("./home.state");


//and register each one with the StateProvider
hackathonApp.ngmodule.config(function ($stateProvider) {
	app_states.forEach(function (state) { return $stateProvider.state(state.reg_state); });
});

// Apply some global configuration...

// If the user enters a URL that doesn't match any known URL (state), send them to `/welcome`
hackathonApp.ngmodule.config(['$urlRouterProvider', function ($urlRouterProvider) { $urlRouterProvider.otherwise("/home"); }]);

//growl notification config
hackathonApp.ngmodule.config(['growlProvider', function(growlProvider) {
	growlProvider.globalPosition('bottom-right');
	growlProvider.globalTimeToLive(7000);
	growlProvider.globalDisableCountDown(true);
}]);


// Enable tracing of each TRANSITION... (check the javascript console)
// This syntax `$trace.enable(1)` is an alternative to `$trace.enable("TRANSITION")`.
// Besides "TRANSITION", you can also enable tracing for : "RESOLVE", "HOOK", "INVOKE", "UIVIEW", "VIEWCONFIG"
//hackathonApp.ngmodule.run(['$trace', function ($trace) { $trace.enable(1); }]);

hackathonApp.ngmodule.filter('utcdate', ['$filter', function ( $filter ) {
  return function (date) {
	$filter('filter')([], 'query');
	return $filter('date')(date, "yyyy-MM-dd HH:mm:ss'Z'","UTC");
  };
}]);

hackathonApp.ngmodule.filter('intToDay', function() {
  return function(input) {
	var day = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
	var result = input;
	if (input >= 0 && input <= day.length) {
	  result = day[input-1];
	}
	return result;
  };
});

hackathonApp.ngmodule.directive('loading', ['$http', function ($http) {
	return {
		restrict: 'A',
		link: function (scope, elm, attrs) {
			scope.isLoading = function () {
				var loading = false;
				if ($http.pendingRequests.length > 0) {
				  for (var i=0;i<$http.pendingRequests.length;i++) {
					 if ($http.pendingRequests[i].show_loading ==  null || $http.pendingRequests[i].show_loading ) {
						loading = true;
						break;
					 }
				  }
				}
				return loading;
			};
			scope.$watch(scope.isLoading, function (v) {
				if (v) {
					elm.show();
				} else {
					elm.hide();
				}
			});
		}
	};
}]);