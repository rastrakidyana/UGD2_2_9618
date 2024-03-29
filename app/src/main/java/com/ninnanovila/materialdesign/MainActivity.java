package com.ninnanovila.materialdesign;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Receipt receipt = new Receipt();
    private List<String> checked = new ArrayList<>();

    private ReceiptRecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Receipt[] receipts = receipt.getAllReceipt();
        recyclerViewAdapter = new ReceiptRecyclerViewAdapter(receipts, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_receipt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

        MaterialButton checkedFloatBtn = findViewById(R.id.checked_fab);
        checkedFloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 4.1(2,5)
                //Melakukan inisialisasi "checked" yang didapat dari fungsi yang berada pada recyclerViewAdapter
                checked = recyclerViewAdapter.getTitle_checked();

                if (checked.isEmpty()){
                    Toast.makeText(v.getContext(), "Just check, please!", Toast.LENGTH_SHORT).show();
                }else {
                    //TODO 4.4(2,5)
                    //Fungsi menampilkan dialog dipanggil disini
                    simple_dialog();
                }
            }
        });
    }

    //TODO 4.2(10)
    //Menampilkan simple dialog yang menampilkan title receipt yang checked
    public void simple_dialog(){
        final CharSequence[] item = getStringArray(checked);
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Checked Receipts").setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        ad.show();
    }

    //TODO 4.3(5)
    //Apa maksud fungsi ini ? (2 kalimat)
    //Jawaban : untuk menampung hasil checked ke dalam array. kemudian fungsi tersebut
    //          digunakan untuk menampilkan pada saat menekan show checked.
    //
    //
    public static String[] getStringArray(List<String> input) {
        String[] strings = new String[input.size()];

        for (int j = 0; j < input.size(); j++) {
            strings[j] = input.get(j);
        }

        return strings;
    }

}