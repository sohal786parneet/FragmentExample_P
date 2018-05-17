package com.college.lasalle.fragmentexample_p;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    public static final String FRAGMENT_TITLE_TAG = "com.college.lasalle.fragmentexample_p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT){

            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragmentTitle = fragmentManager.findFragmentByTag(FRAGMENT_TITLE_TAG);

            if (fragmentTitle == null){
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frameLayout, new FragmentTitle(), FRAGMENT_TITLE_TAG);
                fragmentTransaction.commit();
            }
        }
       else {

          FragmentManager fragmentManager = getSupportFragmentManager();
          Fragment fragmentTitle = fragmentManager.findFragmentByTag(FRAGMENT_TITLE_TAG);

          if (fragmentTitle != null){

              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
              fragmentTransaction.remove(fragmentTitle);
             fragmentTransaction.commit();
          }
        }
    }
}
