package com.example.shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText eD1;
    TextView tv1;

    int count = 0;
    String str_data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weddings();
        tv1.setText(count +"");
        read_data();
    }


    public void weddings()
    {
        eD1 = (EditText) findViewById(R.id.eD1);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void read_data()
    {
        SharedPreferences settings = getSharedPreferences("Data_fill",MODE_PRIVATE);
        str_data = settings.getString("strData","NULL");
        count = settings.getInt("intCount",-999);
        eD1.setText(str_data);
        tv1.setText(count + "");
    }

    public void write_data()
    {
        SharedPreferences settings = getSharedPreferences("Data_fill",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("strData", eD1.getText().toString());
        editor.putInt("intCount", count);
        editor.commit();
    }


    public void btn1_count(View view)
    {
        count++;
        tv1.setText(count +"");

    }

    public void btn2_reset(View view)
    {
        count = 0;
        tv1.setText(count +"");

    }

    public void btn3_exit(View view)
    {
        write_data();
        Toast.makeText(getApplicationContext(), "Write Data", Toast.LENGTH_SHORT).show();
        finish();
    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.it2)
        {
            Intent si = new Intent(this, MainActivity2.class);
            startActivity(si);
        }
        return true;
    }
}