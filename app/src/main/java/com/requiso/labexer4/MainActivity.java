package com.requiso.labexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] company, nationality, type, head;
    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan, R.drawable.chinaconstructionbank, R.drawable.agriculturalbank, R.drawable.bankofamerica, R.drawable.apple, R.drawable.pingan, R.drawable.bankofchina, R.drawable.shell, R.drawable.wellsfargo, R.drawable.exxon, R.drawable.at, R.drawable.samsungelectronics, R.drawable.citigroup};
    ArrayList<AndroidContent> contents = new ArrayList<>();
    ListView lstContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        company = getResources().getStringArray(R.array.companyName);
        nationality = getResources().getStringArray(R.array.country);
        type = getResources().getStringArray(R.array.industry);
        head = getResources().getStringArray(R.array.ceo);
        for(int i=0; i < company.length; i++) {
            contents.add(new AndroidContent(logo[i], company[i], nationality[i], type[i], head[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.content,contents);
        lstContents = findViewById(R.id.IvAndroid);
        lstContents.setAdapter(adapter);
        lstContents.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(company[i]);
        dialog.setMessage(nationality[i]);
        dialog.setMessage(type[i]);
        dialog.setMessage(head[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, company[i] , Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();


    }
}
