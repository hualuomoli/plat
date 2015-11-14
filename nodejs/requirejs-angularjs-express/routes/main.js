var express = require('express');
var logger = require('../log4js').getLogger('main');

/* main path */
exports.main = function(req, res, next) {
	res.render('index', {
		title: "Express4"
	});
};

/** all path */
exports.all = function(req, res, next) {
	logger.debug('the path "%s" is invalidate. redirect to %s', req.path, req.baseUrl);
	res.redirect("./");
};