package com.example.casualearningsv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_calculator, R.id.navigation_jobs)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void stopTransition (View v) {
        Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
        MainActivity.this.startActivity(myIntent);
    }


    public void calcClick (View v) {
        EditText rate;
        EditText hours;
        TextView txv;

        double result;


        rate = findViewById(R.id.rateEditBox);
        String rateValue = rate.getText().toString();

        hours = findViewById(R.id.hoursEditBox);
        String hoursValue = hours.getText().toString();

        if (rateValue.matches("") || hoursValue.matches("")) {
            Toast.makeText(getApplicationContext(),"Please enter appropriate values",
                Toast.LENGTH_SHORT).show();
        } else if (!(rateValue.matches("") || hoursValue.matches(""))){
            double rateDouble = Double.parseDouble(rateValue);
            double hoursDouble = Double.parseDouble(hoursValue);
            txv = findViewById(R.id.resultView);
            result = rateDouble * hoursDouble;

            String resultString;
            resultString = Double.toString(result);
            txv.setText(resultString);
        }
    }

}
