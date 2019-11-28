package com.curryoutdriver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileFragment extends android.support.v4.app.Fragment {


    ImageView logout, imgNumberClean, imgAddressClean;
    EditText et_phNumber, et_address;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        init(v);
        listener(v);

        return v;
    }

    private void init(View v) {

        logout=(ImageView)v.findViewById(R.id.logout);
        imgNumberClean=(ImageView)v.findViewById(R.id.imgNumberClean);
        imgAddressClean=(ImageView)v.findViewById(R.id.imgAddressClean);
        et_phNumber=(EditText)v.findViewById(R.id.et_phNumber);
        et_address=(EditText)v.findViewById(R.id.et_address);
    }

    private void listener(View v) {

        et_phNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if(charSequence.length() > 0){
                    imgNumberClean.setVisibility(View.VISIBLE);
                }else{
                    imgNumberClean.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imgNumberClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_phNumber.setText("");
            }
        });

        et_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if(charSequence.length() > 0){
                    imgAddressClean.setVisibility(View.VISIBLE);
                }else{
                    imgAddressClean.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imgAddressClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_address.setText("");
            }
        });

    }
}
