angular.module('minhasDiretivas', [])
.directive('meuPainel', function(){
    var ddo = {};

    ddo.restrict = "AE";
    /**
     * 'A' - only matches attribute name
     * 'E' - only matches element name
     * 'C' - only matches class name
     * 'M' - only matches comment
     */    

    ddo.transclude = true;
    /**
     * Indica que algum elemento do template vai
     *  manter seus elementos filhos
     */
    
    ddo.scope = {
        titulo: '@'
    }
    /**
     * Quando for o mesmo nome do atributo, basta apenas colocar o @, 
     * caso contrário deve ser colocado o nome
     */    

    ddo.templateUrl = 'js/directives/meu-painel.html'

    return ddo;
})
.directive('minhaFoto', function(){
    var ddo = {};

    ddo.restrict = "AE";
    
    ddo.scope = {
        titulo: '@',
        url: '@' 
    }
    
    ddo.templateUrl = 'js/directives/minha-foto.html';

    return ddo;
})
.directive('meuBotaoPerigo', function() {
        var ddo = {};
        ddo.restrict = "E";
        ddo.scope = {
            nome: '@',
            acao : '&'
        }
        ddo.template = '<button class="btn btn-danger btn-block" ng-click="acao()">{{nome}}</button>';

        return ddo;
})
.directive('meuFocus', function() {
        var ddo = {};
        ddo.restrict = "A";
       // não tem mais scope
        ddo.link = function(scope, element) {
             scope.$on('fotoCadastrada', function() {
                 element[0].focus();
             });
        };

        return ddo;
    });
