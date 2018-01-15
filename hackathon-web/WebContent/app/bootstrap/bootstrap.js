/**
 * This file is the main entry point for the entire app.
 *
 * If the application is being bundled, this is where the bundling process
 * starts.  If the application is being loaded by an es6 module loader, this
 * is the entry point.
 *
 * Point Webpack or SystemJS to this file.
 *
 * This module imports all the different parts of the application:
 * - 3rd party Libraries and angular1 module
 * - Services
 * - Components
 * - Submodules
 * - Top-level states
 * - UI-Router Transition Hooks
 */
"use strict";

// Import the angular module
require("./ngmodule");


// Import CSS (SystemJS will inject it into the document)
// required by AdminLTE
require("bootstrap/css/bootstrap.min.css!");
require("font-awesome/css/font-awesome.min.css!");
require("ionicons/ionicons.min.css!");
require("adminlte/css/AdminLTE.min.css!");
require("adminlte/css/skins/_all-skins.min.css!");
require("styles/css/hackathon.css!");
require("angular-growl/angular-growl.min.css!");
// end required by AdminLTE

require("libs/jquery-ui/themes/smoothness/jquery-ui.css!");
//require("styles/css/roxy.css!");
require("angular-growl/angular-growl.min.css!");

// Import the service that manages the user's application preferences, and the Authentication service
require('../services/appConfig');


// These register themselves as angular services
//require("../services/dialog.js");
//require("../services/modalDialog.js");

// HACKATHON API factories
require("../factories/config.js");

//require("../factories/certs.js");  // not used

// Import the submodules that make up the main subsections of the application
// Each submodule registers its own states/services/components
require('../app.module');

// Import any global transition hooks
require('../routerhooks/redirectTo');
