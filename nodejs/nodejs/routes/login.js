// login router
var express = require('express');

var router = express.Router();

// get url params
router.all("/*", function(req, res, next) {
	console.log('url    = %s', req.baseUrl);
	console.log('params = %s', JSON.stringify(req.params));
	console.log('body   = %s', JSON.stringify(req.body));
	console.log('query  = %s', JSON.stringify(req.query));

	next();

});


// index
router.get('/', function(req, res, next) {
	res.render('login/index', {
		title: "login"
	});
});


// login
router.post('/', function(req, res, next) {
	// session
	res.render('login/main', {
		title: 'welcom',
		nickname: "administrator"
	});
});


// logout
router.get('/logout', function(req, res, next) {
	res.send('logout ok');
});


module.exports = router;