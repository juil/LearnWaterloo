package com.juilyoon.learnwaterloo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Section extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        TextView body = (TextView) findViewById(R.id.body);
        body.setText(Html.fromHtml("<h1>Section 1</h1>"));
    }
}
