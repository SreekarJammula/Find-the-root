
package edu.uh.findtheroot;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationBuilderUI extends Activity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonX,
            buttonExp, buttonDot , buttonC , buttonNext;
    TextView eqTextView;
    String equationText = "";
    int[] exponent=new int[8];
    int exponentIndex =0;
    private static final String TAG = "EquationBuilderActivity";
    public static final String PREFS_NAME = "localPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_builder_ui);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonExp = (Button) findViewById(R.id.buttonExp);
        buttonX = (Button) findViewById(R.id.buttonX);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        eqTextView = (TextView) findViewById(R.id.eqView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "1";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>2</sup>";
                    exponent[exponentIndex]=2;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "2";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>3</sup>";
                    exponent[exponentIndex]=3;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "3";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>4</sup>";
                    exponent[exponentIndex]=4;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "4";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>5</sup>";
                    exponent[exponentIndex]=5;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "5";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>6</sup>";
                    exponent[exponentIndex]=6;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "6";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>7</sup>";
                    exponent[exponentIndex]=7;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "7";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>8</sup>";
                    exponent[exponentIndex]=8;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "8";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>9</sup>";
                    exponent[exponentIndex]=9;
                    exponentIndex++;
                    updateButtonStatusAfterExponent();
                }
                else {
                    equationText += "9";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "0";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += ".";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "x";
                eqTextView.setText(Html.fromHtml(equationText));
                buttonX.setSelected(true);
                updateButtonStatusOnX(false);
            }
        });

        buttonExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonExp.setSelected(true);
                updateButtonStatusOnExponent(false);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "+";
                if(buttonX.isSelected()==true && buttonExp.isSelected()==false){
                    exponent[exponentIndex]=1;
                    exponentIndex++;
                }
                updateButtonStatusOnAddSub(false);
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "-";
                if(buttonX.isSelected()==true && buttonExp.isSelected()==false){
                    exponent[exponentIndex]=1;
                    exponentIndex++;
                }
                updateButtonStatusOnAddSub(false);
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText = "";
                enableAllButtons();
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextScreen();
            }
        });
        
    }

    private ArrayList<Double> processText(String regex, String text) {
        text += "$"; // adding a delimiter to the end of equation
        ArrayList<Double> coefficients = new ArrayList<Double>();
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(text);
        while (matcher.find())
        {
            String group = matcher.group();
            String[] list = group.split("[x$]");

            if(list.length == 1) {
                coefficients.add(Double.parseDouble(list[0]));
            }
        }
        return coefficients;
    }


    private void loadNextScreen() {
//        String sample = "2.5x<sup>3.5</sup>-3x<sup>2</sup>+5x+3.3$";
        String regex = "([\\+\\-])*([0-9]*\\.?[0-9]+)*([x$])";
        ArrayList<Double> coeffs = processText(regex, equationText);

        Log.d(TAG, "Coefficients: ");
        printArrayListOfDoubles(coeffs);

        ArrayList<Integer> exps = new ArrayList<Integer>();
        for(int i = 0; i < exponent.length; i++) {
            exps.add(exponent[0]);
        }
        Log.d(TAG, "Exponents: ");
        printArrayListOfInts(exps);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String algorithm = settings.getString("algorithm", "newton");
        if(algorithm.equals("newton")) {
            // load newton screen
        }
        else if(algorithm.equals("regulaFalsi")) {

        }
        else if(algorithm.equals("secant")) {

        }
        else if(algorithm.equals("bisection")) {

        }
    }

    private void printArrayListOfDoubles(ArrayList<Double> list) {
        for (double item : list) {
            Log.d(TAG, item + ", ");
        }
    }

    private void printArrayListOfInts(ArrayList<Integer> list) {
        for (int item : list) {
            Log.d(TAG, item + ", ");
        }
    }

    private void updateButtonStatusOnExponent(boolean status) {
        buttonAdd.setEnabled(status);
        buttonSub.setEnabled(status);
        button0.setEnabled(status);
        buttonDot.setEnabled(status);
        buttonX.setEnabled(status);
        buttonNext.setEnabled(status);
        buttonExp.setEnabled(status);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
    }

    private void updateButtonStatusOnX(boolean status) {
        buttonAdd.setEnabled(true);
        buttonSub.setEnabled(true);
        button0.setEnabled(status);
        button1.setEnabled(status);
        button2.setEnabled(status);
        button3.setEnabled(status);
        button4.setEnabled(status);
        button5.setEnabled(status);
        button6.setEnabled(status);
        button7.setEnabled(status);
        button8.setEnabled(status);
        button9.setEnabled(status);
        buttonDot.setEnabled(status);
        buttonX.setEnabled(status);
        buttonExp.setEnabled(true);
    }

    private void updateButtonStatusOnAddSub(boolean status) {
        buttonAdd.setEnabled(status);
        buttonSub.setEnabled(status);
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        buttonDot.setEnabled(true);
        buttonX.setEnabled(true);
        buttonExp.setEnabled(true);
    }

    private void updateButtonStatusAfterExponent(){
        buttonExp.setSelected(false);
        updateButtonStatusOnExponent(true);
        buttonNext.setEnabled(true);
    }

    private void enableAllButtons() {
        ViewGroup parentView = (ViewGroup) findViewById(R.id.rootRelative);
        for(int i=0; i < parentView.getChildCount(); i++) {
            View childView = parentView.getChildAt(i);
            int resID = childView.getId();
            if (childView instanceof Button) {
                final Button button = (Button) findViewById(resID);
                button.setEnabled(true);
            }
        }
    }
}
