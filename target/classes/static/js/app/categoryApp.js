var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/spring-boot-ng-crud/',
    USER_SERVICE_API : 'http://localhost:8080/spring-boot-ng-crud/category/loadAllCategories/',
    CATEGORY_SERVICE_API : 'http://localhost:8080/spring-boot-ng-crud/category/loadAllCategories/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/categoryList',
                controller:'CategoryController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, CategoryService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        CategoryService.loadAllCategories().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
           $urlRouterProvider.otherwise('/');
    }]);

