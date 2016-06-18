package com.juilyoon.learnwaterloo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {
    public final static String EXTRA_FILE = "com.juilyoon.learnwaterloo.file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    /**
     * goToSection() loads the appropriate section
     */
    public void goToSection(View view) {
        setContentView(R.layout.activity_section);
        Intent section = new Intent(this, SectionActivity.class);
        int file = 0;
        switch (view.getId()) {
            case R.id.section1:
                file = R.raw.section1;
                break;
            case R.id.section2:
                file = R.raw.section2;
                break;
            case R.id.section3:
                file = R.raw.section3;
                break;
            case R.id.section4:
                file = R.raw.section4;
                break;
            case R.id.section5:
                file = R.raw.section5;
                break;
        }
        section.putExtra(EXTRA_FILE, file);
        Log.v("NavigationActivity", "Opening file " + file);
        startActivity(section);
    }

}
