package com.jakubolszewski.kalkulatorrecepturowy.Others;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;
import com.jakubolszewski.kalkulatorrecepturowy.R;
import com.jakubolszewski.kalkulatorrecepturowy.MainActivity.*;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedbackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedbackFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedbackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedbackFragment newInstance(String param1, String param2) {
        FeedbackFragment fragment = new FeedbackFragment();
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
    EditText nameData;
    EditText emailData;
    EditText messageData;
    Button send;
    Button details;
    Firebase firebase;
    CheckBox error_CB, opinion_CB, idea_CB;
    String UniqueID;

    //SIDEBAR MENU
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        MobileAds.initialize(requireContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //FEEDBACK
        nameData = view.findViewById(R.id.editText_nameData);
        emailData = view.findViewById(R.id.editText_emailData);
        messageData = view.findViewById(R.id.editText_messageData);

        error_CB = view.findViewById(R.id.checkBox_error);
        opinion_CB = view.findViewById(R.id.checkBox_opinion);
        idea_CB = view.findViewById(R.id.checkBox_idea);

        send = view.findViewById(R.id.button_send);
        details = view.findViewById(R.id.button_details);

        Firebase.setAndroidContext(requireContext());

        UniqueID = Settings.Secure.getString(requireContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        error_CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opinion_CB.setChecked(false);
                idea_CB.setChecked(false);
                firebase = new Firebase("https://kalkulator-recepturowy.firebaseio.com/error/" + UniqueID);
            }
        });

        opinion_CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_CB.setChecked(false);
                idea_CB.setChecked(false);
                firebase = new Firebase("https://kalkulator-recepturowy.firebaseio.com/opinion/" + UniqueID);
            }
        });

        idea_CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_CB.setChecked(false);
                opinion_CB.setChecked(false);
                firebase = new Firebase("https://kalkulator-recepturowy.firebaseio.com/idea/" + UniqueID);
            }
        });

        firebase = new Firebase("https://kalkulator-recepturowy.firebaseio.com/feedback/" + UniqueID);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setEnabled(true);
                final String name = nameData.getText().toString();
                final String email = emailData.getText().toString();
                final String message = messageData.getText().toString();

                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()) {
                    nameData.setError("To pole jest wymagane!");
                    send.setEnabled(false);

                } else {
                    nameData.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);
                if (email.isEmpty()) {
                    emailData.setError("To pole jest wymagane!");
                    send.setEnabled(false);

                } else {
                    emailData.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);
                if (message.isEmpty()) {
                    messageData.setError("To pole jest wymagane!");
                    send.setEnabled(false);

                } else {
                    messageData.setError(null);
                    send.setEnabled(true);
                }
                Toast.makeText(requireContext(), "Wiadomość zostałą wysłana", Toast.LENGTH_SHORT).show();
                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(requireContext())
                                .setTitle("Szczegoły wiadomości:")
                                .setMessage("Imię - " + name + "\n\nEmail - " + email + "\n\nWiadomość - " + message)
                                .show();
                    }
                });
            }
        });
        
        return view;
    }
}