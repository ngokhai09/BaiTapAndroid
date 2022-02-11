package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> lstContact;
    MyAdapter lstContactAdapter;
    ListView listView;
    Button btnAdd;
    Button btnDel;

    EditText txtName;
    EditText txtPhone;
    AlertDialog.Builder dlgAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        btnAdd = findViewById(R.id.btnAdd);
        btnDel = findViewById(R.id.btnDel);
        dlgAlert  = new AlertDialog.Builder(this);
        lstContact = new ArrayList<>();
        lstContact.add(new Contact(1, "Mot", "34567"));
        lstContact.add(new Contact(2, "Hai", "45678"));
        lstContact.add(new Contact(3, "Ba", "56789"));
        lstContactAdapter = new MyAdapter(this, lstContact);
        listView = findViewById(R.id.listView);
        listView.setAdapter(lstContactAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validate = Validate(txtName.getText().toString(), txtPhone.getText().toString());
                if( validate == ""){
                    lstContact.add(new Contact((int)lstContactAdapter.getItemId(lstContactAdapter.getCount() -1) + 1, txtName.getText().toString(), txtPhone.getText().toString())) ;
                    lstContactAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, validate, Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < lstContact.size(); i++) {
                    if(lstContact.get(i).isStatus() == true){
                        lstContact.remove(lstContact.get(i));
                    }
                }

                dlgAlert.setMessage("Bạn có chắc chắn xóa không?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                lstContactAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = dlgAlert.create();
                alert.show();

            }
        });
    }

    private String Validate(String name, String phone){
        if(name.equals("")){
            return "Name is required";
        }
        if(phone.equals("")){
            return "Phone is required";
        }
        try {
            int d = Integer.parseInt(phone);
        }catch (NumberFormatException e) {
            return "Phone must is number";
        }
        return "";
    }
}