package com.example.tsdmh_7s5_prac3_lmua;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtnombre = findViewById(R.id.txtnombre);
        EditText txtedad = findViewById(R.id.txtedad);
        Button btnsaluda = findViewById(R.id.btnsaluda);
        btnsaluda.setOnClickListener(v -> {
            String nombre = txtnombre.getText().toString();
            String edad = txtedad.getText().toString();
            String mensaje = "Bienvenido " + nombre + (edad.isEmpty() ? "" : ", Edad: " + edad);
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder mensajecaja = new AlertDialog.Builder(this);
            mensajecaja.setMessage(mensaje)
                    .setTitle("Mensaje")
                    .setPositiveButton(R.string.Dialogook, (dialogInterface, i) -> {

                    });
            AlertDialog dialogo = mensajecaja.create();
            dialogo.show();
        });
    }
}