package com.example.listview;

import static com.example.listview.R.string.difference_or_multiplier;
import static com.example.listview.R.string.first_organ;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public abstract class Show_series extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent gi;
    TextView x_tv, d_tv, n_tv, sn_tv;
    ListView lv;
    String[] series;
    int first_organ, differenceMultiplier;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_series);

        gi = getIntent();
        x_tv = findViewById(R.id.X_tv);
        d_tv = findViewById(R.id.d_tv);
        n_tv = findViewById(R.id.n_tv);
        sn_tv = findViewById(R.id.Sn_tv);
        lv = findViewById(R.id.List_View);

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);

        series = gi.getStringArrayExtra("series");
        first_organ = gi.getIntExtra("firstOrgan",1);
        differenceMultiplier = gi.getIntExtra("differenceOrMultiplier", 1);
        finish();


        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, series);
        lv.setAdapter(adp);
    }

    public int sum(int position){
        int sum = 0;
        for (int i = 0; i < position; i++){
            sum += Integer.parseInt(series[i]);
        }
        return sum;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        x_tv.setText(first_organ);
        d_tv.setText(differenceMultiplier);
        n_tv.setText(series[position]);
        sn_tv.setText(sum(position));
    }
}