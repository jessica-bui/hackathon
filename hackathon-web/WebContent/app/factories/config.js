'use strict';

var roxyApp = require("../bootstrap/ngmodule");

roxyApp.ngmodule.factory('CONFIG', function($location) {

	var domainBase = $location.host();

	if($location.port()!='') domainBase += (':' + $location.port());

	return {
		API_URL: 'http://'+domainBase+'/hakathon-rest'
	};
});
