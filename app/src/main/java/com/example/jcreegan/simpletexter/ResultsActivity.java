package com.example.jcreegan.simpletexter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class ResultsActivity extends ActionBarActivity {

    private Spinner spinner;
    private String smsBody = "";
    EditText txtCustomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        txtCustomText = (EditText) findViewById(R.id.txtCustom);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                position = spinner.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {
                    case 1:
                        smsBody = "Hey";
                        break;
                    case 2:
                        smsBody = "How's it going?";
                        break;
                    case 3:
                        smsBody = "I'm late for work";
                        break;
                    case 4:
                        smsBody = "On my way home";
                        break;
                    case 5:
                        smsBody = "Goodbye";
                        break;

                }
                if (intent != null) {
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // do nothing here
            }
        });
    }
    public void onClickCustomText(View v) {

        Intent receiverIntent = getIntent();
        String receiver = receiverIntent.getExtras().getString("receiver");

        if(txtCustomText.toString() != ""){
            smsBody = txtCustomText.toString();
        }

        if (receiver == "Matt") {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:2185668525"));
            sendIntent.putExtra("sms_body", smsBody);
            startActivity(sendIntent);
        }
        if (receiver == "Brian") {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:5073514565"));
            sendIntent.putExtra("sms_body", smsBody);
            startActivity(sendIntent);
        }
        if (receiver == "Mary") {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:5073514901"));
            sendIntent.putExtra("sms_body", smsBody);
            startActivity(sendIntent);
        }

        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);


    }


}
