package io.github.seibelsabrina.shelterme;

/**
 * Created by Tanya on 2/20/18.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText regUsername;
    EditText passwordEnter;
    EditText confirmPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void next(View view) {
//        Intent intent = new Intent(this, )
//    }

    public void checkUP(View view) {
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        regUsername = (EditText) findViewById(R.id.regUsername);
        passwordEnter = (EditText) findViewById(R.id.passwordEnter);
        confirmPW = (EditText) findViewById(R.id.confirmPW);
        String name = String.valueOf(firstName.getText()) + ' ' + String.valueOf(lastName.getText());
        String username = String.valueOf(regUsername.getText());
        if (passwordEnter.equals(confirmPW)) {
            String password = String.valueOf((passwordEnter.getText()));
        } else {
            AlertDialog.Builder difPasswords = new AlertDialog.Builder(this);
            difPasswords.setMessage("Passwords don't match");
            difPasswords.setTitle("Error");
            difPasswords.setPositiveButton("OK", null);
            difPasswords.setCancelable(true);
            difPasswords.create().show();

            difPasswords.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
        }

    }
}
