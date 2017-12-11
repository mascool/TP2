package local.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity {

    private String color;
    private String size;
    private String font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageButton buttonBlc = (ImageButton) findViewById(R.id.buttonBlc);
        ImageButton buttonRed = (ImageButton) findViewById(R.id.buttonRed);
        ImageButton buttonBlu = (ImageButton) findViewById(R.id.buttonBlu);
        ImageButton buttonYlo = (ImageButton) findViewById(R.id.buttonYlo);
        ImageButton buttonGre = (ImageButton) findViewById(R.id.buttonGre);
        Button buttonApp = (Button) findViewById(R.id.buttonAppliquer);

        color = "";
        size = "";
        font = "";

        buttonBlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "black";
            }
        });
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "red";
            }
        });
        buttonBlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "blue";
            }
        });
        buttonYlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "yellow";
            }
        });
        buttonGre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "green";
            }
        });


        buttonApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinnerSize = (Spinner) findViewById(R.id.spinnerSize);
                Spinner spinnerFont = (Spinner) findViewById(R.id.spinnerFont);
                size = spinnerSize.getSelectedItem().toString();
                font = spinnerFont.getSelectedItem().toString();

                Intent intent = new Intent(SettingActivity.this, NoteActivity.class);
                intent.putExtra("COLOR", color);
                intent.putExtra("SIZE", size);
                intent.putExtra("FONT", font);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }
}
