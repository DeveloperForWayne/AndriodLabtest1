/* -----------------------------------
 * Put your student name and ID here
 * ----------------------------------- */
package com.example.rydeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences prefs;

    public static final String PREFERENCES_NAME = "UserLoginInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        // Get saved username and password
        String username = prefs.getString("username", "");
        if(!username.equals("")) {
            EditText txtUsername = (EditText) findViewById(R.id.username);
            txtUsername.setText(username);
        }

        String password = prefs.getString("password", "");
        if(!password.equals("")) {
            EditText txtPassword = (EditText) findViewById(R.id.password);
            txtPassword.setText(password);
        }

    }

    public void SignOrLogin(View view) {
        ArrayList<User> userArrayList = new ArrayList<User>();
        userArrayList.add(new User("peter", "0000", "4165551111"));

        String phnum="";
        Boolean existed=false;
        Boolean errorExisted = false;

        EditText txtUsername = (EditText) findViewById(R.id.username);
        String Username = txtUsername.getText().toString();

        EditText txtPassword = (EditText) findViewById(R.id.password);
        String Password = txtPassword.getText().toString();

        EditText txtPhoneNum = (EditText) findViewById(R.id.phoneNumber);
        String PhoneNumber = txtPhoneNum.getText().toString();

        TextView errorMessage = (TextView) findViewById(R.id.errorMessage);

        if(Username.equals("") || Password.equals("") || PhoneNumber.equals("")) {
            errorMessage.setText("All field must be filled");
            errorExisted = true;
        } else {
            for(int i=0; i< userArrayList.size(); i++) {
                User user=userArrayList.get(i);
                if(user.getUsername().equals(Username)) {
                    existed = true;
                    // Username and password are correct
                    if(user.getPassword().equals(Password)) {
                        phnum = user.getPhoneNumber();

                        CheckBox rememberCB = (CheckBox)findViewById(R.id.rememberCheck);
                        // if remember me is checked, store the user and password
                        if(rememberCB.isChecked()) {
                            SharedPreferences.Editor prefsEditor = prefs.edit();
                            prefsEditor.putString("username", Username);
                            prefsEditor.putString("password", Password);
                            prefsEditor.apply();
                        }

                    } else {
                        errorMessage.setText("Username is existed and password is wrong");
                        errorExisted = true;
                    }
                }
            }

            // User does not exist, create new user
            if(!existed) {
                User newUser = new User(Username, Password, phnum);
                userArrayList.add(newUser);
                PhoneNumber = phnum;
            }

            // Error does not exist, send parameter to main activity
            if(!errorExisted) {
                Intent mainIntent = new Intent(this, MainActivity.class);

                Bundle intentBundle = new Bundle();
                intentBundle.putString("username", Username);
                intentBundle.putString("phoneNumber", PhoneNumber);

                mainIntent.putExtras(intentBundle);

                startActivity(mainIntent);
            }

        }


    }
}
