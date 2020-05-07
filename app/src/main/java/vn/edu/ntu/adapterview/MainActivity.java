package vn.edu.ntu.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView show;
    ListView TinhThanh;
    Spinner spinner;
    String[] arrayTinhThanh;
    String[] arrayNgay;
    ArrayAdapter<String> adatertinhthanh;
    ArrayAdapter<String> adaterdate;
    AutoCompleteTextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }


    private void addViews(){
        TinhThanh = findViewById(R.id.tinhthanh);
        spinner = findViewById(R.id.date);
        arrayTinhThanh = getResources().getStringArray(R.array.tinh_thanh);
        adatertinhthanh = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arrayTinhThanh);
        TinhThanh.setAdapter(adatertinhthanh);
        arrayNgay = getResources().getStringArray(R.array.numbers);
        adaterdate = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arrayNgay);
        spinner.setAdapter(adaterdate);

        text = findViewById(R.id.autoCompleteTextView);
        text.setAdapter(adatertinhthanh);


        show = findViewById(R.id.show_date);
    }
    private void addEvents(){
        TinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String message = adatertinhthanh.getItem(position);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + message, Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String message = adaterdate.getItem(position);
                show.setText(message);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
