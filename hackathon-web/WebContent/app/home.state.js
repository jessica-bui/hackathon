"use strict";

//controller
var _controller = function ($timeout) { 

    //manipulate ui
    $timeout(function () {
        //DOM has finished rendering

        $.AdminLTE.layout.activate(); //fixes layout
    });
};

exports.reg_state = {
    parent: 'app',
    name: 'home',
    url: '/home',
    templateUrl : "app/views/home.html",
    controller: _controller
};
