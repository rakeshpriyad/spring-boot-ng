var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/spring-boot-ng-crud/',
    USER_SERVICE_API : 'http://localhost:8080/spring-boot-ng-crud/company/loadAllCompanies/',
    COMPANY_SERVICE_API : 'http://localhost:8080/spring-boot-ng-crud/company/loadAllCompanies/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/companyList',
                controller:'CompanyController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, CompanyService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        CompanyService.loadAllCompanies().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
           $urlRouterProvider.otherwise('/');
    }]);

