package com.juilyoon.learnwaterloo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {

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
        switch (view.getId()) {
            case R.id.section1:
                Intent section = new Intent(this, SectionActivity.class);
                startActivity(section);
        }
    }

}
