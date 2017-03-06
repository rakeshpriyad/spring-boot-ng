'use strict';

angular.module('crudApp').controller('CompanyController',
    ['CompanyService', '$scope',  function( CompanyService, $scope) {

        var self = this;
        self.company = {};
        self.companies=[];

        self.submit = submit;
        self.getAllCompanies = getAllCompanies;
        self.createCompany = createCompany;
        self.updateCompany = updateCompany;
        self.removeCompany = removeCompany;
        self.editCompany = editCompany;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.company.companyId === undefined || self.company.companyId === null) {
                console.log('Saving New Company', self.company);
                createCompany(self.company);
            } else {
                updateCompany(self.company, self.company.companyId);
                console.log('Company updated with id ', self.company.companyId);
            }
        }

        function createCompany(company) {
            console.log('About to create company');
            CompanyService.createCompany(company)
                .then(
                    function (response) {
                        console.log('Company created successfully');
                        self.successMessage = 'Company created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.company={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Company');
                        self.errorMessage = 'Error while creating Company: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateCompany(company, companyId){
            console.log('About to update company');
            CompanyService.updateCompany(company, companyId)
                .then(
                    function (response){
                        console.log('Company updated successfully');
                        self.successMessage='Company updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Company');
                        self.errorMessage='Error while updating Company '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeCompany(companyId){
            console.log('About to remove Company with id '+companyId);
            CompanyService.removeCompany(id)
                .then(
                    function(){
                        console.log('Company '+companyId + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Company '+companyId +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllCompanies(){
            return CompanyService.getAllCompanies();
        }

        function editCompany(id) {
            self.successMessage='';
            self.errorMessage='';
            CompanyService.getCompany(id).then(
                function (company) {
                    self.company = company;
                },
                function (errResponse) {
                    console.error('Error while removing company ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.company={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);