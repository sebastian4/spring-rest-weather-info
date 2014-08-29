var WeatherModel = Backbone.Model.extend({

    initialize: function(){
        //console.log("initialize");
    },
    defaults: {
        'location': 'Fairfax,va'
    },
    tempcolor: function(faren){
        var tcolor = "#000000";
        if (faren<30.0) tcolor="#0066FF";
        else if (faren<40.0) tcolor="#0099FF";
        else if (faren<50.0) tcolor="#00CCFF";
        else if (faren<60.0) tcolor="#FFFF66";
        else if (faren<70.0) tcolor="#FFCC33";
        else if (faren<80.0) tcolor="#FF9933";
        else if (faren<90.0) tcolor="#FF6633";
        else if (faren<100.0) tcolor="#FF0033";
        return tcolor;
    },
    parse: function(data,xhr){
        data.tempcolor = this.tempcolor(data.temperature);
        data.temperature = data.temperature.toFixed(2);
        data.min = data.min.toFixed(2);
        data.max = data.max.toFixed(2);
        return data;
    },
    url: function(){
        return 'rest/city/'+this.get('location');
    }

});
