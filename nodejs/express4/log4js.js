var log4js = require('log4js');


log4js.configure({
	appenders: [{
		type: 'console'
	}, {
		type: 'file',
		filename: 'logs/cheese.log',
		category: 'cheese'
	}]
});

var levels = {
	'main': 'debug',
	'nodejs': 'debug'
};

// get log4js's name default nodejs
var getName = function(name) {
	if (name) {
		return name;
	}
	return 'nodejs';
};

// get log4js's level default debug
var getLevel = function(name) {
	var level = levels[name];
	if (level) {
		return level;
	}
	return 'debug';
};

// get log4j by name
exports.getLogger = function(name) {
	name = getName(name);
	var logger = log4js.getLogger(name); // get log4js by name
	logger.setLevel(getLevel(name)); // set level
	return logger;
};