package com.example.devil.unitconverter.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class LengthFragment extends BaseFragment implements View.OnClickListener{
    View view;
    TextView output;
    EditText input;
    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_length, container, false);
        Button b = (Button) view.findViewById(R.id.btn_length);
        b.setOnClickListener(this);

        output = (TextView) view.findViewById(R.id.txt_out_length);

        input = (EditText) view.findViewById(R.id.txt_inp_length);

        spinner = (Spinner) view.findViewById(R.id.spin_length);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        initSpinner(view);

        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_length:



                final Toast toast = Toast.makeText(getActivity(), "Spinner " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG);
                if (spinner.getSelectedItem().toString()=="Kilometre"){
                    double km= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(km * 1000);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Mile"){
                    double mile= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(mile * 1609.34);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Yard"){
                    double Yard= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(Yard * 0.9144);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Foot"){
                    double foot= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(foot * 0.3048);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Inch"){
                    double inch= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(inch * 0.0254);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Centimetre"){
                    double cm= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(cm * 0.01);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Milimetre"){
                    double mm= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(mm * 0.001);
                    output.setText(m.toString());
                }
                toast.show();
                break;
        }
    }

    public void initSpinner(View view){
        List<String> categories = new ArrayList<String>();
        categories.add("Kilometre");
        categories.add("Mile");
        categories.add("Yard");
        categories.add("Foot");
        categories.add("Inch");
        categories.add("Centimetre");
        categories.add("Milimetre");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //dataAdapter.setDropDownViewTheme(Resources.Theme.class);

        spinner.setAdapter(dataAdapter);

    }
}

