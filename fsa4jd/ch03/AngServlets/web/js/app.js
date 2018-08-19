var app = angular.module('userregistrationsystem', ['ngRoute', 'ngResource']);

app.config(function($routeProvider) {
    $routeProvider.when('/list-all-users', {
        templateUrl : 'template/listuser.html',
        controller : 'listUserController'
    }).when('/register-new-user', {
        templateUrl : 'template/userregistration.html',
        controller : 'registerUserController'
    }).otherwise({
        redirectTo : '/home',
        templateUrl : 'template/home.html'
    });
});