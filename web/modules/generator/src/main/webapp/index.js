'use strict';

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.created = true;
	$scope.tableName = "account";
	$scope.dataList = [];
	$scope.retMsg = [];
	$scope.init = true;
	$scope.url = "http://localhost:8080/generator/generator/listData?database=mysql&owner=ln_test&tableName=";
	$scope.search = function() {
		$http.get($scope.url + $scope.tableName)
		    .success(function(datas) {
		    	$scope.init = false;
		    	$scope.created = false;
		    	$scope.dataList = datas;
		    });
	};
	$scope.urlsave = "http://localhost:8080/generator/generator/save";
	$scope.save = function(){
		$http({
	        method  : 'POST',
	        url     : $scope.urlsave,
	        data    : {tableName:$scope.tableName,columnList:$scope.dataList},  // pass in data as strings
	        headers : { 'Content-Type': 'application/x-www-form-urlencoded' }// set the headers so angular passing info as form data (not request payload)
	    })
	    .success(function(datas) {
	    	$scope.init = false;
	    	$scope.tableName = '';
	    	$scope.dataList = [];
	    	$scope.created = true;
	    	$scope.retMsg = datas;
	    });
	};
});