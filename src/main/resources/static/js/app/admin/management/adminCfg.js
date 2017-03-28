/**
 * Created by ok on 2017-03-20.
 */
angular.module('app')
.config(function ($routeProvider) {
    $routeProvider
        .when('/post', {
            templateUrl: 'js/app/admin/management/post/post_management.html',
            controller: 'PostManagementController',
            controllerAs: 'postCtrl'
        })
        .when('/user', {
            templateUrl: 'js/app/admin/management/user/user_management.html',
            controller: 'UserManagementController',
            controllerAs: 'userCtrl'
        })
        .when('/photo', {
            templateUrl: 'js/app/admin/management/photo/photo_management.html',
            controller: 'PhotoManagementController',
            controllerAs: 'photoCtrl'
        })
});