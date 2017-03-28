/**
 * Created by rafau on 2017-03-16.
 */
angular.module('app')
.controller('ListController', function (Posts) {
    var vm = this;

    vm.posts = Posts.getAll();

    console.log('list loaded');
    console.log(vm.posts);
});