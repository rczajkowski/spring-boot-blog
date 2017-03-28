/**
 * Created by rafau on 2017-03-16.
 */
angular.module('app')
.controller('ShowController', function ($routeParams, Posts) {
    var vm = this;
    var postIndex = $routeParams.id;

    vm.post = Posts.getOne(postIndex);
});