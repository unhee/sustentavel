package com.example.unhee.sustentavel.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.unhee.sustentavel.MainActivity;
import com.example.unhee.sustentavel.R;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToHistorico(View view) {
        Intent myIntent = new Intent(this, HistoricoPageActivity.class);
        startActivity(myIntent);
    }


    public void goToEquipamentos(View view) {
        Intent myIntent = new Intent(this, EquipamentoPageActivity.class);
        startActivity(myIntent);
    }
}
