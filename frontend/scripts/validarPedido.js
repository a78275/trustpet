// Data de inicio
$('#dataInicio').on('input', function() {
    var input=$(this);
    var error_element=$("span", input.parent());
    var partsHora = $('#horaInicio').val().split(':');
    var partsDate = input.val().split('-');
    var date = new Date(partsDate[0], partsDate[1] - 1, partsDate[2], partsHora[0], partsHora[1], 0, 0);
    if(date >= Date.now()){
        input.removeClass("invalid").addClass("valid");
        error_element.removeClass("error_show").addClass("error");
    }
    else{
        input.removeClass("valid").addClass("invalid");
        error_element.removeClass("error").addClass("error_show");
    }
});

// Data de fim
$('#dataFim').on('input', function() {
    var input=$(this);
    var error_element=$("span", input.parent());
    var partsHoraInicio = $('#horaInicio').val().split(':');
    var partsDateInicio = $('#dataInicio').val().split('-');
    var dateInicio = new Date(partsDateInicio[0], partsDateInicio[1] - 1, partsDateInicio[2], partsHoraInicio[0], partsHoraInicio[1], 0, 0);
    var partsHoraFim = $('#horaFim').val().split(':');
    var partsDateFim = $('#dataFim').val().split('-');
    var dateFim = new Date(partsDateFim[0], partsDateFim[1] - 1, partsDateFim[2], partsHoraFim[0], partsHoraFim[1], 0, 0);
    if(dateFim > dateInicio){
        input.removeClass("invalid").addClass("valid");
        error_element.removeClass("error_show").addClass("error");
    }
    else{
        input.removeClass("valid").addClass("invalid");
        error_element.removeClass("error").addClass("error_show");
    }
});

// HoraInicio
$('#horaInicio').on('input', function() {
	var input=$(this);
    var valid=input.val();
    var error_element=$("span", input.parent());
    if(valid){
        input.removeClass("invalid").addClass("valid");
        error_element.removeClass("error_show").addClass("error");

        var element=$("#dataInicio");
        var error_element=$("span", element.parent());
        var partsHora = $('#horaInicio').val().split(':');
        var partsDate = element.val().split('-');
        var date = new Date(partsDate[0], partsDate[1] - 1, partsDate[2], partsHora[0], partsHora[1], 0, 0);
        if(date >= Date.now()){
            element.removeClass("invalid").addClass("valid");
            error_element.removeClass("error_show").addClass("error");
        }
        else{
            element.removeClass("valid").addClass("invalid");
            error_element.removeClass("error").addClass("error_show");
        }
    }
    else{
        input.removeClass("valid").addClass("invalid");
        error_element.removeClass("error").addClass("error_show");
    }
});

// HoraFim
$('#horaFim').on('input', function() {
	var input=$(this);
    var valid=input.val();
    var error_element=$("span", input.parent());
    if(valid){
        input.removeClass("invalid").addClass("valid");
        error_element.removeClass("error_show").addClass("error");

        var element=$("#dataFim");
        var error_element=$("span", element.parent());
        var partsHora = $('#horaInicio').val().split(':');
        var partsDate = element.val().split('-');
        var date = new Date(partsDate[0], partsDate[1] - 1, partsDate[2], partsHora[0], partsHora[1], 0, 0);
        if(date >= Date.now()){
            element.removeClass("invalid").addClass("valid");
            error_element.removeClass("error_show").addClass("error");
        }
        else{
            element.removeClass("valid").addClass("invalid");
            error_element.removeClass("error").addClass("error_show");
        }
    }
    else{
        input.removeClass("valid").addClass("invalid");
        error_element.removeClass("error").addClass("error_show");
    }
});