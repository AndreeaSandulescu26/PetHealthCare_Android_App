package com.example.pethealthcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InfoUserActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3;
    TextView tv;
    Button btnBack, btnModify;
    AlertDialog modifyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);

        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextMIFullName);
        ed2 = findViewById(R.id.editTextMIEmail);
        ed3 = findViewById(R.id.editTextMIPassword);
        btnBack = findViewById(R.id.buttonMIBack);
        btnModify = findViewById(R.id.buttonMIModify);

        Database db = new Database(getApplicationContext(), "pethealthcare", null,1);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "");
        String email = db.getEmail(username);
        String password = db.getPassword(username);

        ed1.setText("Username: " + username);
        ed2.setText("Email: " + email);
        ed3.setText("Password: " + password);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InfoUserActivity.this, HomeActivity.class));
            }
        });

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showModifyDialog();
            }
        });
    }

    private void showModifyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit your username and password");

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_modify_user, null);
        builder.setView(dialogView);

        EditText usernameEditText = dialogView.findViewById(R.id.editTextNewUsername);
        EditText passwordEditText = dialogView.findViewById(R.id.editTextNewPassword);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newUsername = usernameEditText.getText().toString().trim();
                String newPassword = passwordEditText.getText().toString().trim();

                if (newUsername.isEmpty() && newPassword.isEmpty()) {
                    Toast.makeText(InfoUserActivity.this, "No modification has been made", Toast.LENGTH_SHORT).show();
                } else if (newUsername.isEmpty()) {
                    Toast.makeText(InfoUserActivity.this, "Please enter a new username.", Toast.LENGTH_SHORT).show();
                } else if (newPassword.isEmpty()) {
                    Toast.makeText(InfoUserActivity.this, "Please enter a new password", Toast.LENGTH_SHORT).show();
                } else {
                    // Actualizați valorile în baza de date sau în stocarea de date corespunzătoare
                    // Exemplu de cod pentru actualizarea username-ului și parolei în baza de date
                    Database db = new Database(getApplicationContext(), "pethealthcare", null, 1);
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
                    String username = sharedPreferences.getString("username", "");
                    db.updateUsername(username, newUsername);
                    db.updatePassword(username, newPassword);

                    // Afișați un mesaj de succes utilizatorului
                    Toast.makeText(InfoUserActivity.this, "Modification successful!", Toast.LENGTH_SHORT).show();


                    // Actualizați valorile afișate în activitate
                    ed1.setText("Username: " + newUsername);
                    ed3.setText("Password: " + newPassword);
                }
            }
        });

        builder.setNegativeButton("Anulate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        modifyDialog = builder.create();
        modifyDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (modifyDialog != null && modifyDialog.isShowing()) {
            modifyDialog.dismiss();
        }
    }
}