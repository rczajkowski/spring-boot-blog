/**
 * Created by rafau on 2017-03-27.
 */
angular.module('app')
    .constant('USER_ENDPOINT', '/api/users/:id')
    .factory('User', function ($resource, USER_ENDPOINT) {
        return $resource(USER_ENDPOINT, {id: "@id"},{
            update: {method: 'PUT'}
        });
    })
    .service('Users', function (User) {

        this.getAllUsers = function () {
            return User.query();
        }

        this.getUser = function (index) {
            return User.get({id:index});
        }

        this.add = function (newUser) {
            newUser.$save();
        }

        this.deleteOne = function (userToDelete) {
            userToDelete.$delete({id: userToDelete.id});
        }

        this.up = function (userToUpdate) {
            userToUpdate.$update();
        }
    });
