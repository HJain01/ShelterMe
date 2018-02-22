package io.github.seibelsabrina.shelterme;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.github.seibelsabrina.shelterme.Model.*;

public class LoginActivity extends AppCompatActivity {

    EditText usernameBox;
    EditText passwordBox;

    private Model instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        instance = Model.getInstance();
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

        if (instance.getUsers().containsKey(username)) {
            User temp =  (User) instance.getUsers().get(username);
            String tempPass = temp.getpassWord();
            if(tempPass.equals(password)){
                Intent intent = new Intent(this, LoggedInActivity.class);
                startActivity(intent);}
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
