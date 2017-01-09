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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEVIL on 12/29/2016.
 */

public class SpeedFragment extends BaseFragment implements View.OnClickListener {
    View view;
    TextView output;
    EditText input;
    Spinner spinner;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_speed, container, false);

        Button b = (Button) view.findViewById(R.id.btn_speed);
        b.setOnClickListener(this);

        output = (TextView) view.findViewById(R.id.txt_out_speed);

        input = (EditText) view.findViewById(R.id.txt_inp_speed);
        spinner = (Spinner) view.findViewById(R.id.spin_speed);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        initSpinner(view);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_speed:

                final Toast toast = Toast.makeText(getActivity(), "Spinner " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG);
                if (spinner.getSelectedItem().toString()=="Miles per hour"){
                    double km= Integer.parseInt( input.getText().toString() );
                    Double mile = Double.valueOf(km * 0.621371);
                    output.setText(mile.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Foot per sec"){
                    double km= Integer.parseInt( input.getText().toString() );
                    Double foot = Double.valueOf(km * 0.911344);
                    output.setText(foot.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Metre per sec"){
                    double km= Integer.parseInt( input.getText().toString() );
                    Double m = Double.valueOf(km * 0.277778);
                    output.setText(m.toString());
                }
                else if (spinner.getSelectedItem().toString()=="Knot"){
                    double km= Integer.parseInt( input.getText().toString() );
                    Double knot = Double.valueOf(km *1.852);
                    output.setText(knot.toString());
                }
                toast.show();

                break;
        }
    }



    public void initSpinner(View view){
        List<String> categories = new ArrayList<String>();
        categories.add("Miles per hour");
        categories.add("Foot per sec");
        categories.add("Metre per sec");
        categories.add("Knot");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //dataAdapter.setDropDownViewTheme(Resources.Theme.class);

        spinner.setAdapter(dataAdapter);

    }
}
