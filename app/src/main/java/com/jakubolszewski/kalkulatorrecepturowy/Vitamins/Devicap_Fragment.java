package com.jakubolszewski.kalkulatorrecepturowy.Vitamins;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jakubolszewski.kalkulatorrecepturowy.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Devicap_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Devicap_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Devicap_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Devicap_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Devicap_Fragment newInstance(String param1, String param2) {
        Devicap_Fragment fragment = new Devicap_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //-----------------------------numeric-variables---------------------------\\
    int companyChoice, unitChoice;

    double amount;
    double volume, grams, drops, massUnit;
    double hmts1;

    //-----------------------------text-variables---------------------------\\
    String Unit;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerOil, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV, calculation4_TV;
    TextView textView_vitMain, textView_vitMain2;
    TextView title1_TV, title2_TV, title3_TV;
    TextView hmts1_TV;

    AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //TODO Copy
        View view = inflater.inflate(R.layout.fragment_devicap_, container, false);

        MobileAds.initialize(requireContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //-----------------------------textview---------------------------\\
        calculation1_TV = view.findViewById(R.id.textView_calculation1);
        calculation2_TV = view.findViewById(R.id.textView_calculation2);
        calculation3_TV = view.findViewById(R.id.textView_calculation3);
        calculation4_TV = view.findViewById(R.id.textView_calculation4);

        textView_vitMain = view.findViewById(R.id.textView_mainVit);
        textView_vitMain2 = view.findViewById(R.id.textView_mainVit2);

        title1_TV = view.findViewById(R.id.textView_title1);
        title2_TV = view.findViewById(R.id.textView_title2);
        title3_TV = view.findViewById(R.id.textView_title3);

        hmts1_TV = view.findViewById(R.id.textView_howMuchToSell_1);


        //-----------------------------Spinner---------------------------\\
        spinnerOil = view.findViewById(R.id.spinner_Company);
        spinnerUnit = view.findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = view.findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.devicapUnit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);
        spinnerUnit.setOnItemSelectedListener(this);
        final Object Unit = spinnerUnit.getSelectedItem();
        //-----------------------------TextEdit---------------------------\\
        amount_ET = view.findViewById(R.id.editText_amount);

        //-----------------------------Button---------------------------\\
        calc_btn = view.findViewById(R.id.button_calc);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String valueFromET = amount_ET.getText().toString();


                if (!valueFromET.isEmpty()) {
                    amount = Double.parseDouble(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }

                textView_vitMain.setText("Devicap");
                textView_vitMain2.setText("(1.1 g/ml)");
                //-----------------------------GRAM---------------------------\\
                if (unitChoice == 1) {

                    grams = amount;

                    volume = grams / 1.1;

                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    drops = volume * 30;

                    drops = Math.round(drops);

                    massUnit = volume * 15000;

                    massUnit = Math.round(massUnit);

                }

                //-----------------------------MILILITR---------------------------\\
                if (unitChoice == 2) {

                    volume = amount;

                    grams = volume * 1.1;

                    grams *= 100;
                    grams = Math.round(grams);
                    grams /= 100;

                    drops = volume * 30;

                    drops = Math.round(drops);

                    massUnit = volume * 15000;

                    massUnit = Math.round(massUnit);

                }

                //-----------------------------KROPLE---------------------------\\
                if (unitChoice == 3) {

                    drops = amount;

                    volume = drops / 30;

                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    grams = volume * 1.1;

                    grams *= 100;
                    grams = Math.round(grams);
                    grams /= 100;

                    massUnit = volume * 15000;

                    massUnit = Math.round(massUnit);

                }

                //-----------------------------J.M.---------------------------\\
                if (unitChoice == 4) {

                    massUnit = amount;

                    volume = massUnit / 15000;

                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    grams = volume * 1.1;

                    grams *= 100;
                    grams = Math.round(grams);
                    grams /= 100;

                    drops = volume * 30;

                    drops = Math.round(drops);


                }


                calculation1_TV.setText(grams + " g");
                calculation2_TV.setText(volume + " ml");

                String drops_String = String.valueOf(drops).replace(".0", "");

                calculation3_TV.setText(drops_String + " kropli");

                String massUnit_String = String.valueOf(massUnit).replace(".0", "");

                calculation4_TV.setText(massUnit_String + " j.m.");

                hmts1 = volume / 10;
                hmts1 *= 1000;
                hmts1 = Math.round(hmts1);
                hmts1 /= 1000;
                hmts1_TV.setText(hmts1 + " \nopakowania Devicap'u");

            }
        });

        return view;
    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinnerUnit = (Spinner) parent;

        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();

            if (Unit.contains("g")) {
                unitChoice = 1;
            }
            if (Unit.contains("ml")) {
                unitChoice = 2;
            }
            if (Unit.contains("Krople")) {
                unitChoice = 3;
            }
            if (Unit.contains("j.m.")) {
                unitChoice = 4;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}