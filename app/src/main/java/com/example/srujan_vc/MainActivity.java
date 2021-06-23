  package com.example.srujan_vc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

  public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Welcome to SRUJAN'S VIDEO CALL", Toast.LENGTH_LONG).show();
        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL("")) // if we have any we add our own url
                    .setRoom("srujan123")
                    .setWelcomePageEnabled(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
      public void onButtonClick(View v) {
          EditText editText = findViewById(R.id.ROOM_NUMBER);
          String text = editText.getText().toString();
          if (text.length() > 0) {
              JitsiMeetConferenceOptions options
                      = new JitsiMeetConferenceOptions.Builder()
                      .setRoom(text)
                      .build();
              JitsiMeetActivity.launch(this, options);
          }
      }
}