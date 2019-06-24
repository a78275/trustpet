$(function () {
    $('#dataInicio').datetimepicker({
        locale: 'pt',
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            up: "fa fa-arrow-up",
            down: "fa fa-arrow-down"
        },
        inline: true,
        sideBySide: true
    });
    $('#dataFim').datetimepicker({
        locale: 'pt',
        useCurrent: false,
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            up: "fa fa-arrow-up",
            down: "fa fa-arrow-down"
        },
        inline: true,
        sideBySide: true
    });
    $("#dataInicio").on("change.datetimepicker", function (e) {
        $('#dataFim').datetimepicker('minDate', e.date);
    });
    $("#dataFim").on("change.datetimepicker", function (e) {
        $('#dataInicio').datetimepicker('maxDate', e.date);
    });
});