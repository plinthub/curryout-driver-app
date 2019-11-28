package com.curryoutdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    LinearLayout home_tap,myorders_tap, profile_tap, ln1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        listener();
    }

    private void init() {

        home_tap=(LinearLayout)findViewById(R.id.home_tap);
        myorders_tap=(LinearLayout)findViewById(R.id.myorders_tap);
        profile_tap=(LinearLayout)findViewById(R.id.profile_tap);
        ln1=(LinearLayout)findViewById(R.id.ln1);

    }

    private void listener() {


        myorders_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this, MyOrdersActivity.class));
            }
        });


        profile_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                finish();
            }
        });


        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this, MyOrdersActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
