package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    EditText etNim, etNama;
    Button btnTambah;
    ArrayList<Mahasiswa> data;
    MahasiswaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FIX: Pastikan ID sesuai dengan yang di XML
        rv1 = findViewById(R.id.rv1);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        btnTambah = findViewById(R.id.btnTambah);

        // Inisialisasi data
        data = new ArrayList<>();
        adapter = new MahasiswaAdapter(this, data);
        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));

        // Event Klik Tombol Tambah
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });
    }

    // Fungsi untuk menambah data ke RecyclerView
    private void tambahData() {
        String nim = etNim.getText().toString().trim();
        String nama = etNama.getText().toString().trim();

        if (!nim.isEmpty() && !nama.isEmpty()) {
            Mahasiswa mhs = new Mahasiswa(nim, nama);
            data.add(mhs);
            adapter.notifyItemInserted(data.size() - 1);

            // Kosongkan input setelah tambah
            etNim.setText("");
            etNama.setText("");
        }
    }
}
