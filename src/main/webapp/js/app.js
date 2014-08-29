//TODO:
//-change variable names, not from example
//-take out commented out code
//-perhaps style better
//-take out extra testing locations
//-perhaps color padding is better
//http://api.openweathermap.org/data/2.5/weather?q=Cancun,mx

(function($){

    console.log("starting app");

    var myWeatherModel = new WeatherModel({
        location: 'Baltimore,md'
    });

    var myWeatherView = new WeatherView({
        el: '#weatherObservationModule',
        model: myWeatherModel,
        tmpl: '#weatherObservationModuleTemplate'
    });

    //$( "#city-chosen" ).change(function() {
    $( "#choose-city" ).click(function() {
        var citySelected = $('#city-chosen :selected').text();
        console.log("selected "+citySelected);

        myWeatherModel = new WeatherModel({
            location: citySelected
        });

        myWeatherView = new WeatherView({
            el: '#weatherObservationModule',
            model: myWeatherModel,
            tmpl: '#weatherObservationModuleTemplate'
        });
    });

})(jQuery);
