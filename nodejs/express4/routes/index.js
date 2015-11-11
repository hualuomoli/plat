// routers defult is index.js

var main = require('./main');
var user = require('./user');


module.exports = function(app) {
	// main path
	app.get('/', main.main);

	// use module
	app.use('/user', user);


	// con't match path. goto main
	app.get('/*', main.all);


};