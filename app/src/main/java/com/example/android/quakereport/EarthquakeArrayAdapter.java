package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sood on 6/18/18.
 */

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeArrayAdapter(Activity context, ArrayList<Earthquake> earthquakeList) {

        //The resource id (an int) is set to 0 here. That's an invalid resource id, as we don't know the
        //required resource at the moment.
        super(context, 0, earthquakeList);
    }


    public int getMagnitudeColor(double magnitude) {
        int magInt = (int) Math.floor(magnitude);

        //to convert the color resource ID into a color integer value
        int color;
        switch (magInt) {
            case 0:
            case 1: color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                    break;
            case 2: color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                    break;
            case 3: color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                    break;
            case 4: color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                    break;
            case 5: color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                    break;
            case 6: color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                    break;
            case 7: color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                    break;
            case 8: color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                    break;
            case 9: color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                    break;

            default: color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                    break;
        }

        return color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {

            //The last parameter in 'inflate' is 'attachToRoot', set to false whenever we are not directly responsible
            //for attaching the inflated view to the root view (here, the RecyclerView (ListView) decides the same for the view).
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEartquake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.list_item_mag);
        TextView offset = (TextView) listItemView.findViewById(R.id.list_item_offset);
        TextView location = (TextView) listItemView.findViewById(R.id.list_item_loc);
        TextView date = (TextView) listItemView.findViewById(R.id.list_item_date);
        TextView time = (TextView) listItemView.findViewById(R.id.list_item_time);

        magnitude.setText(currentEartquake.getMagnitude());

        GradientDrawable magnitudeCircleBackground = (GradientDrawable) magnitude.getBackground();
        double mag = Double.parseDouble(currentEartquake.getMagnitude());
        magnitudeCircleBackground.setColor(getMagnitudeColor(mag));

        offset.setText(currentEartquake.getOffset());
        location.setText(currentEartquake.getLocation());
        date.setText(currentEartquake.getDate());
        time.setText(currentEartquake.getTime());

        return listItemView;
    }
}
