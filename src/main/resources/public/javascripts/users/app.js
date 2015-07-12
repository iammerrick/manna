angular.module('app', [])
    .controller('SubscribeCtrl', function($http, $scope) {
        var users = [];
        var self = this;

        this.showForm = true;

        this.submit = function(e) {
            e.preventDefault();

            users.push({
                number: number(self.number),
                name: self.name,
                plans: 1
            });

            if (self.friendNumber || self.friendName) {
                users.push({
                    number: self.friendNumber && number(self.friendNumber),
                    name: self.friendName,
                    plan: 2
                });
            }
            $http.post('/register', users)
                .success(function(response) {
                    self.showForm = false;
                })
                .catch(function(err) {
                    self.errors = err.data.errors;
                    self.fields = err.data.fields;
                });
        };

        function number(target) {
            if (! target) return '';
            return target.replace(/(-|\.|_|\s)/g, '');
        }
    });