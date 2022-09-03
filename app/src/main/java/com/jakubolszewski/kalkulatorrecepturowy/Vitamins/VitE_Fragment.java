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
 * Use the {@link VitE_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VitE_Fragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VitE_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VitE_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VitE_Fragment newInstance(String param1, String param2) {
        VitE_Fragment fragment = new VitE_Fragment();
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
    double volumeHasco, dropsHasco, gramsHasco;
    double volumeMedana, dropsMedana, gramsMedana;
    double volumeFagron, dropsFagron, gramsFagron;
    double hmts1, hmts2, hmts3;

    //-----------------------------text-variables---------------------------\\
    String Company;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerCompany;
    TextView calculation1_TV, calculation2_TV, calculation3_TV;
    TextView calculation4_TV, calculation5_TV, calculation6_TV;
    TextView calculation7_TV, calculation8_TV, calculation9_TV;
    TextView textView_text1, textView_text2, textView_text3, textView_text4, textView_text5, textView_text6;
    TextView textView_vitMain, textView_vitMain2;
    TextView title1_TV, title2_TV, title3_TV;
    TextView title4_TV, title5_TV, title6_TV;
    TextView title7_TV, title8_TV, title9_TV;
    TextView hmts1_TV, hmts2_TV, hmts3_TV;

    AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vit_e_, container, false);

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
        calculation5_TV = view.findViewById(R.id.textView_calculation5);
        calculation6_TV = view.findViewById(R.id.textView_calculation6);
        calculation7_TV = view.findViewById(R.id.textView_calculation7);
        calculation8_TV = view.findViewById(R.id.textView_calculation8);
        calculation9_TV = view.findViewById(R.id.textView_calculation9);


        textView_text3 = view.findViewById(R.id.textView_text3);
        textView_text4 = view.findViewById(R.id.textView_text4);
        textView_text5 = view.findViewById(R.id.textView_text5);
        textView_text6 = view.findViewById(R.id.textView_text6);

        textView_vitMain = view.findViewById(R.id.textView_mainVit);
        textView_vitMain2 = view.findViewById(R.id.textView_mainVit2);

        title1_TV = view.findViewById(R.id.textView_title1);
        title2_TV = view.findViewById(R.id.textView_title2);
        title3_TV = view.findViewById(R.id.textView_title3);
        title4_TV = view.findViewById(R.id.textView_title4);
        title5_TV = view.findViewById(R.id.textView_title5);
        title6_TV = view.findViewById(R.id.textView_title6);
        title7_TV = view.findViewById(R.id.textView_title7);
        title8_TV = view.findViewById(R.id.textView_title8);
        title9_TV = view.findViewById(R.id.textView_title9);

        hmts1_TV = view.findViewById(R.id.textView_howMuchToSell_1);
        hmts2_TV = view.findViewById(R.id.textView_howMuchToSell_2);
        hmts3_TV = view.findViewById(R.id.textView_howMuchToSell_3);

        //-----------------------------Spinner---------------------------\\
        spinnerCompany = view.findViewById(R.id.spinner_Company);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerCompany = view.findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(requireContext(), R.array.companySpinner_vit_E, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompany.setAdapter(adapterCompany);
        spinnerCompany.setOnItemSelectedListener(this);
        final Object Company = spinnerCompany.getSelectedItem();

        //-----------------------------TextEdit---------------------------\\
        amount_ET = view.findViewById(R.id.editText_amount);

        //-----------------------------Linear-Layout---------------------------\\


        //linearLayout1.setVisibility(View.GONE);
        //linearLayout2.setVisibility(View.GONE);

        //-----------------------------Button---------------------------\\
        calc_btn = view.findViewById(R.id.button_calc);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String valueFromET = amount_ET.getText().toString();

                //linearLayout1.setVisibility(View.VISIBLE);
                //linearLayout2.setVisibility(View.VISIBLE);

                if (!valueFromET.isEmpty()) {
                    amount = Double.parseDouble(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }

                //------------------------------FAGRON-GRAMY-----------------------------\\
                if (companyChoice == 1) {

                    textView_vitMain.setText("Vit. E Fagron");
                    textView_vitMain2.setText("(0.945 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Medana");
                    textView_text6.setText("(0.93 g/ml)");

                    gramsFagron = amount;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation1_TV.setText(gramsFagron + " g");
                    calculation2_TV.setText(volumeFagron + " ml");
                    calculation3_TV.setText(dropsFagron_String + " kropli");

                    hmts1 = volumeFagron / 10;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy E");

                    //------------------------------FAGRON-GRAMY-NA-HASCO-----------------------------\\

                    volumeHasco = gramsFagron / 0.3;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    gramsHasco = volumeHasco * 0.93;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = volumeHasco * 30;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    hmts2 = volumeHasco / 10;
                    hmts2 *= 1000;
                    hmts2 = Math.round(hmts2);
                    hmts2 /= 1000;
                    hmts2_TV.setText(hmts2 + " \nopakowania witaminy E");

                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;
                    dropsMedana = dropsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation7_TV.setText(gramsMedana + " g");
                    calculation8_TV.setText(volumeMedana + " ml");
                    calculation9_TV.setText(dropsMedana_String + " kropli");

                    hmts3_TV.setText(hmts2 + " \nopakowania witaminy E");
                }

                //------------------------------MEDANA-GRAMY-----------------------------\\
                if (companyChoice == 2) {

                    textView_vitMain.setText("Vit. E Medana");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    gramsMedana = amount;

                    volumeMedana = gramsMedana / 0.93;

                    volumeMedana *= 100;
                    volumeMedana = Math.round(volumeMedana);
                    volumeMedana /= 100;

                    dropsMedana = volumeMedana * 30;

                    dropsMedana = Math.round(dropsMedana);

                    String dropsMedana_String = String.valueOf(dropsMedana).replace(".0", "");

                    calculation1_TV.setText(gramsMedana + " g");
                    calculation2_TV.setText(volumeMedana + " ml");
                    calculation3_TV.setText(dropsMedana_String + " kropli");

                    hmts1 = volumeMedana / 10.0;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy E");

                    //------------------------------MEDANA-GRAMY-NA-HASCO-----------------------------\\
                    volumeHasco = volumeMedana;
                    gramsHasco = gramsMedana;


                    String dropsHasco_String = dropsMedana_String;

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    hmts2 = hmts1;
                    hmts2_TV.setText(hmts2 + " \nopakowania witaminy E");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\
                    gramsFagron = volumeMedana * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");

                    hmts3 = volumeFagron / 10.0;
                    hmts3 *= 1000;
                    hmts3 = Math.round(hmts3);
                    hmts3 /= 1000;
                    hmts3_TV.setText(hmts3 + " \nopakowania witaminy E");


                }

                //-----------------------------MEDANA-MILITRY----------------------------\\
                if (companyChoice == 3) {

                    textView_vitMain.setText("Vit. E Medana");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    volumeMedana = amount;

                    gramsMedana = volumeMedana * 0.93;

                    gramsMedana *= 100;
                    gramsMedana = Math.round(gramsMedana);
                    gramsMedana /= 100;

                    dropsMedana = volumeMedana * 30;
                    String dropsMedana_String = String.valueOf(dropsMedana).replace(".0", "");

                    calculation1_TV.setText(gramsMedana + " g");
                    calculation2_TV.setText(volumeMedana + " ml");
                    calculation3_TV.setText(dropsMedana_String + " kropli");

                    hmts1 = volumeMedana / 10.0;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy E");

                    //------------------------------MEDANA-GRAMY-NA-HASCO-----------------------------\\
                    volumeHasco = volumeMedana;
                    gramsHasco = gramsMedana;

                    String dropsHasco_String = dropsMedana_String;

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    hmts2 = hmts1;
                    hmts2_TV.setText(hmts2 + " \nopakowania witaminy E");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\
                    gramsFagron = volumeMedana * 0.3;


                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");

                    hmts3 = volumeFagron / 10.0;
                    hmts3 *= 1000;
                    hmts3 = Math.round(hmts3);
                    hmts3 /= 1000;
                    hmts3_TV.setText(hmts3 + " \nopakowania witaminy E");

                }

                //-------------------------------HASCO-GRAMY-----------------------------\\
                if (companyChoice == 4) {

                    textView_vitMain.setText("Vit. E Hasco");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Medana");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    gramsHasco = amount;

                    volumeHasco = gramsHasco / 0.93;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    dropsHasco = volumeHasco * 30;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation1_TV.setText(gramsHasco + " g");
                    calculation2_TV.setText(volumeHasco + " ml");
                    calculation3_TV.setText(dropsHasco_String);

                    hmts1 = volumeHasco / 10.0;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy E");

                    //------------------------------HASCO-GRAMY-NA-MEDANA-----------------------------\\
                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation4_TV.setText(gramsMedana + " g");
                    calculation5_TV.setText(volumeMedana + " ml");
                    calculation6_TV.setText(dropsMedana_String + " kropli");

                    hmts2 = hmts1;
                    hmts2_TV.setText(hmts2 + " \nopakowania witaminy E");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\

                    gramsFagron = volumeMedana * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");

                    hmts3 = volumeFagron / 10.0;
                    hmts3 *= 1000;
                    hmts3 = Math.round(hmts3);
                    hmts3 /= 1000;
                    hmts3_TV.setText(hmts3 + " \nopakowania witaminy E");


                }

                //-----------------------------HASCO-MILILITRY---------------------------\\
                if (companyChoice == 5) {

                    textView_vitMain.setText("Vit. E Hasco");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Medana");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    volumeHasco = amount;

                    gramsHasco = volumeHasco * 0.93;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = volumeHasco * 30;
                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation1_TV.setText(gramsHasco + " g");
                    calculation2_TV.setText(volumeHasco + " ml");
                    calculation3_TV.setText(dropsHasco_String + " kropli");

                    hmts1 = volumeHasco / 10.0;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + "\nopkaowania witaminy E");

                    //------------------------------HASCO-MILITRY-NA-MEDANA-----------------------------\\
                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;
                    hmts2 = hmts1;

                    String dropsMedana_String = dropsHasco_String;

                    calculation4_TV.setText(gramsMedana + " g");
                    calculation5_TV.setText(volumeMedana + " ml");
                    calculation6_TV.setText(dropsMedana_String + " kropli");

                    hmts2_TV.setText(hmts2 + "\nopakowania witaminy E");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\
                    gramsFagron = volumeHasco * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");

                    hmts3 = volumeFagron / 10.0;
                    hmts3 *= 1000;
                    hmts3 = Math.round(hmts3);
                    hmts3 /= 1000;
                    hmts3_TV.setText(hmts3 + " \nopakowania witaminy E");


                }

                //---------------------------------E-GRAMY-------------------------------\\
                if (companyChoice == 6) {
                    textView_vitMain.setText("Vit. E Fagron");
                    textView_vitMain2.setText("(0.945 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Medana");
                    textView_text6.setText("(0.93 g/ml)");

                    gramsFagron = amount;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation1_TV.setText(gramsFagron + " g");
                    calculation2_TV.setText(volumeFagron + " ml");
                    calculation3_TV.setText(dropsFagron_String + " kropli");

                    hmts1 = volumeFagron / 10.0;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy E");

                    //------------------------------FAGRON-GRAMY-NA-HASCO-----------------------------\\

                    volumeHasco = gramsFagron / 0.3;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    gramsHasco = volumeHasco * 0.93;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = volumeHasco * 30;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;
                    dropsMedana = dropsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation7_TV.setText(gramsMedana + " g");
                    calculation8_TV.setText(volumeMedana + " ml");
                    calculation9_TV.setText(dropsMedana_String + " kropli");

                    hmts2 = volumeHasco / 10.0;
                    hmts2 *= 1000;
                    hmts2 = Math.round(hmts2);
                    hmts2 /= 1000;
                    hmts2_TV.setText(hmts2 + "\nopkaowania witaminy E");

                    hmts3 = hmts2;
                    hmts3_TV.setText(hmts3 + "\nopakowania witaminy E");
                }

            }
        });


        return view;
    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinnerCompany = (Spinner) parent;

        if (spinnerCompany.getId() == R.id.spinner_Company) {
            Company = parent.getItemAtPosition(position).toString();

            if (Company.contains("Vit. E Fagron (g)")) {
                companyChoice = 1;
            }
            if (Company.contains("Vit. E Medana liq (g)")) {
                companyChoice = 2;
            }
            if (Company.contains("Vit. E Medana liq (ml)")) {
                companyChoice = 3;
            }
            if (Company.contains("Vit. E Hasco liq (g)")) {
                companyChoice = 4;
            }
            if (Company.contains("Vit. E Hasco liq (ml)")) {
                companyChoice = 5;
            }
            if (Company.contains("Vit. E (g)")) {
                companyChoice = 6;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}