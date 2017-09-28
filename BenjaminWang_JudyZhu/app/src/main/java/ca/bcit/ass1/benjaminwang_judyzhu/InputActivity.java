package ca.bcit.ass1.benjaminwang_judyzhu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class InputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void onClickConvert(View v) {
        // Get the user chosen rule
        Spinner conversion = (Spinner) findViewById(R.id.conversion_list);
        String rule = String.valueOf(conversion.getSelectedItem());

        EditText input_EditText = (EditText) findViewById(R.id.input_length);
        float input = Float.valueOf(input_EditText.getText().toString());
        String output = "";

        // Calculate conversion based on the rule
        switch (rule) {
            case "Kilometres to Miles":
                output = input + "\n" + getString(R.string.km_convert_to) + "\n"
                            + (input * 0.62137119224) + "\n" + getString(R.string.mi);
                break;
            case "Miles to Kilometres":
                output = input + "\n" + getString(R.string.mi_convert_to) + "\n"
                            + (input / 0.62137119224) + "\n" + getString(R.string.km);
                break;
            case "Metres to Yards":
                output = input + "\n" + getString(R.string.m_convert_to) + "\n"
                            + (input * 1.093613) + "\n" + getString(R.string.yd);
                break;
            case "Yards to Metres":
                output = input + "\n" + getString(R.string.yd_convert_to) + "\n"
                            + (input / 1.093613) + "\n" + getString(R.string.m);
                break;
            case "Metres to Feet":
                output = input + "\n" + getString(R.string.m_convert_to) + "\n"
                            + (input * 3.280839895) + "\n" + getString(R.string.ft);
                break;
            case "Feet to Metres":
                output = input + "\n" + getString(R.string.ft_convert_to) + "\n"
                            + (input / 3.280839895) + "\n" + getString(R.string.m);
                break;
            default:
                break;
        }

        // Pass conversion result to OutputActivity
        Intent intent = new Intent(this, OutputActivity.class);
        intent.putExtra("msg", output);
        startActivity(intent);
    }
}
