app.controller('registerUserController',
    function ($scope, $http, $location, $route) {
        $scope.submitUserForm = function () {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/ang/user',
                data: $scope.user
            }).then(
                function (response) {
                    $location.path("/list-all-users");
                    $route.reload();
                },
                function (errResponse) {
                    $scope.errorMessage = errResponse.data.errorMessage;
                }
            );
        };

        $scope.resetForm = function () {
            $scope.user = null;
        };
    }
);

app.controller('listUserController',
    function ($scope, $http, $location, $route) {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/ang/user'
        }).then(function (response) {
            $scope.users = response.data;
        });
    }
);

