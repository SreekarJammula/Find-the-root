package edu.uh.findtheroot;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.util.ArrayList;

public class BisectionActivity extends Activity {

    TextView eqTextView;
    ArrayList<Double> coefficients;
    ArrayList<Integer> exponents;
    private final static String TAG = "Bisection";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisection);
        coefficients = (ArrayList<Double>) getIntent().getSerializableExtra("coefficients");
        exponents = getIntent().getIntegerArrayListExtra("exponents");
        String eq = getIntent().getStringExtra("equation");
        if (eq == null) {
            eq = "";
        }
        eqTextView.setText(Html.fromHtml(eq));

    }
}
