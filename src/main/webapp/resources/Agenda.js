
angular.module("AgendaApp", [])
        .controller("AgendaController", function ($http) {
            var self = this;

            self.contatos = [];

            self.contato = undefined;
            self.confirmar = undefined;

            var tempContato1 = {
                id: 2,
                nome: 'Rodrigo',
                telefone: 4932145687,
                celular: 4587564231,
                endereco: 'Rua camões 897'
            };

            var tempContato2 = {
                id: 3,
                nome: 'Grazi',
                telefone: 79874655,
                celular: 12357895,
                endereco: 'Rua 3, 897'
            };

            self.contatos.push(tempContato1);
            self.contatos.push(tempContato2);

            self.salvar = function () {
                self.contato = undefined;
                //TODO CODE HERE
            };

            self.novo = function () {
                self.contato = {};
            };

            self.confirmarRemocao = function (contato) {
                self.confirmar = {};
                self.contato = contato;
            };




            self.removerContato = function () {
                self.confirmar = undefined;
                self.contato = undefined;
            };

            self.cancelarRemocao = function () {
                self.confirmar = undefined;
                self.contato = undefined;
            };


            self.editar = function (contato) {
                self.contato = undefined;
                //TODO CODE HERE         
            };

        });