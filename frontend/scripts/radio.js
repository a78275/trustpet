jQuery(function ($) {
    // init the state from the input
    $(".radio-dono").each(function () {
        if ($(this).find('input[type="radio"]').first().attr("checked")) {
            $(this).addClass('radio-dono-checked');
        }
        else {
            $(this).removeClass('radio-dono-checked');
        }
    });

    // sync the state to the input
    $(".radio-dono").on("click", function (e) {
        if ($(this).hasClass('radio-dono-checked')) {
            $(this).removeClass('radio-dono-checked');
            $(this).find('input[type="checkbox"]').first().removeAttr("checked");
        }
        else {
            $(this).addClass('radio-dono-checked');
            $(this).find('input[type="radio"]').first().attr("checked", "checked");
        }

        e.preventDefault();
    });
});