package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ASHWINI2 on 11/08/2017.
 */


public class SharingActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private LoginManager loginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sharing_activity);

            FacebookSdk.sdkInitialize(getApplicationContext());

            callbackManager = CallbackManager.Factory.create();

            List<String> permissionNeeds = Arrays.asList("publish_actions");

            //this loginManager helps you eliminate adding a LoginButton to your UI
            loginManager = LoginManager.getInstance();

            loginManager.logInWithPublishPermissions(this, permissionNeeds);

            loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
            {
                @Override
                public void onSuccess(LoginResult loginResult)
                {
                    sharePhotoToFacebook();
                }

                @Override
                public void onCancel()
                {
                    System.out.println("onCancel");
                }

                @Override
                public void onError(FacebookException exception)
                {
                    System.out.println("onError"+exception.getLocalizedMessage());
                }
            });
        }}

    private void sharePhotoToFacebook(){
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.healthy_food_badge);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .setCaption("Congratulations on activating your Vitality Healthy Food benefit and earning your Vitality Healthy Food Badge!")
                .build();

        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();

        ShareApi.share(content, null);

    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data)
    {
        super.onActivityResult(requestCode, responseCode, data);
        callbackManager.onActivityResult(requestCode, responseCode, data);
        Intent intent = new Intent(this, VitAgeActivityShare.class);
        startActivity(intent);
    }

}
