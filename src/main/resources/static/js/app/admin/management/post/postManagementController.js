/**
 * Created by rafau on 2017-03-19.
 */
angular.module('app')
    .controller('PostManagementController', function (Post, Posts, $scope) {
        var vm = this;

        vm.post = new Post();

        vm.posts = Posts.getAll();

        $scope.addNew = false;
        $scope.edit = false;

        vm.savePost = function () {
            vm.post.date = new Date();
            Posts.add(vm.post);
            vm.post = new Post();
            location.reload();
        }

        vm.edit = function (index) {
            vm.post = Posts.getOne(index);
            $scope.edit = true;
        }

        //TODO update post angular?
        vm.update = function () {
            vm.postToUpdate = angular.copy(vm.post);
            Posts.up(vm.postToUpdate);
            location.reload();
            vm.post = new Post();
        }

        vm.delete = function (index) {
            vm.post = new Post({id: index});
            Posts.deleteOne(vm.post);
            vm.post = new Post();
            location.reload();
        }

    });