package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] presidents = {
            "Dwight D. Eisenhower",
            "John F. Kennedy",
            "Lyndon B. Johnson",
            "Richard Nixon",
            "Gerald Ford",
            "Jimmy Carter",
            "Ronald Reagan",
            "George H. W. Bush",
            "Bill Clinton",
            "George W. Bush",
            "Barack Obama",
            "Donald J. Trump"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, presidents);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        textView.setThreshold(3);
        textView.setAdapter(adapter);
    }
    public void displayMessage(View view){

        EditText nameText = (EditText) findViewById(R.id.editText);
        String myName = nameText.getText().toString();

        final String displayString = "Hello " + myName + "\n" + "Welcome to COM413 ...";

        TextView displayText = (TextView) findViewById(R.id.textView2);
        displayText.setText(displayString);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

}
