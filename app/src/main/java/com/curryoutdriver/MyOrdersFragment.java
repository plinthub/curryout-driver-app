package com.curryoutdriver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyOrdersFragment extends android.support.v4.app.Fragment {

    LinearLayout ln;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_myorder, container, false);

        init(v);
        listener(v);

        return v;
    }

    private void init(View v) {

        ln=(LinearLayout)v.findViewById(R.id.ln);
    }

    private void listener(View v) {

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(getActivity(), OrderAcceptActivity.class);
                startActivity(i);
            }
        });

    }
}
