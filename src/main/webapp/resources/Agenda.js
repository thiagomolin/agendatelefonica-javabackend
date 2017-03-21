
angular.module("AgendaApp", [])
        .value('urlBase', 'http://localhost:8080/AgendaTelefonica1/rest/')
        .controller("AgendaController", function ($http, urlBase) {
            var self = this;

            self.contatos = [];

            self.contato = undefined;
            self.confirmar = undefined;

            self.novo = function () {
                self.contato = {};
            };

            self.salvar = function () {
                self.contato = undefined;
                var metodo = 'POST';
                if (self.contato.id) {
                    metodo = 'PUT';
                }

                $http({
                    method: metodo,
                    url: urlBase + 'contatos/',
                    data: self.contato
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.editar = function (contato) {
                //TODO CODE HERE     
                self.contato = undefined;
                //TODO CODE HERE         
            };

            self.removerContato = function () {
                alert("crapper");
                $http({
                    method: 'DELETE',
                    url: urlBase + 'chamados/' + self.contato.id + '/'
                }).then(function successCallback(response) {                    
                    alert(self.contato.id);
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    alert("shit");
                    self.ocorreuErro();
                });
                self.contato = undefined;
                self.confirmar = undefined; 
            };

            self.ocorreuErro = function () {
                alert("Ocorreu um erro inesperado!");
            };

            self.confirmarRemocao = function (contato) {
                self.confirmar = {};
                self.contato = contato;
            };

            self.cancelarRemocao = function () {
                alert("crapper2");
                self.confirmar = undefined;
                self.contato = undefined;
            };


            self.atualizarTabela = function () {
                $http({
                    method: 'GET',
                    url: urlBase + 'contatos/'
                }).then(function successCallback(response) {
                    self.contatos = response.data;
                    self.contato = undefined;
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.activate = function () {
                self.atualizarTabela();
            };
            self.activate();

        });