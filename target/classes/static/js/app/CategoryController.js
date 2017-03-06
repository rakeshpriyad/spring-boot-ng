'use strict';

angular.module('crudApp').controller('CategoryController',
    ['CategoryService', '$scope',  function( CategoryService, $scope) {

        var self = this;
        self.category = {};
        self.categories=[];

        self.submit = submit;
        self.getAllCategories = getAllCategories;
        self.createCategory = createCategory;
        self.updateCategory = updateCategory;
        self.removeCategory = removeCategory;
        self.editCategory = editCategory;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.category.categoryId === undefined || self.category.categoryId === null) {
                console.log('Saving New Category', self.category);
                createCategory(self.category);
            } else {
                updateCategory(self.category, self.category.categoryId);
                console.log('Category updated with id ', self.category.categoryId);
            }
        }

        function createCategory(category) {
            console.log('About to create category');
            CategoryService.createCategory(category)
                .then(
                    function (response) {
                        console.log('Category created successfully');
                        self.successMessage = 'Category created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.category={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Category');
                        self.errorMessage = 'Error while creating Category: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateCategory(category, categoryId){
            console.log('About to update category');
            CategoryService.updateCategory(category, categoryId)
                .then(
                    function (response){
                        console.log('Category updated successfully');
                        self.successMessage='Category updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Category');
                        self.errorMessage='Error while updating Category '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeCategory(categoryId){
            console.log('About to remove Category with id '+categoryId);
            CategoryService.removeCategory(id)
                .then(
                    function(){
                        console.log('Category '+categoryId + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Category '+categoryId +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllCategories(){
            return CategoryService.getAllCategories();
        }

        function editCategory(id) {
            self.successMessage='';
            self.errorMessage='';
            CategoryService.getCategory(id).then(
                function (category) {
                    self.category = category;
                },
                function (errResponse) {
                    console.error('Error while removing category ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.category={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);