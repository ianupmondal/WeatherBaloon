'use strict';

angular.module('crudApp').controller('LogController',
    ['LogService', '$scope',  function( LogService, $scope) {

        var self = this;

        self.generateLog = generateLog;
        self.findMinTemp = findMinTemp;
        self.findMaxTemp = findMaxTemp;
        self.findMeanTemp = findMeanTemp;
        self.findNumbOfObs = findNumbOfObs;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.minTemp = '';
        self.maxTemp = '';
        self.meanTemp = '';
        self.observation;


        function generateLog() {
            console.log('About to create log');
            LogService.generateLog()
                .then(
                    function (response) {
                        console.log('Log created successfully');
                        self.successMessage = 'Log created successfully';
                        self.errorMessage='';
                        self.done = true;
                    },
                    function (errResponse) {
                        console.error('Error while creating Log');
                        self.errorMessage = 'Error while creating Log: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function findMinTemp(){
            console.log('About to find min Temp');
            LogService.findMinTemp()
                .then(
                    function (response){
                        console.log('Min Temp');
                        self.successMessage='Min Temp function executed successfully';
                        self.errorMessage='';
                        self.minTemp = response;
                        self.done = true;
                    },
                    function(errResponse){
                        console.error('Error while Min Temp function');
                        self.errorMessage='Min Temp function failed '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
        
        function findMaxTemp(){
            console.log('About to find max Temp');
            LogService.findMaxTemp()
                .then(
                    function (response){
                        console.log('Max Temp');
                        self.successMessage='Max Temp function executed successfully';
                        self.errorMessage='';
                        self.maxTemp = response;
                        self.done = true;
                    },
                    function(errResponse){
                        console.error('Error while Max Temp function');
                        self.errorMessage='Max Temp function failed '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
        
        function findMeanTemp(){
            console.log('About to find mean Temp');
            LogService.findMeanTemp()
                .then(
                    function (response){
                        console.log('Mean Temp');
                        self.successMessage='Mean Temp function executed successfully';
                        self.errorMessage='';
                        self.meanTemp = response;
                        self.done = true;
                    },
                    function(errResponse){
                        console.error('Error while Mean Temp function');
                        self.errorMessage='Mean Temp function failed '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
        
        function findNumbOfObs(){
            console.log('About to find Number of observations');
            LogService.findNumbOfObs()
                .then(
                    function (response){
                        console.log('Number of observations success');
                        self.successMessage='Number of observations function executed successfully';
                        self.errorMessage='';
                        self.observation = response;
                        self.done = true;
                    },
                    function(errResponse){
                        console.error('Error while Number of observations function');
                        self.errorMessage='Number of observations function failed '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
        }
    }


    ]);