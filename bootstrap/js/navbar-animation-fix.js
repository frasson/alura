$('#menu-hamburguer').on('show.bs.collapse', function(){
    $('.topCasaFina-banner').css('transform', 'translate(-50%, 10%)');
});

$('#menu-hamburguer').on('hide.bs.collapse', function(){
    $('.topCasaFina-banner').css('transform', 'translate(-50%, -50%)');
});