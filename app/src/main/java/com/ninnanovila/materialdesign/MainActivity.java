package com.ninnanovila.materialdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
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
                //TODO
                //Melakukan inisialisasi "checked" yang didapat dari fungsi yang berada pada recyclerViewAdapter
                //checked = recyclerViewAdapter. ....
                if (checked.isEmpty()){
                    Toast.makeText(v.getContext(), "Just check, please!", Toast.LENGTH_SHORT).show();
                }else {
                    //TODO
                    //Fungsi menampilkan dialog dipanggil disini
                }
            }
        });
    }

    //TODO
    //Menampilkan simple dialog yang menampilkan title receipt yang checked

    //TODO
    //Apa maksud fungsi ini ? (2 kalimat)
    //Jawaban :
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