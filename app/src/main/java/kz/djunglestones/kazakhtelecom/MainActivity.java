package kz.djunglestones.kazakhtelecom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mainBottomNavigationView;

    private EmailFragment emailFragment;
    private PortalFragment portalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBottomNavigationView = findViewById(R.id.mainBottomNavigationView);

        portalFragment = new PortalFragment();
        emailFragment = new EmailFragment();
        replaceFragment(emailFragment);

        mainBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mail_menu:
                        replaceFragment(emailFragment);
                        return true;
                    case R.id.portal_menu:
                        replaceFragment(emailFragment);
                        return true;
                    default:
                        return false;
                }

            }
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();


    }


}
