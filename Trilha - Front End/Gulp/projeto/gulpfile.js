var gulp = require('gulp'),
    imagemin = require('gulp-imagemin'),
    clean = require('gulp-clean'),
    htmlreplace = require('gulp-html-replace'),
    uglify = require('gulp-uglify'),
    cssmin = require('gulp-cssmin'),
    usemin = require('gulp-usemin'),
    concate = require('gulp-concat'),
    browserSync = require('browser-sync'),
    jshint = require('gulp-jshint'),
    jshintStylish = require('jshint-stylish'),
    csslint = require('gulp-csslint'),
    autoprefixer = require('gulp-autoprefixer');

gulp.task('default', ['copy'], function() {
    gulp.start('build-img', 'usemin');
});

gulp.task('copy', ['clean'], function() {
    return gulp.src('src/**/*').pipe(gulp.dest('dest'));
});

gulp.task('clean', function() {
    return gulp.src('dest').pipe(clean());
});

gulp.task('build-img', function() {
    gulp.src('dest/img/**/*')
        .pipe(imagemin())
        .pipe(gulp.dest('dest/img'));
});

gulp.task('usemin', function() {
    gulp.src('dest/**/*.html')
        .pipe(usemin({
            'js' : [uglify],
            'css' : [autoprefixer, cssmin]
        }))
        .pipe(gulp.dest('dest'));
});

gulp.task('server', function() {
    browserSync.init({
        server : {
            baseDir : 'src'
        }
    });

    gulp.watch('src/js/**/*.js').on('change', function(event) {
        gulp.src(event.path)
            .pipe(jshint())
            .pipe(jshint.reporter(jshintStylish));
    });

    gulp.watch('src/css/**/*.css').on('change', function(event) {
        gulp.src(event.path)
            .pipe(csslint())
            .pipe(csslint.reporter());
    });

    gulp.watch('src/**/*').on('change', browserSync.reload);
});