var gulp = require('gulp');
var del = require('del');

/** config copy */
var buildFolder = 'public/components';
var copyConfig = [
	// bootstrap
	{
		src: 'bower_components/bootstrap/dist/**',
		dest: 'public/components/bootstrap/dist'
	},
	// jquery
	{
		src: 'bower_components/jquery/dist/**',
		dest: 'public/components/jquery/dist'
	},
	// require
	{
		src: 'bower_components/requirejs/require.js',
		dest: 'public/components/requirejs'
	},
	// angular
	{
		src: ['bower_components/angular/angular.js',
			'bower_components/angular/angular.min.js'
		],
		dest: 'public/components/angular'
	}

];


// clean
gulp.task('clean', function(cb) {
	del([buildFolder], cb);
});

// copy
gulp.task('bower_copy', ['clean'], function(cb) {

	for (var i = 0; i < copyConfig.length; i++) {
		var config = copyConfig[i];
		var src = config.src;
		var dest = config.dest;

		gulp.src(src).pipe(gulp.dest(dest));
	}

});

// default
gulp.task('default', ['bower_copy']);