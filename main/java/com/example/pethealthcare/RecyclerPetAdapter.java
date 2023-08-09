package com.example.pethealthcare;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
public class RecyclerPetAdapter extends RecyclerView.Adapter<RecyclerPetAdapter.ViewHolder> {

    Context context;
    ArrayList<Object> arrPets;

    public RecyclerPetAdapter(Context context, ArrayList<Object> arrPets) {
        this.context = context;
        this.arrPets = arrPets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pet_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PetModel model = (PetModel) arrPets.get(position);
        holder.imgPets.setImageResource(model.img);
        holder.txtName.setText(model.name);
        holder.txtSpecies.setText(model.species);
        holder.txtBreed.setText(model.breed);
        holder.txtAge.setText(model.age);
        holder.txtGender.setText(model.gender);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtSpecies = dialog.findViewById(R.id.edtSpecies);
                EditText edtBreed = dialog.findViewById(R.id.edtBreed);
                EditText edtAge = dialog.findViewById(R.id.edtAge);
                EditText edtGender = dialog.findViewById(R.id.edtGender);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                txtTitle.setText("Update Pet");

                btnAction.setText("Update");

                edtName.setText(((PetModel) arrPets.get(position)).name);
                edtSpecies.setText(((PetModel) arrPets.get(position)).species);
                edtBreed.setText(((PetModel) arrPets.get(position)).breed);
                edtAge.setText(((PetModel) arrPets.get(position)).age);
                edtGender.setText(((PetModel) arrPets.get(position)).gender);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", species = "", breed = "", age = "", gender = "";
                        if (edtName.getText().toString().equals("") || edtSpecies.getText().toString().equals("") || edtBreed.getText().toString().equals("") || edtAge.getText().toString().equals("") || edtGender.getText().toString().equals("")) {
                            Toast.makeText(context, "Please Fill All The Details!", Toast.LENGTH_SHORT).show();
                        } else {
                            name = edtName.getText().toString();
                            species = edtSpecies.getText().toString();
                            breed = edtBreed.getText().toString();
                            age = edtAge.getText().toString();
                            gender = edtGender.getText().toString();
                        }

                        arrPets.set(position, new PetModel(((PetModel) arrPets.get(position)).img, name, species, breed, age, gender));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Pet")
                        .setMessage("Are you sure you want to delete?")
                        .setIcon(R.drawable.trash)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrPets.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                builder.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrPets.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtSpecies, txtBreed, txtAge, txtGender;
        ImageView imgPets;
        LinearLayout llRow;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtSpecies = itemView.findViewById(R.id.txtSpecies);
            txtBreed = itemView.findViewById(R.id.txtBreed);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtGender = itemView.findViewById(R.id.txtGender);
            imgPets = itemView.findViewById(R.id.imgPets);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }

}
