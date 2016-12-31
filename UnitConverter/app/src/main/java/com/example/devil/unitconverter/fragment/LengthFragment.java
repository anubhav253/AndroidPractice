package com.example.devil.unitconverter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.devil.unitconverter.R;

/**
 * Created by DEVIL on 12/29/2016.
 */

public class LengthFragment extends BaseFragment implements View.OnClickListener{
    View view;
    TextView output;
    EditText input;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_length, container, false);
        Button b = (Button) view.findViewById(R.id.btn_length);
        b.setOnClickListener(this);

        output = (TextView) view.findViewById(R.id.txt_out_length);

        input = (EditText) view.findViewById(R.id.txt_inp_length);
        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_length:
                double km= Integer.parseInt( input.getText().toString() );
                Double m = Double.valueOf(km * 1000);
                output.setText(m.toString());
                break;
        }
    }
}

