package com.dynasty.pengchen.budgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Bank mBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBank = new Bank();

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DepositDialog dd = new DepositDialog();
                dd.show(getSupportFragmentManager(), "gfhgfhg");
            }
        });
    }
}
