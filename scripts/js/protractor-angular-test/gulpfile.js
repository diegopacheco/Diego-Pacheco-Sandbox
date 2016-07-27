var gulp = require('gulp');

var angularProtractor = require('gulp-angular-protractor');
    gulp.task('protractor-test', function(callback) {
        gulp
            .src(['./**/*.js']) 
            .pipe(angularProtractor({
                'configFile': 'conf.js',
                'debug': true,
                'autoStartStopServer': true
            }))
            .on('error', function(e) {
                console.log(e);
            })
            .on('end', callback);

});
