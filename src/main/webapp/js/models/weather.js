var WeatherModel = Backbone.Model.extend({

    initialize: function(){
        //console.log("initialize");
    },
    defaults: {
        'location': 'Fairfax,va'
    },
    fahrenheit: function(temp){
        var faren = ((9/5)*(temp - 273)) + 32;
        return faren.toFixed(2);
    },
    tempcolor: function(temp){
        var faren = this.fahrenheit(temp);
        var tcolor = "#000000"
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
    getdate: function(adate){
        var date = new Date(adate*1000);
        return date;
    },
    parse: function(data,xhr){
        data.fahrenheit = this.fahrenheit(data.main.temp);
        data.tempcolor = this.tempcolor(data.main.temp);
        data.date = this.getdate(data.dt);
        data.tempmin = this.fahrenheit(data.main.temp_min);
        data.tempmax = this.fahrenheit(data.main.temp_max);
        return data;
    },
    url: function(){
        //return 'http://wxdata.weather.com/wxdata/agg/' + this.get('locid') + '.js?cb=?&key=e88ca396-a740-102c-bafd-001321203584';
        //return 'http://localhost:9000/data/2.5/weather?q=London,uk&callback=jQuery171013284962065517902_1409190313247';
        return 'http://localhost:9000/data/2.5/weather?q='+this.get('location');
    }

});
