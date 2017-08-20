package vcoach.example.com.vitalitycoach;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static vcoach.example.com.vitalitycoach.R.id.aractivate;

/**
 * Created by ASHWINI2 on 17/07/2017.
 */

public class ActiveRewardsCustomAdapter  extends ArrayAdapter<User> {
    // share button
    //image
    private Bitmap image;
    //counter
    private int counter = 0;

    Context context;
    int layoutResourceId;
    ArrayList<User> data = new ArrayList<User>();
    View row;

    public ActiveRewardsCustomAdapter(Context context, int layoutResourceId, ArrayList<User> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = convertView;
        ActiveRewardsCustomAdapter.UserHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ActiveRewardsCustomAdapter.UserHolder();
            holder.iconImage = (ImageView) row.findViewById(R.id.imageIcon);
            holder.mainTitle = (TextView) row.findViewById(R.id.artextView1);
            holder.headerTitle = (TextView) row.findViewById(R.id.artextView2);
            holder.textLocation = (TextView) row.findViewById(R.id.artextView3);
            holder.btnShare = (Button) row.findViewById(aractivate);
            row.setTag(holder);
        } else {
            holder = (ActiveRewardsCustomAdapter.UserHolder) row.getTag();
        }
        User user = data.get(position);
        holder.mainTitle.setText(user.getName());
        holder.headerTitle.setText(user.getAddress());
        holder.textLocation.setText(user.getLocation());



        holder.btnShare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getContext(), VitalityAgeActivity.class);
                getContext().startActivity(newActivity);
            }
        });

        holder.mainTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getContext(), VitalityAgeActivity.class);
                getContext().startActivity(newActivity);
            }
        });
        return row;

    }


    static class UserHolder {
        ImageView iconImage;
        TextView mainTitle;
        TextView headerTitle;
        TextView textLocation;
        Button btnShare;
    }

}

