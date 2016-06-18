package com.juilyoon.learnwaterloo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.commonmark.html.HtmlRenderer;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        // Get file ID
        Intent intent = getIntent();
        int fileId = intent.getIntExtra(NavigationActivity.EXTRA_FILE, R.raw.error);

        // Parse markdown document
        Parser parser = Parser.builder().build();
        Node document = parser.parse(readRawFile(this, fileId));
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        // Set text
        TextView body = new TextView(this);
        body.setText(Html.fromHtml(renderer.render(document)));

        ScrollView scrollView = (ScrollView) findViewById(R.id.mainScroll_view);
        scrollView.addView(body);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, NavigationActivity.class));
        this.finish();
    }

    /**
     * readRawFile() takes a resource ID and returns the raw text within it
     *
     * Taken from http://stackoverflow.com/questions/4087674/android-read-text-raw-resource-file
     *
     * @param ctx Context
     * @param resId @raw resource ID passed in as an extra when SectionAcitivity is called
     *
     * @return Raw text from file
     */
    private String readRawFile(Context ctx, int resId) {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while(( line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        }
        catch (IOException e) {
            return null;
        }
        return text.toString();
    }

}
