//TODO:
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
        el: '#weather-widget',
        model: myWeatherModel,
        tmpl: '#weather-module-template'
    });

    //$( "#city-chosen" ).change(function() {
    $( "#choose-city" ).click(function() {
        var citySelected = $('#city-chosen :selected').text();
        console.log("selected "+citySelected);

        myWeatherModel = new WeatherModel({
            location: citySelected
        });

        myWeatherView = new WeatherView({
            el: '#weather-widget',
            model: myWeatherModel,
            tmpl: '#weather-module-template'
        });
    });

})(jQuery);
