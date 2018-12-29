<div class="generic-container" style="text-align: -webkit-center;">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Weather Balloon logs</span></div>
		<div class="panel-body">
	        <div class="formcontainer" >
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <div>
	            <div style="width: 34%;float: left;">
	            	<img src="/image/cropped-balloon.png" style="width: 60%;"/>
	            </div>
	            <div style="width:50%; float: left; margin-top: 20px;">
	            <table class="table table-hover"  >
	            <tr>
	            	<td><button type="button" ng-click="ctrl.generateLog()" class="btn btn-success btn-sm">Generate Log</button></td>
	            	<td></td>
	            </tr>
	            <tr>
	            	<td><button type="button" ng-click="ctrl.findMinTemp()" class="btn btn-success btn-sm">Minimum Temperature</button></td>
	            	<td>{{ctrl.minTemp}}</td>
	            </tr>
	            <tr>
	            	<td><button type="button" ng-click="ctrl.findMaxTemp()" class="btn btn-success btn-sm">Maximum Temperature</button></td>
	            	<td>{{ctrl.maxTemp}}</td>
	            </tr>
	            <tr>
	            	<td><button type="button" ng-click="ctrl.findMeanTemp()" class="btn btn-success btn-sm">Mean Temperature</button></td>
	            	<td>{{ctrl.meanTemp}}</td>
	            </tr>
	            <tr>
	            	<td><button type="button" ng-click="ctrl.totalDist()" class="btn btn-success btn-sm">Total Distance traveled</button></td>
	            	<td></td>
	            </tr>
	            </table>
	            </div>
	            </div>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Observations from each observatory</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>AU</th>
		                <th>US</th>
		                <th>FR</th>
		                <th>Others</th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr >
		                <td>{{ctrl.observation.obsAU}}</td>
		                <td>{{ctrl.observation.obsUS}}</td>
		                <td>{{ctrl.observation.obsFR}}</td>
		                <td>{{ctrl.observation.obsOther}}</td>
		                <td><button type="button" ng-click="ctrl.findNumbOfObs()" class="btn btn-success custom-width">Refresh</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>