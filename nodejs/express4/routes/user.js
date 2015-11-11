var express = require('express');
var logger = require('../log4js').getLogger('user');

var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
	res.send('respond with a resource');
});

router.get('/list', function(req, res, next) {
	res.render('user/list', {
		title: 'user list'
	});
});


router.get('/*', function(req, res, next) {
	res.redirect('/user');
});

module.exports = router;