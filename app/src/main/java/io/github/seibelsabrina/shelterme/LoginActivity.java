package io.github.seibelsabrina.shelterme;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText usernameBox;
    EditText passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void checkUP(View view) {
        usernameBox = (EditText) findViewById(R.id.usernameBox);
        passwordBox = (EditText) findViewById(R.id.passwordBox);
        String username = String.valueOf(usernameBox.getText());
        String password = String.valueOf(passwordBox.getText());

        if (username.equals("user") && password.equals("pass")) {
            Intent intent = new Intent(this, LoggedInActivity.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder wrong = new AlertDialog.Builder(this);
            wrong.setMessage("Wrong username or password");
            wrong.setTitle("Error");
            wrong.setPositiveButton("OK", null);
            wrong.setCancelable(true);
            wrong.create().show();

            wrong.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
        }
    }

}
