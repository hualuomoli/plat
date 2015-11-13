// index
var express = require('express');
var login = require('./login');

// set router
module.exports = function(app) {

	app.get('/', function(req, res, next) {
		res.render('index', {
			title: 'Node JS'
		});
	});

	app.use('/login', login);

}