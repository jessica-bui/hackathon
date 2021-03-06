"use strict";
var hackathonApp = require("../bootstrap/ngmodule");
/**
 * Adds a custom global "redirectTo" transition hook.
 *
 * This hook will be triggered if the destination state has a 'redirectTo' property.
 * The hook will return a new TargetState based on the value of the original destination state's 'redirectTo' property.
 * The Transition will then be redirected to the new TargetState.
 */
hackathonApp.ngmodule.run(function ($state, $transitions) {
	// Matches if the destination state has a 'redirectTo' property
	var matchCriteria = { to: function (state) { return state.redirectTo != null; } };
	// Function that returns a redirect for a transition, with a TargetState created using the destination state's 'redirectTo' property
	var redirectFn = function ($transition$) { return $state.target($transition$.to().redirectTo); };
	// Register the global 'redirectTo' hook
	$transitions.onBefore(matchCriteria, redirectFn);
});
