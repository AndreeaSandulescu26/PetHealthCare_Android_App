package com.example.pethealthcare;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PetActivity extends AppCompatActivity {


    ArrayList<Object> arrPets = new ArrayList<>();
    RecyclerPetAdapter adapter;
    FloatingActionButton btnOpenDialog;
    RecyclerView recyclerView;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        recyclerView = findViewById(R.id.recyclerPet);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PetActivity.this, HomeActivity.class));
            }
        });


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(PetActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtSpecies = dialog.findViewById(R.id.edtSpecies);
                EditText edtBreed = dialog.findViewById(R.id.edtBreed);
                EditText edtAge = dialog.findViewById(R.id.edtAge);
                EditText edtGender = dialog.findViewById(R.id.edtGender);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", species = "", breed = "", age = "", gender = "";
                        if (edtName.getText().toString().equals("") || edtSpecies.getText().toString().equals("") || edtBreed.getText().toString().equals("") || edtAge.getText().toString().equals("") || edtGender.getText().toString().equals("")) {
                            Toast.makeText(PetActivity.this, "Please Fill All The Details!", Toast.LENGTH_SHORT).show();
                        } else {
                            name = edtName.getText().toString();
                            species = edtSpecies.getText().toString();
                            breed = edtBreed.getText().toString();
                            age = edtAge.getText().toString();
                            gender = edtGender.getText().toString();
                        }

                        arrPets.add(new PetModel(R.drawable.pets, name, species, breed, age, gender));

                        adapter.notifyItemInserted(arrPets.size()-1);

                        recyclerView.scrollToPosition(arrPets.size()-1);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


//        arrPets.add(new PetModel(R.drawable.pets, "Rici", "dog", "Chihuahua", "10", "M"));
//        arrPets.add(new PetModel(R.drawable.pets, "Mado", "cat", "British", "5", "F"));
//        arrPets.add(new PetModel(R.drawable.pets, "Hugo", "cat", "Persan", "3", "M"));
//        arrPets.add(new PetModel(R.drawable.pets, "Zeus", "dog", "Beagle", "2", "M"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerPetAdapter(this, arrPets);
        recyclerView.setAdapter(adapter);

    }
}













































//        // Inițializarea elementelor UI
//        etName = findViewById(R.id.et_name);
//        etSpecies = findViewById(R.id.et_species);
//        etAge = findViewById(R.id.et_age);
//        etGender = findViewById(R.id.et_gender);
//        etBreed = findViewById(R.id.et_breed);
//
//        btnAddPet = findViewById(R.id.btn_add_pet);
//        btnDeletePet = findViewById(R.id.btn_delete_pet);
//        btnUpdatePet = findViewById(R.id.btn_update_pet);
//
//        // Inițializarea obiectului de bază de date
//        database = new Database(this, "pethealthcare", null, 1);
//
//        // Setarea acțiunii butonului "Adăugare animal"
//        btnAddPet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = etName.getText().toString();
//                String species = etSpecies.getText().toString();
//                String age = etAge.getText().toString();
//                String gender = etGender.getText().toString();
//                String breed = etBreed.getText().toString();
//
//                if (name.isEmpty() || species.isEmpty() || age.isEmpty() || gender.isEmpty() || breed.isEmpty()) {
//                    Toast.makeText(PetActivity.this, "Please fill all the details!", Toast.LENGTH_SHORT).show();
//                } else {
//                    addPet(name, species, Integer.parseInt(age), gender, breed);
//                    clearFields();
//                }
//            }
//        });
//
//        // Setarea acțiunii butonului "Ștergere animal"
//        btnDeletePet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = etName.getText().toString();
//                if (name.isEmpty()) {
//                    Toast.makeText(PetActivity.this, "Enter pet name", Toast.LENGTH_SHORT).show();
//                } else {
//                    deletePet(name);
//                    clearFields();
//                }
//            }
//        });
//
//        // Setarea acțiunii butonului "Modificare animal"
//        btnUpdatePet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = etName.getText().toString();
//                String species = etSpecies.getText().toString();
//                int age = Integer.parseInt(etAge.getText().toString());
//                String gender = etGender.getText().toString();
//                String breed = etBreed.getText().toString();
//
//
//                if (name.isEmpty() || species.isEmpty() || String.valueOf(age).isEmpty() || gender.isEmpty() || breed.isEmpty()) {
//                    Toast.makeText(PetActivity.this, "Please fill all the details!", Toast.LENGTH_SHORT).show();
//                } else {
//                    updatePet(id, name, species, age, gender, breed);
//                    clearFields();
//                }
//            }
//        });
//    }
//
//    private void addPet(String name, String species, int age, String gender, String breed) {
//        database.addPet(name, species, age, gender, breed);
//        Toast.makeText(this, "Pet added!", Toast.LENGTH_SHORT).show();
//    }
//
//    private void deletePet(String name) {
//        database.deletePet(Integer.parseInt(name));
//        Toast.makeText(this, "Pet deleted!", Toast.LENGTH_SHORT).show();
//    }
//
//    private void updatePet(int id, String name, String species, int age, String gender, String breed) {
//        database.updatePet(id, name, species, age, gender, breed);
//        Toast.makeText(this, "The pet details are updated!", Toast.LENGTH_SHORT).show();
//    }
//
//    private void clearFields() {
//        etName.setText("");
//        etSpecies.setText("");
//        etAge.setText("");
//        etGender.setText("");
//        etBreed.setText("");
//    }