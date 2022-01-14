package eecs1022.tutorial.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import eecs1022.tutorial.counter.model.Counter;

public class MainActivity extends AppCompatActivity {

    Counter c;



    // This is like a constructor for the app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = new Counter( 0 );
    }

    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }


    public void computerButtonCreateCounterClicked(View view) {
        String textInitValue = getInputOfTextField(R.id.inputInitValue);
        int initValue = Integer.parseInt(textInitValue);
        c = new Counter(initValue);

        setContentsOfTextView(R.id.outputCounterValue, "Counter Value: " + c.getValue());
    }

    public void computerButtonCreateIncrementClicked(View view) {
        c.increment();

        setContentsOfTextView(R.id.outputCounterValue, "Counter Value: " + c.getValue());

    }

    public void computerButtonCreateDecrementClicked(View view) {
        c.decrement();

        setContentsOfTextView(R.id.outputCounterValue, "Counter Value: " + c.getValue());

    }



}