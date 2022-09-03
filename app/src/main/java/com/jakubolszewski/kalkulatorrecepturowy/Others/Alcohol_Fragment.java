package com.jakubolszewski.kalkulatorrecepturowy.Others;

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
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jakubolszewski.kalkulatorrecepturowy.R;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Alcohol_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Alcohol_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Alcohol_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Alcohol_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Alcohol_Fragment newInstance(String param1, String param2) {
        Alcohol_Fragment fragment = new Alcohol_Fragment();
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
    int selectedTypeOf, concentrationValue;

    double possessedConcentration, howMuchToRecive, outcome, outcomeWater, concentrationValueDegree, compare;

    //-----------------------------text-variables---------------------------\\
    String selectedConcentration, typeOfConcentration, trim;

    //-----------------------------layouts-elements---------------------------\\
    Spinner concentrationSpinner, selectTypeOfConcentrationSpinner;
    EditText concentrationValue_ET, howMuchToRecive_ET;
    TextView alcohol_TV, water_TV, volume_TV;
    Button calc_btn;

    HashMap<String, Double> hMConcentration = new HashMap<String, Double>();
    HashMap<Integer, Double> hMDegree = new HashMap<Integer, Double>();

    AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alcohol_, container, false);

        MobileAds.initialize(requireContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//-----------------------------hashMap---------------------------\\
        hMConcentration.put("Wybierz",0.0);
        hMConcentration.put("96.9° (95.16 m/m)", 95.16);
        hMConcentration.put("96.8° (95.01 m/m)", 95.01);
        hMConcentration.put("96.7° (94.86 m/m)", 94.86);
        hMConcentration.put("96.6° (94.71 m/m)", 94.71);
        hMConcentration.put("96.5° (94.57 m/m)", 94.57);
        hMConcentration.put("96.4° (94.42 m/m)", 94.42);
        hMConcentration.put("96.3° (94.27 m/m)", 94.27);
        hMConcentration.put("96.2° (94.13 m/m)", 94.13);
        hMConcentration.put("96.1° (93.98 m/m)", 93.98);
        hMConcentration.put("96° (93.84 m/m)", 93.84);
        hMConcentration.put("95.9° (93.69 m/m)", 93.69);
        hMConcentration.put("95.8° (93.55 m/m)", 93.55);
        hMConcentration.put("95.7° (93.41 m/m)", 93.41);
        hMConcentration.put("95.6° (93.26 m/m)", 93.26);
        hMConcentration.put("95.5° (93.12 m/m)", 93.12);
        hMConcentration.put("95.4° (92.98 m/m)", 92.98);
        hMConcentration.put("95.3° (92.83 m/m)", 92.83);
        hMConcentration.put("95.2° (92.69 m/m)", 92.69);
        hMConcentration.put("95.1° (92.55 m/m)", 92.55);
        hMConcentration.put("70.6° (63.03 m/m)", 63.23);
        hMConcentration.put("70.5° (62.92 m/m)", 62.92);
        hMConcentration.put("70.4° (62.81 m/m)", 62.81);
        hMConcentration.put("70.3° (62.71 m/m)", 62.71);
        hMConcentration.put("70.2° (62.6 m/m)", 62.6);
        hMConcentration.put("70° (62.39 m/m)", 62.39);
        hMConcentration.put("69.9° (62.28 m/m)", 62.28);
        hMConcentration.put("69.8° (62.17 m/m)", 62.17);

        //-----------------------------hashMap---------------------------\\
        hMDegree.put(1, 0.86);
        hMDegree.put(2, 1.61);
        hMDegree.put(3, 2.39);
        hMDegree.put(4, 3.18);
        hMDegree.put(5, 3.99);
        hMDegree.put(6, 4.84);
        hMDegree.put(7, 5.89);
        hMDegree.put(8, 6.49);
        hMDegree.put(9, 7.28);
        hMDegree.put(10, 8.09);
        hMDegree.put(11, 8.90);
        hMDegree.put(12, 9.73);
        hMDegree.put(13, 10.58);
        hMDegree.put(14, 11.30);
        hMDegree.put(15, 12.18);
        hMDegree.put(16, 12.91);
        hMDegree.put(17, 13.82);
        hMDegree.put(18, 14.59);
        hMDegree.put(19, 15.53);
        hMDegree.put(20, 16.31);
        hMDegree.put(21, 17.09);
        hMDegree.put(22, 18.01);
        hMDegree.put(23, 18.76);
        hMDegree.put(24, 19.67);
        hMDegree.put(25, 20.41);
        hMDegree.put(26, 21.30);
        hMDegree.put(27, 22.16);
        hMDegree.put(28, 23.03);
        hMDegree.put(29, 23.88);
        hMDegree.put(30, 24.72);
        hMDegree.put(31, 25.53);
        hMDegree.put(32, 36.33);
        hMDegree.put(33, 27.24);
        hMDegree.put(34, 28.12);
        hMDegree.put(35, 28.99);
        hMDegree.put(36, 29.83);
        hMDegree.put(37, 30.65);
        hMDegree.put(38, 31.58);
        hMDegree.put(39, 32.49);
        hMDegree.put(40, 33.38);
        hMDegree.put(41, 34.26);
        hMDegree.put(42, 35.12);
        hMDegree.put(43, 36.07);
        hMDegree.put(44, 36.90);
        hMDegree.put(45, 37.82);
        hMDegree.put(46, 38.72);
        hMDegree.put(47, 39.72);
        hMDegree.put(48, 40.61);
        hMDegree.put(49, 41.58);
        hMDegree.put(50, 42.44);
        hMDegree.put(51, 43.40);
        hMDegree.put(52, 44.34);
        hMDegree.put(53, 45.27);
        hMDegree.put(54, 46.29);
        hMDegree.put(55, 47.21);
        hMDegree.put(56, 48.21);
        hMDegree.put(57, 49.21);
        hMDegree.put(58, 50.11);
        hMDegree.put(59, 51.09);
        hMDegree.put(60, 52.16);
        hMDegree.put(61, 53.14);
        hMDegree.put(62, 54.10);
        hMDegree.put(63, 55.16);
        hMDegree.put(64, 56.21);
        hMDegree.put(65, 57.16);
        hMDegree.put(66, 58.21);
        hMDegree.put(67, 59.25);
        hMDegree.put(68, 60.28);
        hMDegree.put(69, 61.40);
        hMDegree.put(70, 62.43);
        hMDegree.put(71, 63.54);
        hMDegree.put(72, 64.57);
        hMDegree.put(73, 65.68);
        hMDegree.put(74, 66.78);
        hMDegree.put(75, 67.88);
        hMDegree.put(76, 68.97);
        hMDegree.put(77, 70.07);
        hMDegree.put(78, 71.24);
        hMDegree.put(79, 72.33);
        hMDegree.put(80, 73.50);
        hMDegree.put(81, 74.66);
        hMDegree.put(82, 75.81);
        hMDegree.put(83, 77.05);
        hMDegree.put(84, 78.20);
        hMDegree.put(85, 79.42);
        hMDegree.put(86, 80.63);
        hMDegree.put(87, 81.92);
        hMDegree.put(88, 83.12);
        hMDegree.put(89, 84.38);
        hMDegree.put(90, 85.71);
        hMDegree.put(91, 87.03);
        hMDegree.put(92, 88.34);
        hMDegree.put(93, 89.70);
        hMDegree.put(94, 91.4);
        hMDegree.put(95, 92.43);
        hMDegree.put(96, 93.87);
        hMDegree.put(97, 94.36);
        hMDegree.put(98, 96.87);
        hMDegree.put(99, 98.41);
        hMDegree.put(100, 100.0);

        //-----------------------------Spinner---------------------------\\

        //-----------------------------textview---------------------------\\
        alcohol_TV = view.findViewById(R.id.textView_alcohol);
        water_TV = view.findViewById(R.id.textView_water);
        volume_TV = view.findViewById(R.id.textView_volume);

        //-----------------------------Spinner---------------------------\\
        concentrationSpinner = view.findViewById(R.id.spinner_concentration);
        selectTypeOfConcentrationSpinner = view.findViewById(R.id.spinner_select_concentration);

        //-----------------------------Spinner---------------------------\\
        Spinner selectTypeOfConcentrationSpinner = view.findViewById(R.id.spinner_select_concentration);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(requireContext(), R.array.type_of_concentration, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectTypeOfConcentrationSpinner.setAdapter(adapterCompany);
        selectTypeOfConcentrationSpinner.setOnItemSelectedListener(this);

        //-----------------------------Spinner---------------------------\\
        Spinner concentrationSpinner = view.findViewById(R.id.spinner_concentration);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.concentration, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        concentrationSpinner.setAdapter(adapter);
        concentrationSpinner.setOnItemSelectedListener(this);

        //-----------------------------Edittext---------------------------\\
        concentrationValue_ET = view.findViewById(R.id.editText_concentration_value);
        howMuchToRecive_ET = view.findViewById(R.id.editText_how_much);

        //------------------------------Button---------------------------\\
        calc_btn = view.findViewById(R.id.button_calc);

        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String concentrationValue_ET_value = concentrationValue_ET.getText().toString();
                final String howMuchToRecive_ET_value = howMuchToRecive_ET.getText().toString();

                if (!concentrationValue_ET_value.isEmpty()) {
                    concentrationValue = Integer.parseInt(concentrationValue_ET_value);
                } else {
                    concentrationValue_ET.setError("To pole jest wymagane");
                }

                if (!howMuchToRecive_ET_value.isEmpty()) {
                    howMuchToRecive = Double.parseDouble(howMuchToRecive_ET_value);
                } else {
                    howMuchToRecive_ET.setError("To pole jest wymagane");
                }

                Toast.makeText(getContext(), selectedTypeOf, Toast.LENGTH_SHORT).show();

                //------------------------------v/v---------------------------\\
                if (selectedTypeOf == 1) {

                    possessedConcentration = hMConcentration.get(selectedConcentration);

                    concentrationValueDegree = hMDegree.get(concentrationValue);

                    trim = selectedConcentration;
                    trim = trim.substring(0, trim.indexOf("(")).replace("°", "").trim();

                    //Toast.makeText(alcoholActivity.this, trim, Toast.LENGTH_SHORT).show();

                    compare = Double.valueOf(trim);

                    compare = Math.round(compare);

                    if (concentrationValue < compare) {

                        outcome = howMuchToRecive * concentrationValueDegree / possessedConcentration;

                    } else {
                        new AlertDialog.Builder(requireContext())
                                .setTitle("Błąd")
                                .setMessage("Procent objętościowy(v/v) końcowego roztworu nie może być większy niż procent objętościowy posiadanego etanolu")
                                .show();
                    }


                }

                //------------------------------m/m---------------------------\\
                if (selectedTypeOf == 2) {

                    possessedConcentration = hMConcentration.get(selectedConcentration);

                    if (concentrationValue < possessedConcentration) {

                        outcome = howMuchToRecive * concentrationValue / possessedConcentration;

                    } else {
                        new AlertDialog.Builder(requireContext())
                                .setTitle("Błąd")
                                .setMessage("Procent masowy(m/m) końcowego roztworu nie może być większy niż procent objętościowy posiadanego etanolu")
                                .show();
                    }

                }
                if (concentrationValue < compare) {
                    outcome *= 100;
                    outcome = Math.round(outcome);
                    outcome /= 100;

                    outcomeWater = howMuchToRecive - outcome;

                    outcomeWater *= 100;
                    outcomeWater = Math.round(outcomeWater);
                    outcomeWater /= 100;

                    double volume = outcome / 0.8065; //g/cm3
                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    alcohol_TV.setText(" " + outcome + " g etanolu");
                    water_TV.setText(" " + outcomeWater + " g wody");
                    volume_TV.setText(" " + volume +" ml");
                }
            }
        });




        return view;
    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String value1, value2;

        Spinner selectTypeOfConcentrationSpinner = (Spinner) parent;
        Spinner concentrationSpinner = (Spinner) parent;

        if (selectTypeOfConcentrationSpinner.getId() == R.id.spinner_select_concentration) {
            typeOfConcentration = parent.getItemAtPosition(position).toString();
            Toast.makeText(getContext(),typeOfConcentration, Toast.LENGTH_SHORT).show();

            if (typeOfConcentration.contains("v/v")) {
                selectedTypeOf = 1;
            }

            if (typeOfConcentration.contains("m/m")) {
                selectedTypeOf = 2;
                Toast.makeText(getContext(),"m/m", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(),Integer.toString(selectedTypeOf), Toast.LENGTH_SHORT).show();
            }

        }
        if (concentrationSpinner.getId() == R.id.spinner_concentration) {
            selectedConcentration = parent.getItemAtPosition(position).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}