/**
 * Created by rafau on 2017-03-16.
 */
angular.module('app')
.controller('ShowController', function ($routeParams, Posts, $resource) {
    var vm = this;
    var postIndex = $routeParams.id;

    vm.post = Posts.getOne(postIndex);

    var com = $resource('/api/:postId/comments');
    vm.comments = com.query({postId: postIndex});
});