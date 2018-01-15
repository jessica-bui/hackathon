"use strict";
var hackathonApp = require("../bootstrap/ngmodule");
/**
 * This service stores and retrieves user preferences in session storage
 */
var AppConfig = (function () {
    function AppConfig() {
        this.uaid = undefined;
        this.token = undefined;
        this.selectedProject = undefined;
        this.rw = undefined;
    }

    AppConfig.prototype.load = function () {
        try {
            return angular.extend(this, angular.fromJson(sessionStorage.getItem("hackathonConfig")));
        }
        catch (Error) { }
        return this;
    };
    AppConfig.prototype.save = function () {
        sessionStorage.setItem("hackathonConfig", angular.toJson(angular.extend({}, this)));
    };
    return AppConfig;
}());
hackathonApp.ngmodule.value('AppConfig', new AppConfig().load());
