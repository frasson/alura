var gulp = require('gulp'), 
    imagemin = require('gulp-imagemin'), 
    clean = require('gulp-clean');

/**
 * Como o clean é uma dependência, utilizamos o return, 
 * assim garantimos que ela vai ser executada complementamente 
 * antes que a próxima tarefa seja executada.
 */    
gulp.task('clean', function(){
    return gulp.src('dist')
        .pipe(clean());
});

/*
 * O segundo parâmetro é um array de dependência 
 * que deve ser executada antes dessa tarefa.
 */
gulp.task('copy', ['clean'],function(){
    return gulp.src('src/**/*')
        .pipe(gulp.dest('dist'));
});

gulp.task('build-img', ['copy'], function(){

    gulp.src('src/img/**/*')
        .pipe(imagemin())
        .pipe(gulp.dest('src/img'));
});