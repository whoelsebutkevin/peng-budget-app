package com.dynasty.pengchen.budgetapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private Bank mBank;

    private TextView textView2;

    private final String FILENAME = "account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBank = new Bank();
        FileInputStream inputStream;
        try {
            inputStream  = openFileInput(FILENAME);
            StringBuffer fileContent = new StringBuffer("");
            byte[] buffer = new byte[1024];
            int n;
            while ((n = inputStream.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }
            String balance = fileContent.toString();
            mBank.deposit(Double.parseDouble(balance));
        } catch (Exception e) {
            e.printStackTrace();
        }

        textView2 = findViewById(R.id.textView2);
        textView2.setText(mBank.getBalance());

        Button button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDepositDialog();
            }
        });
    }

    private void showDepositDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        mBank.deposit(1);
                        textView2.setText(mBank.getBalance());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        mBank.deposit(-1);
                        textView2.setText(mBank.getBalance());
                    }
                });
        builder.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(FILENAME, MODE_PRIVATE);
            outputStream.write(mBank.getBalance().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
