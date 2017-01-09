package com.example.devil.unitconverter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devil.unitconverter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEVIL on 12/29/2016.
 */

public class TemperatureFragment extends BaseFragment implements View.OnClickListener{

    View view;
    TextView output;
    EditText input;
    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_temperature, container, false);
        Button b = (Button) view.findViewById(R.id.btn_temperature);
        b.setOnClickListener(this);

        output = (TextView) view.findViewById(R.id.txt_out_temperature);

        input = (EditText) view.findViewById(R.id.txt_inp_temperature);

        spinner = (Spinner) view.findViewById(R.id.spin_temperature);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        initSpinner(view);
        return view;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_temperature:
                final Toast toast = Toast.makeText(getActivity(), "Spinner " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG);
                if (spinner.getSelectedItem().toString()=="Celcius"){
                    double K= Integer.parseInt( input.getText().toString() );
                    Double C = Double.valueOf(K + 273.15);
                    output.setText(C.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Farenheit"){
                    double K= Integer.parseInt( input.getText().toString() );
                    Double F = Double.valueOf(K + 255.372);
                    output.setText(F.toString());
                }
                toast.show();
                break;
        }
    }

    public void initSpinner(View view){
        List<String> categories = new ArrayList<String>();
        categories.add("Celcius");
        categories.add("Farenheit");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //dataAdapter.setDropDownViewTheme(Resources.Theme.class);

        spinner.setAdapter(dataAdapter);

    }
}
