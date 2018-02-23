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
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import io.github.seibelsabrina.shelterme.Model.Admin;
import io.github.seibelsabrina.shelterme.Model.Model;
import io.github.seibelsabrina.shelterme.Model.User;


public class RegisterActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText regUsername;
    EditText passwordEnter;
    EditText confirmPW;


    private User _user;
    private Admin _admin;
    private CheckBox userBox;
    private CheckBox adminBox;
    private Map users;
    private Model instance;
    private FirebaseAuth mAuth;
    private Map admin;

    final FirebaseDatabase userDatabase = FirebaseDatabase.getInstance();
    DatabaseReference ref = userDatabase.getReference("users-database-720ef");

    final FirebaseDatabase adminDatabase = FirebaseDatabase.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //firebase app listener - establish connection here

        mAuth = FirebaseAuth.getInstance();
        instance = Model.getInstance();
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//
//        // gets current user
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            Intent intent = new Intent(this, LoginSuccessful.class);
//            startActivity(intent);
//        } else {
//            AlertDialog.Builder wrong = new AlertDialog.Builder(this);
//            wrong.setMessage("Wrong username or password");
//            wrong.setTitle("Error");
//            wrong.setPositiveButton("OK", null);
//            wrong.setCancelable(true);
//            wrong.create().show();
//
//            wrong.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            });
//        }
//    }

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

//    public void onAddPressed(View view) {
//        _user.setfirstName(firstName.getText().toString());
//        _user.setlastName(lastName.getText().toString());
//        _user.setuserName(regUsername.getText().toString());
//        _user.setpassWord(passwordEnter.getText().toString());
//
//    }

    public void onCheckboxClicked(View view) {

        // Is the view now checked?

        CheckBox checkedUser = findViewById(R.id.UserBox);
        CheckBox checkedAdmin = findViewById(R.id.AdminBox);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        regUsername = findViewById(R.id.regUsername);
        passwordEnter = findViewById(R.id.passwordEnter);
        confirmPW = findViewById(R.id.confirmPW);
        _user = new User();
        _admin = new Admin();
        // Check which checkbox was clicked
        if (checkedUser.isChecked()) {
            _user.setfirstName(firstName.getText().toString());
            _user.setlastName(lastName.getText().toString());
            _user.setuserName(regUsername.getText().toString());
            _user.setpassWord(passwordEnter.getText().toString());
            instance.getUsers().put(_user.getuserName(), _user);
            Intent intent = new Intent(this, LoggedInActivity.class);
            startActivity(intent);
        }
        if (checkedAdmin.isChecked()) {
            _admin.setfirstName(firstName.getText().toString());
            _admin.setlastName(lastName.getText().toString());
            _admin.setuserName(regUsername.getText().toString());
            _admin.setpassWord(passwordEnter.getText().toString());
            instance.getAdmins().put(_admin.getuserName(), _admin);
            Intent intent = new Intent(this, LoggedInActivity.class);
            startActivity(intent);
        }
    }

    DatabaseReference usersRef = ref.child("users");
//    Map<String, String> users = new HashMap<>();


    //DatabaseReference adminRef = ref.child("admin");
}

