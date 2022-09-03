package com.jakubolszewski.kalkulatorrecepturowy.Vitamins;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
 * Use the {@link VitA_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VitA_Fragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VitA_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VitA_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VitA_Fragment newInstance(String param1, String param2) {
        VitA_Fragment fragment = new VitA_Fragment();
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
    double volumeHasco, dropsHasco, massUnitHasco, gramsHasco;
    double volumeMedana, dropsMedana, massUnitMedana, gramsMedana;
    double volumeFagron, dropsFagron, massUnitFagron, gramsFagron;
    double hmts1, hmts2, hmts3;
    //-----------------------------text-variables---------------------------\\
    String Company, Unit, Hasco, Medana, Fargon, gram, jm;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerCompany, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV, calculation4_TV;
    TextView calculation5_TV, calculation6_TV, calculation7_TV, calculation8_TV;
    TextView calculation9_TV, calculation10_TV, calculation11_TV, calculation12_TV;
    TextView textView_text1, textView_text2, textView_text3, textView_text4, textView_text5, textView_text6;
    TextView textView_vitMain, textView_vitMain2;
    TextView title1_TV, title2_TV, title3_TV, title4_TV;
    TextView title5_TV, title6_TV, title7_TV, title8_TV;
    TextView title9_TV, title10_TV, title11_TV, title12_TV;
    TextView hmts1_TV, hmts2_TV, hmts3_TV;

    //Admob
    AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vit_a_, container, false);

        MobileAds.initialize(requireContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        spinnerCompany = view.findViewById(R.id.spinner_Company);
        spinnerUnit = view.findViewById(R.id.spinner_unit);

        //-----------------------------text-variables---------------------------\\
        Hasco = "Vitaminimum A Hasco 45000 j/ml";
        Medana = "Vitaminimum A Medana 50000 j/ml";
        Fargon = "Vitaminimum A Fagron";
        gram = "Vit liq \"XX\" g";
        jm = "VIT A \"XX\" j.m.";

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
        calculation10_TV = view.findViewById(R.id.textView_calculation10);
        calculation11_TV = view.findViewById(R.id.textView_calculation11);
        calculation12_TV = view.findViewById(R.id.textView_calculation12);


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
        title10_TV = view.findViewById(R.id.textView_title10);
        title11_TV = view.findViewById(R.id.textView_title11);
        title12_TV = view.findViewById(R.id.textView_title12);

        hmts1_TV = view.findViewById(R.id.textView_howMuchToSell_1);
        hmts2_TV = view.findViewById(R.id.textView_howMuchToSell_2);
        hmts3_TV = view.findViewById(R.id.textView_howMuchToSell_3);

        //-----------------------------Spinner---------------------------\\
        spinnerCompany = view.findViewById(R.id.spinner_Company);
        spinnerUnit = view.findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerCompany = view.findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(requireContext(), R.array.companySpinner_vit_A, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompany.setAdapter(adapterCompany);
        spinnerCompany.setOnItemSelectedListener(this);
        final Object Company = spinnerCompany.getSelectedItem();

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = view.findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.unitSpinner, android.R.layout.simple_spinner_item);
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
                //-----------------------------HASCO---------------------------\\
                if (companyChoice == 1) {

                    textView_vitMain.setText("Vit. A Hasco");
                    textView_vitMain2.setText("(1.148 g/ml)");
                    textView_text3.setText("Vit. A Medana");
                    textView_text4.setText("(1.08 g/ml)");
                    textView_text5.setText("Vit. A Fagron ");
                    textView_text6.setText("(Roztwór pomocniczy)");
                    title10_TV.setVisibility(View.GONE);
                    calculation10_TV.setVisibility(View.GONE);

                    String test = String.valueOf(volumeHasco);


                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {
                        gramsHasco = amount;

                        volumeHasco = gramsHasco / 1.148;

                        volumeHasco *= 100;
                        volumeHasco = Math.round(volumeHasco);
                        volumeHasco /= 100;

                        dropsHasco = volumeHasco * 28;
                        massUnitHasco = volumeHasco * 45000;


                        massUnitHasco = Math.round(massUnitHasco);
                        String massUnit_String = String.valueOf(massUnitHasco).replace(".0", "");

                        calculation1_TV.setText(volumeHasco + "ml");
                        calculation2_TV.setText((int) dropsHasco + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                        calculation4_TV.setText(gramsHasco + "g");

                    }
                    //-----------------------------J.M.---------------------------\\
                    if (unitChoice == 2) {
                        massUnitHasco = amount;

                        volumeHasco = massUnitHasco / 45000;

                        volumeHasco *= 100;
                        volumeHasco = Math.round(volumeHasco);
                        volumeHasco /= 100;

                        dropsHasco = volumeHasco * 28;
                        gramsHasco = volumeHasco * 1.148;

                        dropsHasco = Math.round(dropsHasco);
                        String drops_String = String.valueOf(dropsHasco).replace(".0", "");

                        massUnitHasco = Math.round(massUnitHasco);
                        String massUnit_String = String.valueOf(massUnitHasco).replace(".0", "");

                        gramsHasco *= 100;
                        gramsHasco = Math.round(gramsHasco);
                        gramsHasco /= 100;

                        calculation1_TV.setText(volumeHasco + "ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                        calculation4_TV.setText(gramsHasco + "g");

                    }
                    //-----------------------------mililitr---------------------------\\
                    if (unitChoice == 3) {

                        volumeHasco = amount;

                        massUnitHasco = volumeHasco * 45000;

                        dropsHasco = volumeHasco * 28;
                        gramsHasco = volumeHasco * 1.148;

                        dropsHasco = Math.round(dropsHasco);
                        String drops_String = String.valueOf(dropsHasco).replace(".0", "");

                        massUnitHasco = Math.round(massUnitHasco);
                        String massUnit_String = String.valueOf(massUnitHasco).replace(".0", "");

                        gramsHasco *= 100;
                        gramsHasco = Math.round(gramsHasco);
                        gramsHasco /= 100;

                        calculation1_TV.setText(volumeHasco + "ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                        calculation4_TV.setText(gramsHasco + "g");

                    }

                    hmts1 = volumeHasco / 10;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy A");
                    //-----------------------------A-Hasco-na-A-Medana---------------------------\\
                    massUnitMedana = massUnitHasco;

                    volumeMedana = massUnitHasco / 50000;

                    volumeMedana *= 100;
                    volumeMedana = Math.round(volumeMedana);
                    volumeMedana /= 100;

                    dropsMedana = volumeMedana * 30;
                    gramsMedana = volumeMedana * 1.08;

                    gramsMedana *= 100;
                    gramsMedana = Math.round(gramsMedana);
                    gramsMedana /= 100;

                    dropsMedana = Math.round(dropsMedana);
                    String drops_String = String.valueOf(dropsMedana).replace(".0", "");

                    massUnitHasco = Math.round(massUnitMedana);
                    String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                    calculation5_TV.setText(gramsMedana + " g");
                    calculation6_TV.setText(volumeMedana + " ml");
                    calculation7_TV.setText((int) dropsMedana + " kropli");
                    calculation8_TV.setText(massUnit_String + " j.m.");
                    textView_text3.setText("Vit. A Medana");

                    hmts2 = volumeMedana / 10;
                    hmts2 *= 1000;
                    hmts2 = Math.round(hmts2);
                    hmts2 /= 1000;
                    hmts2_TV.setText(hmts2 + " \nopakowania witaminy A");

                    //-----------------------------A-Hasco-na-A-Fagron---------------------------\\

                    massUnitFagron = massUnitHasco;

                    dropsFagron = massUnitFagron / 10000;
                    gramsFagron = dropsFagron * 0.034;
                    volumeFagron = 0; //nie znamy gęstości. Brak mililitrów.

                    dropsFagron = Math.round(dropsFagron);

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");
                    String massUnitFagron_String = String.valueOf(massUnitFagron).replace(".0", "");

                    calculation9_TV.setText(gramsFagron + " g");
                    calculation11_TV.setText((int) dropsFagron + " kropli");
                    calculation12_TV.setText(massUnitFagron_String + " j.m.");

                    hmts3_TV.setText("Jeszcze tego nie wpieramy.");


                }
                //-----------------------------MEDANA---------------------------\\
                if (companyChoice == 2) {
                    textView_vitMain.setText("Vit. A Medana");
                    textView_vitMain2.setText("(1.08 g/ml)");
                    textView_text3.setText("Vit. A Hasco");
                    textView_text4.setText("(1.148 g/ml)");
                    textView_text5.setText("Vit. A Fagron ");
                    textView_text6.setText("(Roztwór pomocniczy)");
                    title10_TV.setVisibility(View.GONE);
                    calculation10_TV.setVisibility(View.GONE);

                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        gramsMedana = amount;

                        volumeMedana = gramsMedana / 1.08;

                        volumeMedana *= 100;
                        volumeMedana = Math.round(volumeMedana);
                        volumeMedana /= 100;

                        dropsMedana = volumeMedana * 30;

                        massUnitMedana = volumeMedana * 50000;

                        dropsMedana = Math.round(dropsMedana);
                        massUnitMedana = Math.round(massUnitMedana);

                        String drops_String = String.valueOf(dropsMedana).replace(".0", "");
                        String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                        calculation4_TV.setText(gramsMedana + " g");
                        calculation1_TV.setText(volumeMedana + " ml");
                        calculation2_TV.setText((int) dropsMedana + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");


                    }

                    //-----------------------------J.M.---------------------------\\
                    if (unitChoice == 2) {

                        massUnitMedana = amount;

                        volumeMedana = massUnitMedana / 50000;

                        volumeMedana *= 100;
                        volumeMedana = Math.round(volumeMedana);
                        volumeMedana /= 100;

                        gramsMedana = volumeMedana * 1.08;
                        dropsMedana = volumeMedana * 30;

                        gramsMedana *= 100;
                        gramsMedana = Math.round(gramsMedana);
                        gramsMedana /= 100;

                        dropsMedana = Math.round(dropsMedana);
                        massUnitMedana = Math.round(massUnitMedana);

                        String drops_String = String.valueOf(dropsMedana).replace(".0", "");
                        String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                        calculation4_TV.setText(gramsMedana + " g");
                        calculation1_TV.setText(volumeMedana + " ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                    }
                    //-----------------------------mililitr---------------------------\\
                    if (unitChoice == 3) {

                        volumeMedana = amount;

                        gramsMedana = volumeMedana * 1.08;
                        dropsMedana = volumeMedana * 30;

                        gramsMedana *= 100;
                        gramsMedana = Math.round(gramsMedana);
                        gramsMedana /= 100;

                        dropsMedana = Math.round(dropsMedana);
                        massUnitMedana = Math.round(massUnitMedana);

                        String drops_String = String.valueOf(dropsMedana).replace(".0", "");
                        String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                        calculation4_TV.setText(gramsMedana + " g");
                        calculation1_TV.setText(volumeMedana + " ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");

                    }

                    hmts1 = volumeMedana / 10;
                    hmts1 *= 1000;
                    hmts1 = Math.round(hmts1);
                    hmts1 /= 1000;
                    hmts1_TV.setText(hmts1 + " \nopakowania witaminy A");

                    //-----------------------------A-Medana-na-A-Hasco---------------------------\\

                    massUnitHasco = massUnitMedana;

                    volumeHasco = massUnitHasco / 45000;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    gramsHasco = volumeHasco * 1.148;
                    dropsHasco = volumeHasco * 28;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");
                    String massUnitHasco_String = String.valueOf(massUnitHasco).replace(".0", "");

                    calculation5_TV.setText(gramsHasco + " g");
                    calculation6_TV.setText(volumeHasco + " ml");
                    calculation7_TV.setText(dropsHasco_String + " kropli");
                    calculation8_TV.setText(massUnitHasco_String + " j.m.");

                    hmts2 = volumeHasco / 10.0;
                    hmts2 *= 1000;
                    hmts2 = Math.round(hmts2);
                    hmts2 /= 1000;
                    hmts2_TV.setText(hmts2 + " \nopakowania witaminy A");

                    //-----------------------------A-Medana-na-A-Fagron---------------------------\\
                    massUnitFagron = massUnitMedana;

                    dropsFagron = massUnitFagron / 10000;
                    gramsFagron = dropsFagron * 0.034;
                    volumeFagron = 0; //nie znamy gęstości. Brak mililitrów.

                    dropsFagron = Math.round(dropsFagron);

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");
                    String massUnitFagron_String = String.valueOf(massUnitFagron).replace(".0", "");

                    calculation9_TV.setText(gramsFagron + " g");
                    calculation11_TV.setText(dropsFagron_String + " kropli");
                    calculation12_TV.setText(massUnitFagron_String + " j.m.");

                    hmts3_TV.setText("Jeszcze tego nie wpieramy.");

                }

                //-----------------------------FAGRON---------------------------\\
                if (companyChoice == 3) {
                    textView_vitMain.setText("Vit. A Fagron");
                    textView_vitMain2.setText("(roztwór pomocniczy)");
                    textView_text3.setText("Vit. A Hasco");
                    textView_text4.setText("(1.148 g/ml)");
                    textView_text5.setText("Vit. A Medana");
                    textView_text6.setText("(1.08 g/ml)");
                    title10_TV.setVisibility(View.VISIBLE);
                    calculation10_TV.setVisibility(View.VISIBLE);

                    textView_vitMain2.setTextColor(Color.RED);
                    textView_vitMain2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Intent intent = new Intent(requireContext(), auxiliarySolutionActivity.class);
                            //startActivity(intent);
                        }
                    });

                    if (unitChoice == 1) {

                        new android.app.AlertDialog.Builder(requireContext())
                                .setTitle("Błąd")
                                .setMessage("Zmień na jednostki masy (j.m.)")
                                .show();

                    }

                    if (unitChoice == 2) {

                        massUnitFagron = amount;

                        dropsFagron = massUnitFagron / 10000;
                        gramsFagron = dropsFagron * 0.034;

                        gramsFagron *= 100;
                        gramsFagron = Math.round(gramsFagron);
                        gramsFagron /= 100;

                        dropsFagron = Math.round(dropsFagron);
                        String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                        calculation4_TV.setText(gramsFagron + " g");
                        calculation2_TV.setText(dropsFagron_String + " kropli");
                        calculation3_TV.setText(massUnitFagron + " j.m.");
                        hmts1_TV.setText("Jeszcze tego nie wpieramy.");

                        massUnitHasco = massUnitFagron;

                        volumeHasco = massUnitHasco / 45000;

                        volumeHasco *= 100;
                        volumeHasco = Math.round(volumeHasco);
                        volumeHasco /= 100;

                        dropsHasco = volumeHasco * 28;
                        gramsHasco = volumeHasco * 1.148;

                        gramsHasco *= 100;
                        gramsHasco = Math.round(gramsHasco);
                        gramsHasco /= 100;

                        dropsHasco = Math.round(dropsHasco);
                        String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                        calculation5_TV.setText(gramsHasco + " g");
                        calculation6_TV.setText(volumeHasco + " ml");
                        calculation7_TV.setText(dropsHasco_String + " kropli");
                        calculation8_TV.setText(massUnitHasco + " j.m.");

                        hmts2 = volumeHasco / 10;
                        hmts2 *= 1000;
                        hmts2 = Math.round(hmts2);
                        hmts2 /= 1000;
                        hmts2_TV.setText(hmts2 + " \nopakowania witaminy A");

                        massUnitMedana = massUnitFagron;

                        volumeMedana = massUnitMedana / 50000;

                        volumeMedana *= 100;
                        volumeMedana = Math.round(volumeMedana);
                        volumeMedana /= 100;

                        dropsMedana = volumeMedana * 30;
                        gramsMedana = volumeMedana * 1.08;

                        gramsMedana *= 100;
                        gramsMedana = Math.round(gramsMedana);
                        gramsMedana /= 100;

                        dropsMedana = Math.round(dropsMedana);
                        String dropsMedana_String = String.valueOf(dropsMedana).replace(".0", "");

                        calculation9_TV.setText(gramsMedana + " g");
                        calculation10_TV.setText(volumeMedana + " ml");
                        calculation11_TV.setText(dropsMedana_String + " kropli");
                        calculation12_TV.setText(massUnitMedana + " j.m.");

                        hmts3 = volumeMedana / 10;
                        hmts3 *= 1000;
                        hmts3 = Math.round(hmts3);
                        hmts3 /= 1000;
                        hmts3_TV.setText(hmts3 + " \nopakowania witaminy A");


                    }
                    //-----------------------------mililitr---------------------------\\
                    if (unitChoice == 3) {

                        new AlertDialog.Builder(requireContext())
                                .setTitle("Błąd")
                                .setMessage("Zmień na jednostki masy (j.m.)")
                                .show();

                    }

                }
            }

        });


        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String value1, value2;

        Spinner spinnerCompany = (Spinner) parent;
        Spinner spinnerUnit = (Spinner) parent;

        if (spinnerCompany.getId() == R.id.spinner_Company) {
            Company = parent.getItemAtPosition(position).toString();
            //Toast.makeText(vitaminAActivity.this, Company, Toast.LENGTH_SHORT).show();

            if (Company.contains("Hasco")) {
                companyChoice = 1;
                //Toast.makeText(requireContext(), "1", Toast.LENGTH_SHORT).show();


            }
            if (Company.contains("Medana")) {
                companyChoice = 2;
                //Toast.makeText(vitaminAActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
            if (Company.contains("Fagron")) {
                companyChoice = 3;
                //Toast.makeText(vitaminAActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        }
        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();
            //Toast.makeText(vitaminAActivity.this, Unit, Toast.LENGTH_SHORT).show();

            if (Unit.contains("g")) {
                unitChoice = 1;
            }
            if (Unit.contains("j.m.")) {
                unitChoice = 2;
            }
            if (Unit.contains("ml")) {
                unitChoice = 3;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}