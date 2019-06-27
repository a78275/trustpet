$(function () {

    // add multiple select / deselect functionality
    $("#selectall1").click(function () {
        $('#hora1').attr('checked', this.checked);
    });

    // if all checkbox are selected, check the selectall checkbox
    // and viceversa
    $("#hora1").click(function () {

        if ($("#hora1").length == $("#hora1:checked").length) {
            $("#selectall1").attr("checked", "checked");
        } else {
            $("#selectall1").removeAttr("checked");
        }

    });
});