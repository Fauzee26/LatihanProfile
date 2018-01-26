package fauzi.hilmy.latihanprofile;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etEmail, etAlamat;
    Button btnSubmit, btnExit;
    Spinner spinSex, spinClass;
    TextView lblNama, lblEmail, lblAlamat, lblSex, lblClass;
    Context context = this;

    String itemSex, itemClass;

    String[] dataSex = new String[]{
            "Pria", "Wanita"
    };

    String[] dataClass = new String[]{
            "TKJ", "RPL", "Mesin"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText)findViewById(R.id.etNama);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etAlamat = (EditText)findViewById(R.id.etAlamat);
        spinClass = (Spinner) findViewById(R.id.spinClass);
        spinSex = (Spinner) findViewById(R.id.spinSex);
        btnExit = (Button)findViewById(R.id.btnExit);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        lblNama = (TextView)findViewById(R.id.lblNama);
        lblEmail = (TextView)findViewById(R.id.lblEmail);
        lblAlamat = (TextView)findViewById(R.id.lblAlamat);
        lblSex = (TextView)findViewById(R.id.lblSex);
        lblClass = (TextView)findViewById(R.id.lblClass);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataClass);
        spinClass.setAdapter(adapter);

        spinClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemClass = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSex);
        spinSex.setAdapter(adapter1);

        spinSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemSex = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Ini adalah alert dialog");
                alertDialog.setMessage("Apakah anda akan keluar dari aplikasi ini?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //kondisi ketika kita pencet yes
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = alertDialog.create();
                alert.show();
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaA = etNama.getText().toString();
                String EmailA = etEmail.getText().toString();
                String AlamatA = etAlamat.getText().toString();

                if(namaA.isEmpty()){
                    //memberi warning berupa error
                    etNama.setError("Nilai Tidak Boleh Kosong");
                }else if (EmailA.isEmpty()){
                    etEmail.setError("Nilai tidak boleh kosong");
                }else if (AlamatA.isEmpty()){
                    etAlamat.setError("Nilai tidak boleh kosong");
                }else{
                    lblNama.setText("Your Name : " + namaA);
                    lblEmail.setText("Your Email : " + EmailA);
                    lblAlamat.setText("Your Address : " + AlamatA);
                    lblClass.setText("Your Class : " + itemClass);
                    lblSex.setText("Your Sex : " + itemSex);
                }
            }
        });

    }
}
