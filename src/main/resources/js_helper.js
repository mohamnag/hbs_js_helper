
Handlebars.registerHelper('jshelper', function (context) {
    return context.split(".").join("/");
});