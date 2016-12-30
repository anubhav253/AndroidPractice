package com.example.devil.unitconverter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devil.unitconverter.R;

import org.w3c.dom.Text;

/**
 * Created by DEVIL on 12/29/2016.
 */

public class SpeedFragment extends BaseFragment implements View.OnClickListener {
    View view;
    TextView output;
    EditText input;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_speed, container, false);

        Button b = (Button) view.findViewById(R.id.btn_speed);
        b.setOnClickListener(this);

        output = (TextView) view.findViewById(R.id.txt_out_speed);

        input = (EditText) view.findViewById(R.id.txt_inp_speed);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_speed:
                int km= Integer.parseInt( input.getText().toString() );
                Double mile= km * 1.6;
                output.setText(mile.toString());
                break;
        }
    }
}
