package com.jakubolszewski.kalkulatorrecepturowy.Oils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
 * Use the {@link Oleje_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Oleje_Fragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Oleje_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Oleje_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Oleje_Fragment newInstance(String param1, String param2) {
        Oleje_Fragment fragment = new Oleje_Fragment();
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

    double amount, volume, grams, density;

    //-----------------------------text-variables---------------------------\\
    String Company, Unit;


    EditText amount_ET, density_ET;
    Button calc_btn;
    Spinner spinnerOil, spinnerUnit;
    TextView calculation1_TV, calculation2_TV;
    TextView textView_oilMain, textView_oilMain2;
    TextView title1_TV, title2_TV;
    LinearLayout linearLayout1, linearLayout2;

    AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oleje_, container, false);


        MobileAds.initialize(requireContext(),
                new OnInitializationCompleteListener() {
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

        textView_oilMain = view.findViewById(R.id.textView_mainOil);
        textView_oilMain2 = view.findViewById(R.id.textView_mainOil2);

        title1_TV = view.findViewById(R.id.textView_title1);
        title2_TV = view.findViewById(R.id.textView_title2);

        //-----------------------------Spinner---------------------------\\
        spinnerOil = view.findViewById(R.id.spinner_Company);
        spinnerUnit = view.findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerOil = view.findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(requireContext(), R.array.oleje, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOil.setAdapter(adapterCompany);
        spinnerOil.setOnItemSelectedListener(this);
        final Object Company = spinnerOil.getSelectedItem();

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = view.findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.olejeUnit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);
        spinnerUnit.setOnItemSelectedListener(this);
        final Object Unit = spinnerUnit.getSelectedItem();

        //-----------------------------TextEdit---------------------------\\
        amount_ET = view.findViewById(R.id.editText_amount);
        density_ET = view.findViewById(R.id.editText_density);
        //-----------------------------Linear-Layout---------------------------\\


        //-----------------------------Button---------------------------\\
        calc_btn = view.findViewById(R.id.button_calc);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String valueFromET = amount_ET.getText().toString();

                String valueFromDensityET = density_ET.getText().toString();


                if (!valueFromET.isEmpty()) {
                    amount = Double.parseDouble(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }


                //------------------------------OLEUM-RAPE----------------------------\\
                if (companyChoice == 1){
                    textView_oilMain.setText("Oleum rapae");


                    if (!valueFromDensityET.isEmpty()) {
                        density = Double.parseDouble(valueFromDensityET);
                    } else {
                        density = 0.917;
                    }

                    textView_oilMain2.setText("(" + density + " g/ml)");

                    //-------------------------------GRAM-----------------------------\\
                    if (unitChoice == 1){

                        grams = amount;

                        volume = grams / density;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2){

                        volume = amount;

                        grams = volume * density;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");
                }

                //-----------------------------OLEUM-RICINI---------------------------\\
                if (companyChoice == 2){

                    textView_oilMain.setText("Oleum Ricini");

                    density = 0.98;
                    if (!valueFromDensityET.isEmpty()) {
                        density = Double.parseDouble(valueFromDensityET);
                    } else {
                        density = 0.98;
                    }
                    textView_oilMain2.setText("(" + density + " g/ml)");

                    //-------------------------------GRAM-----------------------------\\
                    if (unitChoice == 1){

                        grams = amount;

                        volume = grams / density;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2){

                        volume = amount;

                        grams = volume * density;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");
                }
            }
        });
        
        return view;
    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String value1, value2;

        Spinner spinnerCompany = (Spinner) parent;
        Spinner spinnerUnit = (Spinner) parent;

        if (spinnerCompany.getId() == R.id.spinner_Company) {
            Company = parent.getItemAtPosition(position).toString();

            if (Company.contains("Rapae")) {
                companyChoice = 1;

                density_ET.setHint("0.917 g/ml");

            }

            if (Company.contains("Ricini")) {
                companyChoice = 2;

                density_ET.setHint("0.98 g/ml");
            }

        }
        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();

            if (Unit.contains("g")) {
                unitChoice = 1;
            }

            if (Unit.contains("ml")) {
                unitChoice = 2;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}