package id.sch.smktelkom_mlg.tugas01.xiirpl5003.aplikasipemesananroti;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Arrays;

        import id.sch.smktelkom_mlg.tugas01.xiirpl5003.aplikasipemesananroti.adapter.UkuranAdapter;

public class MainActivity extends AppCompatActivity
{

    EditText etNama;
    RadioButton rbC, rbS, rbG;
    CheckBox cbKj, cbKg, cbMs;
    Spinner spBentuk, spUkuran;
    String[][]arUkuran = {{"Bulat Large","Bulat Medium","Bulat Small"},
            {"Kotak Large","Kotak Medium","Kotak Small"}};
    ArrayList<String> listUkuran = new ArrayList<>();
    UkuranAdapter adapter;

    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNama = (EditText) findViewById(R.id.editTextNama);

        rbC = (RadioButton) findViewById(R.id.radioButtonCokelat);
        rbS = (RadioButton) findViewById(R.id.radioButtonStrawberry);
        rbG = (RadioButton) findViewById(R.id.radioButtonGreen);

        cbKj = (CheckBox) findViewById(R.id.checkBoxKeju);
        cbKg = (CheckBox) findViewById(R.id.checkBoxKacang);
        cbMs = (CheckBox) findViewById(R.id.checkBoxMessis);

        spBentuk = (Spinner) findViewById(R.id.spinnerBentuk);
        spUkuran = (Spinner) findViewById(R.id.spinnerUkuran);

        bOk = (Button) findViewById(R.id.buttonOK);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);


        adapter = new UkuranAdapter(this,listUkuran);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUkuran.setAdapter(adapter);

        spBentuk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                listUkuran.clear();
                listUkuran.addAll(Arrays.asList(arUkuran[position]));
                adapter.setBentuk((String)spBentuk.getItemAtPosition(position));
                adapter.notifyDataSetChanged();
                spUkuran.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });



        bOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doProcess();

            }
        });

    }


    private void doProcess() {


        String hasil = null;

        if(rbC.isChecked())
        {
            hasil = rbC.getText().toString();
        }
        else if(rbS.isChecked())
        {
            hasil = rbS.getText().toString();
        }
        else if(rbG.isChecked())
        {
            hasil = rbG.getText().toString();
        }
        if (hasil==null)
        {
            tvHasil.setText("Belum memilih rasa");
        }
        String hasil1 ="Toping";
        int startlen = hasil1.length();
        if(cbKj.isChecked()) hasil1+=cbKj.getText()+"\n";
        if(cbKg.isChecked()) hasil1+=cbKg.getText()+"\n";
        if(cbMs.isChecked()) hasil1+=cbMs.getText()+"\n";

        if(hasil1.length()==startlen) hasil1+="Tidak ada pilihan";


        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText(nama);
            tvHasil.setText("Nama             : " + nama + "\n\n" +
                    "Rasa yg dipilih          : " + hasil + "\n\n" +
                    "Toping yg dipilih        :" + hasil1 + "\n\n" +
                    "Bentuk yg dipilih : " + spBentuk.getSelectedItem().toString()
                    + " dan dengan ukuran" + spUkuran.getSelectedItem().toString() + "\n\n" +
                    "Terimkasih telah memesan");
        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if (nama.length()<3)
        {
            etNama.setError("Nama Minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        return valid;
    }

}