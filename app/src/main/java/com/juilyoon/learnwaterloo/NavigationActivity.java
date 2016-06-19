package com.juilyoon.learnwaterloo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {
    public final static String EXTRA_FILE = "com.juilyoon.learnwaterloo.file";
    public final static String EXTRA_TITLE = "com.juilyoon.learnwaterloo.title";

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
        String title = getString(R.string.app_name);
        switch (view.getId()) {
            case R.id.section1:
                file = R.raw.section1;
                title = getString(R.string.section1_title);
                break;
            case R.id.section2:
                file = R.raw.section2;
                title = getString(R.string.section2_title);
                break;
            case R.id.section3:
                file = R.raw.section3;
                title = getString(R.string.section3_title);
                break;
            case R.id.section4:
                file = R.raw.section4;
                title = getString(R.string.section4_title);
                break;
            case R.id.section5:
                file = R.raw.section5;
                title = getString(R.string.section5_title);
                break;
        }
        section.putExtra(EXTRA_FILE, file);
        section.putExtra(EXTRA_TITLE, title);
        Log.v("NavigationActivity", "Opening file " + file);
        startActivity(section);
    }

}
