package local.tp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class CouleursActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_couleurs);

        populateImageButtons();
}

    private void populateImageButtons() {
        TableLayout tableLayout = (TableLayout) findViewById(android.R.id.grillesCouleurs)
        for(int row = 0; row<NUM_ROWS; row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
                ));
            grilleCouleurs.addView(tableRow);
            for(int col = 0; row<NUM_COLS; col++){
                ImageButton imageButton = new ImageButton(this);
                imageButton.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT,
                        1.0f
                    ));

                final int finalCol = col;
                final int finalRow = row;
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gridButtonClicked(finalCol, finalRow);
                    }


                });

                tableRow.addView(imageButton);
            }
        }
    }
    private void gridButtonClicked(int x, int y) {
        Toast.makeText(this, "Button clicked: " + x + " , " +y, Toast.LENGTH_SHORT).show();
    }
}