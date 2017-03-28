/**
 * Created by rafau on 2017-03-16.
 */
angular.module('app')
.constant('POST_ENDPOINT', '/api/posts/:id')
.factory('Post', function ($resource, POST_ENDPOINT) {
    return $resource(POST_ENDPOINT, {id: "@id"},{
        update: { method: 'PUT' }
    });
})
.service('Posts', function (Post) {
    this.getAll = function () {
        return Post.query();
    }

    this.getOne = function (index) {
        return Post.get({id: index});
    }

    this.add = function (post) {
        post.$save();
    }
    
    this.deleteOne = function (post) {
        post.$delete({id: post.id});
    }

    this.up = function (post) {
        post.$update();
    }
});
