package com.example.renjf.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.*;

public class RegisterActivity extends AppCompatActivity {

    private Button mRegisterButton;
    private EditText mNameText;
    private EditText mEmailText;
    private EditText mPasswordText;
    private TextView mResultText;
    private User newUser;

    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUI();

        getUIdata();



    }



    private void initUI(){
        mRegisterButton = (Button) findViewById(R.id.registerSubmit);
    }

    private void getUIdata(){

        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mNameText = (EditText)findViewById(R.id.nameText);
                mEmailText = (EditText)findViewById(R.id.emailText);
                mPasswordText = (EditText)findViewById(R.id.passwordText);
                String userName = mNameText.getText().toString();
                String uscEmail = mEmailText.getText().toString();
                String password = mPasswordText.getText().toString();
                createUser(userName,uscEmail,password);
                mResultText = (TextView) findViewById(R.id.showResult);
                mResultText.setText("Register Successfully");

                connectFirebase();

            }
        });

    }




    private void connectFirebase(){
        String username = newUser.getUserName();
        String email = newUser.getUscEmail();
        String password = newUser.getPassword();


        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase.child("users").child("200").child("mUserName").setValue(username);
        //mDatabase.child("users").child("200").child("mUscEmail").setValue(email);
        //mDatabase.child("users").child("200").child("mPassword").setValue(password);
        mDatabase.child("users").child("202").setValue(newUser);
    }


    private void createUser(String userName, String uscEmail, String password){
        newUser = new User(userName,uscEmail,password);
        //newUser.setUserName(userName);
        //newUser.setUscEmail(uscEmail);
        //newUser.setPassword(password);

    }




}
