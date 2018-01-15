System.config({
  defaultJSExtensions: true,

  packages: {
    "app": { "defaultExtension": "js" }
  },

  //dependencies
  meta: {
    'jqueryui'              : { format: 'global', deps: ['jquery']},
    'angular'               : { format: 'global', deps: ['jquery','jqueryui']}, //must load jquery before angular
    'angular-ui-router'     : { format: 'global', deps: ['angular']},
    'ui-router-extras-core' : { format: 'global', deps: ['angular']},
    'ui-router-visualizer'      : { format: 'global', deps: ['angular']},
    'moment'                : { format: 'global', exports: 'moment'},
    'groupBy'                : { format: 'global', deps: 'angular'}
  },

  //where to load js libs from
  map: {
    //cdn
    "jquery": "//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js",
    "jqueryui": "//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js",
    "angular": "//cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js",
    "bootstrap": "libs/bootstrap",  // v3.3.7
    "bootstrap-ui": "//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.1.2",
    "d3": "//cdnjs.cloudflare.com/ajax/libs/d3/3.5.16",
    "ui-router-extras-core": "//cdnjs.cloudflare.com/ajax/libs/ui-router-extras/0.1.2/modular/ct-ui-router-extras.core.min.js",
    "font-awesome": "//maxcdn.bootstrapcdn.com/font-awesome/4.6.1",
    "ionicons": "//cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css",
    "lodash" : "//cdnjs.cloudflare.com/ajax/libs/lodash.js/2.4.1/",
    "moment": "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js",

    //local libs
    "angular-ui-router": "libs/angular-ui-router/angular-ui-router.min.js",
    "ui-router-visualizer": "libs/ui-router-visualizer/release/visualizer.js",
    "adminlte": "libs/adminlte-dist",
    "css": "libs/systemjs-plugin-css/css",
    "angular-utils-pagination": "libs/angular-utils-pagination/dirPagination",
    "angular-growl": "libs/angular-growl-v2/build",
    "angular-jwt": "libs/angular-jwt/dist/angular-jwt.js"
  }

});