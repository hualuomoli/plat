// app main
var express = require('express');

// app
var app = express();

// app config
require('./config')(app);
// error config
require('./error')(app);
// router
require('./routes/routes')(app);

// logger
// var logger = require('./log4js').getLogger('main');


// start server
var server = app.listen(app.get('port'), function() {
	// logger.info("express 4 server started in port %s", server.address().port);
});