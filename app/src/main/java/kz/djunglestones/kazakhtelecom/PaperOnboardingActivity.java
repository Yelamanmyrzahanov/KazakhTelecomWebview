package kz.djunglestones.kazakhtelecom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class PaperOnboardingActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_onboarding);
        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container1, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                Intent mainIntent = new Intent(PaperOnboardingActivity.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                Fragment bf = new BlankFragment();
//                fragmentTransaction.replace(R.id.fragment_container1, bf);
//                fragmentTransaction.commit();
            }
        });

//        SharedPreferences settings = this.getSharedPreferences("appInfo", 0);
//        boolean firstTime = settings.getBoolean("first_time", true);
//        if (firstTime) {
//            SharedPreferences.Editor editor = settings.edit();
//            editor.putBoolean("first_time", false);
//            editor.commit();
//
//        }else{
//            Intent mainIntent = new Intent(PaperOnboardingActivity.this,MainActivity.class);
//            startActivity(mainIntent);
//            finish();
//        }
    }


    // Just example data for Onboarding
    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        PaperOnboardingPage scr1 = new PaperOnboardingPage("ДИС", "Теперь портал в мобильном приложении",
                Color.parseColor("#678FB4"), R.drawable.obj1, R.drawable.tablet_24dp);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Почта", "В добавок для удобства отдельная вклдака для почты",
                Color.parseColor("#65B0B4"), R.drawable.obj2, R.drawable.email);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Защищенность", "Аутентификация при каждой сессии",
                Color.parseColor("#9B90BC"), R.drawable.obj3, R.drawable.safety);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        return elements;
    }

}
