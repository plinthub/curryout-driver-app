package com.curryoutdriver;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout home_tap,myorders_tap, profile_tap;
    ImageView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        init();
        listener();
    }

    private void init() {

        home_tap=(LinearLayout)findViewById(R.id.home_tap);
        myorders_tap=(LinearLayout)findViewById(R.id.myorders_tap);
        profile_tap=(LinearLayout)findViewById(R.id.profile_tap);
        logout=(ImageView)findViewById(R.id.logout);
    }

    private void listener() {

        myorders_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProfileActivity.this, MyOrdersActivity.class));
                finish();
            }
        });

        home_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(ProfileActivity.this, R.style.FullScreenDialogStyleTransparent);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.logout_dialog_layout);
                dialog.show();

                ImageView cancel=(ImageView)dialog.findViewById(R.id.img_cancel);
                LinearLayout ln_yes=(LinearLayout)dialog.findViewById(R.id.ln_yes);
                LinearLayout ln_outer = (LinearLayout)dialog.findViewById(R.id.ln_outside);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                ln_outer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                ln_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finishAffinity();
                    }
                });


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
        finish();
    }
}
