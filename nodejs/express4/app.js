// app main
var express = require('express');

// app
var app = express();

// app config
require('./config')(app);

// router
require('./routes')(app);

// error config must later routes
require('./error')(app);

// logger
var logger = require('./log4js').getLogger('main');


// start server
var server = app.listen(app.get('port'), function() {
	logger.info("express 4 server started in port %s", server.address().port);
});