package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sendText extends AppCompatActivity {

    final int SEND_SMS_PERMSSION_REQUEST_CODE = 1;
    Button nButtonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text);

        nButtonSend = (Button)findViewById(R.id.buttonSend);
        nButtonSend.setEnabled(false);
        if(checkPermission(Manifest.permission.SEND_SMS)){
            nButtonSend.setEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    { Manifest.permission.SEND_SMS },
                    SEND_SMS_PERMSSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission(String permission){
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
        return (permissionCheck == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int [] grantResults){
        switch(requestCode) {
            case SEND_SMS_PERMSSION_REQUEST_CODE: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    nButtonSend.setEnabled(true);
                }
                return;
            }
        }
    }

    public void send(View view){
        String phoneNumber = ((EditText) findViewById(R.id.editTextNumber)).getText().toString();
        String msg = ((EditText) findViewById(R.id.editTextMsg)).getText().toString();

        if(phoneNumber==null || phoneNumber.length() == 0 || msg == null || msg.length() == 0){
            return;
        }

        if (checkPermission(Manifest.permission.SEND_SMS)) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msg, null,null);
            Toast.makeText(sendText.this, "Your message has been sent", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(sendText.this, "No permission", Toast.LENGTH_SHORT).show();
        }
    }
}
