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