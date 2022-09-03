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
 * Use the {@link Olejki_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Olejki_Fragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Olejki_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Olejki_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Olejki_Fragment newInstance(String param1, String param2) {
        Olejki_Fragment fragment = new Olejki_Fragment();
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
    double volume, grams, drops;

    //-----------------------------text-variables---------------------------\\
    String Company, Unit;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerOil, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV;
    TextView textView_oilMain, textView_oilMain2;
    TextView title1_TV, title2_TV, title3_TV;

    AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_olejki_, container, false);

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

        textView_oilMain = view.findViewById(R.id.textView_mainOil);
        textView_oilMain2 = view.findViewById(R.id.textView_mainOil2);

        title1_TV = view.findViewById(R.id.textView_title1);
        title2_TV = view.findViewById(R.id.textView_title2);
        title3_TV = view.findViewById(R.id.textView_title3);

        //-----------------------------Spinner---------------------------\\
        spinnerOil = view.findViewById(R.id.spinner_Company);
        spinnerUnit = view.findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerOil = view.findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(requireContext(), R.array.olejki, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOil.setAdapter(adapterCompany);
        spinnerOil.setOnItemSelectedListener(this);
        final Object Company = spinnerOil.getSelectedItem();

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = view.findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.olejkiUnit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);
        spinnerUnit.setOnItemSelectedListener(this);
        final Object Unit = spinnerUnit.getSelectedItem();

        //-----------------------------TextEdit---------------------------\\
        amount_ET = view.findViewById(R.id.editText_amount);

        //-----------------------------Linear-Layout---------------------------\\

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


                /*
                 *
                 * Olejek miętowy
                 * - masa kropli: 0.019g
                 * - gęstość: 0.9026 g/ml
                 *
                 * Olejek lawendowy
                 * -masa kropli: 0.019g
                 * -gęstość: 0.8855 g/ml;
                 *
                 * Olejek eukaliptusowy
                 * - masa kropli:
                 * -gęstość:
                 *
                 */


                //-----------------------------OLEJEK-MIĘTOWY---------------------------\\
                if (companyChoice == 1) {

                    textView_oilMain.setText("Olejek miętowy");
                    textView_oilMain2.setText("(0.9026 g/ml)");

                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        grams = amount;
                        volume = grams / 0.9026;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2) {

                        volume = amount;
                        grams = volume * 0.9026;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------KROPLE---------------------------\\
                    if (unitChoice == 3) {

                        drops = amount;
                        grams = drops * 0.019;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        volume = grams / 0.9026;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");

                    String drops_String = String.valueOf(drops).replace(".0", "");

                    calculation3_TV.setText(drops_String + " kropli");

                }

                //-----------------------------OLEJEK-LAWENDOWY---------------------------\\
                if (companyChoice == 2) {
                    textView_oilMain.setText("Olejek lawendowy");
                    textView_oilMain2.setText("(0.8855 g/ml)");
                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        grams = amount;
                        volume = grams / 0.8855;
                        drops = grams / 0.019;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops = Math.round(drops);

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2) {

                        volume = amount;
                        grams = volume * 0.8855;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------KROPLE---------------------------\\
                    if (unitChoice == 3) {

                        drops = amount;
                        grams = drops * 0.019;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        volume = grams / 0.8855;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");

                    String drops_String = String.valueOf(drops).replace(".0", "");

                    calculation3_TV.setText(drops_String + " kropli");
                }

                //-----------------------------OLEJEK-EUKALIPTUSOWY---------------------------\\
                if (companyChoice == 3) {
                    textView_oilMain.setText("Olejek eukaliptusowy");
                    textView_oilMain2.setText("(0.885 g/ml)");
                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        grams = amount;
                        volume = grams / 0.885;
                        drops = grams / 0.019;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops = Math.round(drops);

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2) {

                        volume = amount;
                        grams = volume * 0.885;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------KROPLE---------------------------\\
                    if (unitChoice == 3) {

                        drops = amount;
                        grams = drops * 0.019;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        volume = grams / 0.885;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");

                    String drops_String = String.valueOf(drops).replace(".0", "");

                    calculation3_TV.setText(drops_String + " kropli");
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

            if (Company.contains("miętowy")) {
                companyChoice = 1;
            }
            if (Company.contains("lawendowy")) {
                companyChoice = 2;
            }
            if (Company.contains("eukaliptusowy")) {
                companyChoice = 3;
            }

        }
        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();

            if (Unit.contains("(g)")) {
                unitChoice = 1;
            }
            if (Unit.contains("(ml)")) {
                unitChoice = 2;
            }
            if (Unit.toLowerCase().contains("krople")) {
                unitChoice = 3;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}