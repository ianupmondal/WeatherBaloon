'use strict';

angular.module('crudApp').factory('LogService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                generateLog: generateLog,
                findMinTemp: findMinTemp,
                findMeanTemp: findMeanTemp,
                findMaxTemp: findMaxTemp,
                findNumbOfObs: findNumbOfObs
            };

            return factory;

            function generateLog() {
                console.log('Generating Log');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + "generate/")
                    .then(
                        function (response) {
                           // loadAllLogs();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Log : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function findMinTemp() {
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + "minTemp/")
                    .then(
                        function (response) {
                            //loadAllLogs();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            function findMaxTemp() {
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + "maxTemp/")
                    .then(
                        function (response) {
                            //loadAllLogs();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            function findMeanTemp() {
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + "meanTemp/")
                    .then(
                        function (response) {
                            //loadAllLogs();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function findNumbOfObs() {
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + "numOfObserv/")
                    .then(
                        function (response) {
                            //loadAllLogs();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);