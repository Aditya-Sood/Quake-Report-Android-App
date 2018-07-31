package com.example.android.quakereport;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sood on 6/18/18.
 */

public class Earthquake {
    private double magnitude;
    private String offset;
    private String location;
    private Date date;
    private String url;
    private Calendar calendar = Calendar.getInstance();
    private DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

    public Earthquake(double inputMag, String inputLoc, long inputMillis, String inputUrl) {
        magnitude = inputMag;

        if(inputLoc.contains(" of ")) {
            int index = inputLoc.indexOf(" of ");
            offset = inputLoc.substring(0, index+3);
            location = inputLoc.substring(index+4);
        }
        else {
            offset = "Near the";
            location = inputLoc;
        }

        date = new Date(inputMillis);

        url = inputUrl;
    }

    public String getMagnitude() {
        DecimalFormat def = new DecimalFormat("0.0");
        return  def.format(magnitude);
    }

    public String getOffset() { return  offset;}

    public String getLocation() { return location; }

    public String getDate() { return df.format(date); }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        return sdf.format(date);
    }

    public String getUrl() { return url; }
}
