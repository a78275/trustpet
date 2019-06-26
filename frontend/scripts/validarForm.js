// Wait for the DOM to be ready
$(function() {
    $("form[name='registoDono']").validate({
        rules: {
            nome: "required",
            email: {
            required: true,
            email: true
            },
            password: {
            required: true,
            minlength: 5
            }
        },
        // Specify validation error messages
        messages: {
            nome: "Please enter your firstname",
            password: {
            required: "Please provide a password",
            minlength: "Your password must be at least 5 characters long"
            },
            email: "Please enter a valid email address"
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});

function myFunction(p1, p2) {
    return p1 * p2;   // The function returns the product of p1 and p2
}