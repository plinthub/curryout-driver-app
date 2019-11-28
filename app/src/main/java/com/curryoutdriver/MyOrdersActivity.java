package com.curryoutdriver;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyOrdersActivity extends AppCompatActivity {


    LinearLayout home_tap,myorders_tap, profile_tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        init();
        listener();

                NewOrderDataModel newOrderDataModel[] = new NewOrderDataModel[] {

                        new NewOrderDataModel("12", "Palasia to Geeta Bhawan", "Pending", "INR 150"),
                        new NewOrderDataModel("16", "Vijay Nagar to Geeta Bhawan", "Pending", "INR 100"),
                        new NewOrderDataModel("20", "Khajrana to Palasia", "Pending", "INR 80"),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyOrderListAdapter recyAdapter = new MyOrderListAdapter(newOrderDataModel);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyOrdersActivity.this));
        recyclerView.setAdapter(recyAdapter);
    }

    private void init() {

        home_tap=(LinearLayout)findViewById(R.id.home_tap);
        myorders_tap=(LinearLayout)findViewById(R.id.myorders_tap);
        profile_tap=(LinearLayout)findViewById(R.id.profile_tap);

    }

    private void listener() {


        home_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MyOrdersActivity.this, HomeActivity.class));
                finish();
            }
        });

        profile_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MyOrdersActivity.this, ProfileActivity.class));
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(MyOrdersActivity.this, HomeActivity.class));
        finish();

    }

    private class MyOrderListAdapter extends RecyclerView.Adapter<ViewHolder> {

        private NewOrderDataModel[] listData;

        public MyOrderListAdapter(NewOrderDataModel[] listData) {
            this.listData = listData;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.neworders_item_list, parent, false);
            ViewHolder viewHolder= new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final NewOrderDataModel newOrderDataModel= listData[position];
            holder.tNumber.setText(listData[position].getTxtNumber());
            holder.tLocation.setText(listData[position].getTxtLocation());
            holder.tOrderStatus.setText(listData[position].getTxtOderStatus());
            holder.tDelivery.setText(listData[position].getTxtDelivery());

        }

        @Override
        public int getItemCount() {
            return listData.length;
        }
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tNumber, tLocation, tOrderStatus, tDelivery;

        LinearLayout lnOrderItem;


        public ViewHolder(View itemView) {
            super(itemView);

            this.tNumber=(TextView)itemView.findViewById(R.id.txtNumber);
            this.tLocation=(TextView)itemView.findViewById(R.id.txtLocation);
            this.tOrderStatus=(TextView)itemView.findViewById(R.id.txtOrderStatus);
            this.tDelivery=(TextView)itemView.findViewById(R.id.txtDelivery);

            lnOrderItem=(LinearLayout)itemView.findViewById(R.id.lnOrderItem);
            lnOrderItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(MyOrdersActivity.this, OrderAcceptActivity.class));
                }
            });
        }
    }

    private class NewOrderDataModel {

        private String txtNumber;
        private String txtLocation;
        private String txtOderStatus;
        private String txtDelivery;

        public NewOrderDataModel(String txtNumber, String txtLocation, String txtOderStatus, String txtDelivery) {
            this.txtNumber = txtNumber;
            this.txtLocation = txtLocation;
            this.txtOderStatus = txtOderStatus;
            this.txtDelivery = txtDelivery;
        }

        public String getTxtNumber() {
            return txtNumber;
        }

        public void setTxtNumber(String txtNumber) {
            this.txtNumber = txtNumber;
        }

        public String getTxtLocation() {
            return txtLocation;
        }

        public void setTxtLocation(String txtLocation) {
            this.txtLocation = txtLocation;
        }

        public String getTxtOderStatus() {
            return txtOderStatus;
        }

        public void setTxtOderStatus(String txtOderStatus) {
            this.txtOderStatus = txtOderStatus;
        }

        public String getTxtDelivery() {
            return txtDelivery;
        }

        public void setTxtDelivery(String txtDelivery) {
            this.txtDelivery = txtDelivery;
        }
    }
}
