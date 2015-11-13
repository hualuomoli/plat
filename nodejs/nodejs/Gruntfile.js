module.exports = function(grunt) {

	// Project configuration.
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		// copy: {
		// 	main: {
		// 		files: [{
		// 			expend: true,
		// 			src: ['bower_components/bootstrap/dist/**'],
		// 			dest: 'public/',
		// 		}]
		// 	}
		// }
	});

	// grunt.loadNpmTasks('grunt-contrib-copy');

	// Default task(s).
	grunt.registerTask('default', ['copy']);

};