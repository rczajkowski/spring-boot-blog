/**
 * Created by rafau on 2017-03-27.
 */
angular.module('app')
    .constant('USER_ENDPOINT', '/api/users/:username')
    .factory('User', function ($resource, USER_ENDPOINT) {
        return $resource(USER_ENDPOINT, {username: "@username"},{
            update: {method: 'PUT'}
        });
    })
    .service('Users', function (User) {

        this.getAllUsers = function () {
            return User.query();
        }

        this.getUser = function (username) {
            return User.get({username: username});
        }

        this.add = function (newUser) {
            newUser.$save();
        }

        this.deleteOne = function (userToDelete) {
            userToDelete.$delete({username: userToDelete.username});
        }

        this.up = function (userToUpdate) {
            userToUpdate.$update();
        }
    });
