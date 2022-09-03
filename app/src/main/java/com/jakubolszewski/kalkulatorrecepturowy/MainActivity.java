package com.jakubolszewski.kalkulatorrecepturowy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakubolszewski.kalkulatorrecepturowy.Oils.Oleje_Fragment;
import com.jakubolszewski.kalkulatorrecepturowy.Oils.Olejki_Fragment;
import com.jakubolszewski.kalkulatorrecepturowy.Others.Alcohol_Fragment;
import com.jakubolszewski.kalkulatorrecepturowy.Others.FeedbackFragment;
import com.jakubolszewski.kalkulatorrecepturowy.Others.InfoFragment;
import com.jakubolszewski.kalkulatorrecepturowy.Vitamins.Devicap_Fragment;
import com.jakubolszewski.kalkulatorrecepturowy.Vitamins.VitAD3_Fragment;
import com.jakubolszewski.kalkulatorrecepturowy.Vitamins.VitA_Fragment;
import com.jakubolszewski.kalkulatorrecepturowy.Vitamins.VitE_Fragment;

public class MainActivity extends AppCompatActivity {
     FrameLayout frameLayout;
     FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        frameLayout = findViewById(R.id.frameLayout);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in,  // enter
                            R.anim.fade_out,  // exit
                            R.anim.fade_in,   // popEnter
                            R.anim.slide_out  // popExit
                    )
                    .setReorderingAllowed(true)
                    .add(R.id.frameLayout, HomeFragment.class, null)
                    .commit();
        }

    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                )
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void goToVItA(View view) {
        changeFragment(new VitA_Fragment());
    }

    public void goToVitE(View view) {
        changeFragment(new VitE_Fragment());
    }

    public void goToVitAD3(View view) {
        changeFragment(new VitAD3_Fragment());
    }

    public void goToVitDevice(View view) {
        changeFragment(new Devicap_Fragment());
    }

    public void goToAlcohol(View view) {
        changeFragment(new Alcohol_Fragment());
    }

    public void goToOlejki(View view) {
        changeFragment(new Olejki_Fragment());
    }

    public void goToOleje(View view) {
        changeFragment(new Oleje_Fragment());
    }

    public void goToInfo(View view) {
        changeFragment(new InfoFragment());
    }

    public void goBack(View view) {
        changeFragment(new HomeFragment());
    }

    public void moveToFeedback(View view) {
        changeFragment(new FeedbackFragment());
    }

    public void openEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "j.olszewski05@gmail.com" });
        startActivity(Intent.createChooser(intent, ""));
    }

    public void openDiscord(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://discord.gg/2UxCgT")));
    }

    public void openLinkedin(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jakub-olszewski-926b4b175")));
    }
}