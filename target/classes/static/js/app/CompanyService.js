'use strict';

angular.module('crudApp').factory('CompanyService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllCompanies: loadAllCompanies,
                getAllCompanies: getAllCompanies,
                getCompany: getCompany,
                createCompany: createCompany,
                updateCompany: updateCompany,
                removeCompany: removeCompany
            };

            return factory;

            function loadAllCompanies() {
                console.log('Fetching all companies');
                var deferred = $q.defer();
                $http.get(urls.COMPANY_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all companies');
                            $localStorage.companies = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading companies');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllCategories(){
                return $localStorage.companies;
            }

            function getCompany(id) {
                console.log('Fetching Company with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.CATEGORY_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Company with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading category with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createCompany(category) {
                console.log('Creating Company');
                var deferred = $q.defer();
                $http.post(urls.CATEGORY_SERVICE_API, category)
                    .then(
                        function (response) {
                            loadAllCategories();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Company : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateCompany(category, id) {
                console.log('Updating Company with id '+id);
                var deferred = $q.defer();
                $http.put(urls.CATEGORY_SERVICE_API + id, category)
                    .then(
                        function (response) {
                            loadAllCategories();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Company with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeCompany(id) {
                console.log('Removing Company with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.CATEGORY_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllCategories();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Company with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);