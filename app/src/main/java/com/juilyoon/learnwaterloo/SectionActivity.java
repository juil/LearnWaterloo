package com.juilyoon.learnwaterloo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.commonmark.html.HtmlRenderer;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);


//        File file = file;

        Parser parser = Parser.builder().build();
        Node document = parser.parse("# Section Test");
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        Intent intent = getIntent();
        int fileId = intent.getIntExtra(NavigationActivity.EXTRA_FILE, R.raw.error);

        TextView body = new TextView(this);
        body.setText(Html.fromHtml(renderer.render(document)));

        ScrollView scrollView = (ScrollView) findViewById(R.id.mainScroll_view);
        scrollView.addView(body);
        Log.v("SectionAcitivity", "Trying to open file " + intent.getIntExtra(NavigationActivity.EXTRA_FILE, R.raw.error));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, NavigationActivity.class));
        this.finish();
    }

//    private String readRawFile(Context ctx, int resId) {
//        InputStream inputStream = ctx.getResources().openRawResource(fileId);
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        return "Testing";
//    }

}
