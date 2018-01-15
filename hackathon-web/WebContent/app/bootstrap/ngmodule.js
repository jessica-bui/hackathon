/**
 * This file imports the third party library dependencies, then creates the angular module
 * and exports it.
 */
"use strict";

// External dependencies
//<!-- REQUIRED JS SCRIPTS : angular scripts -->
require("angular");
require("angular-ui-router");
require("d3/d3.min.js");
require("ui-router-extras-core");
require("ui-router-visualizer");


//<!-- AdminLTE App -->
require("bootstrap/js/bootstrap.min.js");
require("bootstrap-ui/ui-bootstrap-tpls.min.js");

//<!-- REQUIRED JS SCRIPTS : jquery scripts -->

//<!-- REQUIRED JS SCRIPTS : other supportive scripts -->
require("angular-utils-pagination");
require("angular-jwt");
require("angular-growl/angular-growl.min.js");

require("adminlte/js/app.min.js");

require("moment");

// Create the angular module "hackathonApp".
// Since it is exported, other parts of the application (in other files) can then import it and register things.
exports.ngmodule = angular.module("hackathonApp", [
	'ui.router','ui.bootstrap','ct.ui.router.extras.core','ui.router.visualizer','angular-growl'
]);