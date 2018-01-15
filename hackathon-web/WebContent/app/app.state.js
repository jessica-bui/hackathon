"use strict";

/**
 * This is a home screen for authenticated users.
 *
 */
var _controller = function ($rootScope, $scope, $state, $timeout, $interval,
		AppConfig) {


	
	//set function to update clock
	$interval ( function () { $("#timenow").text( moment().utc().format() ); }, 1000);

	//manipulate ui
	if ($('div').hasClass('sidebar-collapse'))  // put outside $timeout() prevents it animating every reload
		$('div').removeClass('sidebar-collapse');
	$timeout(function () {
		//DOM has finished rendering
		$.AdminLTE.layout.activate(); //fixes layout
	});
};

exports.reg_state = {
	name: 'app',
	url: '',
	redirectTo: 'home',
	views: {
		'@': {
			templateUrl: 'app/views/app.html',
			controller: _controller,
			controllerAs: 'vm'
		},
		'content@app': {
			template: '<ui-view/>',
			controller: _controller,
			controllerAs: 'vm'
		},
	},
	controller: _controller,
	controllerAs: 'vm'
};
