package ca.bcit.ass1.benjaminwang_judyzhu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void onClickConvert(View v) {
        // Get the user chosen rule from spinner
        Spinner conversion = (Spinner) findViewById(R.id.conversion_list);
        String rule = String.valueOf(conversion.getSelectedItem());

        EditText input_EditText = (EditText) findViewById(R.id.input_length);
        float input = Float.valueOf(input_EditText.getText().toString());
        String output = "";

        // Calculate conversion based on the rule
        switch (rule) {
            case "Kilometres to Miles":
                output = input + " Kilometres converts to " + (input * 0.62137119224) + " Miles.";
                break;
            case "Miles to Kilometres":
                output = input + " Miles converts to " + (input / 0.62137119224) + " Kilometres";
                break;
            case "Metres to Yards":
                output = input + " Metres converts to " + (input * 1.093613) + " Yards.";
                break;
            case "Yards to Metres":
                output = input + " Yards converts to " + (input / 1.093613) + " Metres";
                break;
            case "Metres to Feet":
                output = input + " Metres converts to " + (input * 3.280839895) + " Feet.";
                break;
            case "Feet to Metres":
                output = input + " Feet converts to " + (input / 3.280839895) + " Metres";
                break;
        }


        // Pass conversion result to OutputActivity
        Intent intent = new Intent(this, OutputActivity.class);
        intent.putExtra("msg", output);
        startActivity(intent);
    }

}
