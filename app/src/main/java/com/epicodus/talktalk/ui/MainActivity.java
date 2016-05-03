package com.epicodus.talktalk.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.talktalk.Constants;
import com.epicodus.talktalk.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Firebase mMessageRef;
    private ValueEventListener mMessageRefListener;
    @Bind(R.id.displayButton)
    Button mDisplayButton;
    @Bind(R.id.messageText)
    EditText mMessageText;
    @Bind(R.id.saveButton) Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSaveButton.setOnClickListener(this);
        mMessageRef = new Firebase(Constants.FIREBASE_URL_MESSAGE);

        mMessageRefListener = mMessageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String messages = dataSnapshot.getValue().toString();
                Log.d("Message saved", messages);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMessageRef.removeEventListener(mMessageRefListener);
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveButton) {
            String message = mMessageText.getText().toString();
            saveMessageToFirebase(message);
            Intent intent = new Intent(MainActivity.this, MessagesActivity.class);
            intent.putExtra("message", message);
            startActivity(intent);
        }
    }

    public void saveMessageToFirebase(String message) {
        Firebase messageRef = new Firebase(Constants.FIREBASE_URL_MESSAGE);
        messageRef.push().setValue(message);
    }
}
