var app = angular.module('app', []);

app.controller('SchedulerCtrl', function($http, $scope) {
  
  var self = this;

  this.plans = [];

  this.save = function() {
    var plan = self.texts.map(function(text) {
      var chunk = text.chunk;
      text.text.delay = (
        (chunk.days * 1000 * 60 * 60 * 24) +
        (chunk.hours * 1000 * 60 * 60) +
        (chunk.minutes * 1000 * 60)
      );
      return text.text;
    });

    $http.put('/api/plans/'+self.selectedPlan.id, {
      plan: plan
    });
  }

  $http.get('/api/plans/')
    .then(function(response) {
      self.plans = response.data;
    });


  $scope.$watch(function(selectedPlan) {
    return self.selectedPlan;
  }, initialize);


  function initialize(plan) {
    if (!plan) return null;


    self.texts = plan.plan.map(function(text) {
      var chunk = toTimeChunk(text.delay);

      return {
        text: text,
        chunk: chunk
      };
    });
  }


  function toTimeChunk(milliseconds) {
    var days = parseInt(milliseconds / 1000 / 60 / 60 / 24)
    var hours = parseInt((milliseconds % (1000 * 60 * 60 * 24)) / 1000 / 60 / 60);
    var minutes = (milliseconds % (1000 * 60 * 60)) / 1000 / 60 ;
    return {
      days: days,
      hours: hours,
      minutes: minutes
    };
  }

});
