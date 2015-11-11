// setting route

var index = require('./index');
var user = require('./user');


module.exports = function(app) {
	app.get('/', index.index);
	app.use('/user', user);
};