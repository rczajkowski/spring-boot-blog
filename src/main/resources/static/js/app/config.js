/**
 * Created by rafau on 2017-03-16.
 */
angular.module('app')
.config(function ($routeProvider) {
    $routeProvider
        .when('/list', {
            templateUrl: 'js/app/post/list/list.html',
            controller: 'ListController',
            controllerAs: 'listCtrl'
        })

        .when('/show/:id', {
            templateUrl: 'js/app/post/show_post/show.html',
            controller: 'ShowController',
            controllerAs: 'showCtrl'
        })

        .when('/signup', {
            templateUrl: 'js/app/user/signup/signup.html',
            controller: 'SignUpController',
            controllerAs: 'signUpCtrl'
        })

        .otherwise({
            redirectTo:'/list'
        });
});