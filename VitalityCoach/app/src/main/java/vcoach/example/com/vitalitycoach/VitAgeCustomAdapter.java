package vcoach.example.com.vitalitycoach;

/**
 * Created by ASHWINI2 on 16/07/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;

import java.util.ArrayList;

import static vcoach.example.com.vitalitycoach.R.id.shareButton;

public class VitAgeCustomAdapter extends ArrayAdapter<User> {
    // share button
    //image
    private Bitmap image;
    //counter
    private int counter = 0;

    Context context;
    int layoutResourceId;
    ArrayList<User> data = new ArrayList<User>();
    View row;

    public VitAgeCustomAdapter(Context context, int layoutResourceId, ArrayList<User> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = convertView;
        UserHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new UserHolder();
            holder.iconImage = (ImageView) row.findViewById(R.id.imageIcon);
            holder.mainTitle = (TextView) row.findViewById(R.id.textView1);
            holder.headerTitle = (TextView) row.findViewById(R.id.textView2);
            holder.textLocation = (TextView) row.findViewById(R.id.textView3);
            holder.btnShare = (ShareButton) row.findViewById(shareButton);
            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }
        User user = data.get(position);
        holder.mainTitle.setText(user.getName());
        holder.headerTitle.setText(user.getAddress());
        holder.textLocation.setText(user.getLocation());

      ShareLinkContent content = new ShareLinkContent.Builder().
                setContentUrl(Uri.parse("https://developers.facebook.com")).
                build();
        holder.btnShare.setShareContent(content);



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
        ShareButton btnShare;
    }

}

