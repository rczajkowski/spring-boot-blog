/**
 * Created by rafau on 2017-04-09.
 */
angular.module('app')
    .directive('unique', function (Users, User) {
        return{
            require: 'ngModel',
            link: function(scope, element, attr, mCtrl){

                //TODO compare with all emails in db
                function myValidation(value) {

                    if(value === "gg@gmail.com" ){
                        mCtrl.$setValidity('uniqueEmail', false);
                    }
                    else{
                        mCtrl.$setValidity('uniqueEmail', true);
                    }
                        return value;
                    }
                mCtrl.$parsers.push(myValidation);
            }
        };
    });
