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

public class WeightFragment extends BaseFragment implements View.OnClickListener{
    View view;
    TextView output;
    EditText input;
    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_weight, container, false);
        Button b = (Button) view.findViewById(R.id.btn_weight);
        b.setOnClickListener(this);

        output = (TextView) view.findViewById(R.id.txt_out_weight);

        input = (EditText) view.findViewById(R.id.txt_inp_weight);
        spinner = (Spinner) view.findViewById(R.id.spin_weight);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        initSpinner(view);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_weight:
                final Toast toast = Toast.makeText(getActivity(), "Spinner " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG);
                if (spinner.getSelectedItem().toString()=="Tonne"){
                    double kg= Integer.parseInt( input.getText().toString() );
                    Double T = Double.valueOf(kg * 0.001);
                    output.setText(T.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Gram"){
                    double kg= Integer.parseInt( input.getText().toString() );
                    Double gram = Double.valueOf(kg * 1000);
                    output.setText(gram.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Stone"){
                    double kg= Integer.parseInt( input.getText().toString() );
                    Double stone = Double.valueOf(kg * 0.157473);
                    output.setText(stone.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Pound"){
                    double kg= Integer.parseInt( input.getText().toString() );
                    Double pound = Double.valueOf(kg * 2.20462);
                    output.setText(pound.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Ounce"){
                    double kg= Integer.parseInt( input.getText().toString() );
                    Double ou = Double.valueOf(kg * 0.01);
                    output.setText(ou.toString());
                }
                toast.show();
                break;
        }
    }

    public void initSpinner(View view){
        List<String> categories = new ArrayList<String>();
        categories.add("Tonne");
        categories.add("Gram");
        categories.add("Stone");
        categories.add("Pound");
        categories.add("Ounce");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //dataAdapter.setDropDownViewTheme(Resources.Theme.class);

        spinner.setAdapter(dataAdapter);

    }
}
