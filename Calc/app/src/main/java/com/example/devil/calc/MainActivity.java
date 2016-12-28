package com.example.devil.calc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Devloped by Anubhav.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Buttons onclick

        Button mClickButtonAdd = (Button) findViewById(R.id.addition);
        mClickButtonAdd.setOnClickListener(this);
        Button mClickButtonSub = (Button) findViewById(R.id.substract);
        mClickButtonSub.setOnClickListener(this);
        Button mClickButtonMul = (Button) findViewById(R.id.multiplication);
        mClickButtonMul.setOnClickListener(this);
        Button mClickButtonDiv = (Button) findViewById(R.id.divide);
        mClickButtonDiv.setOnClickListener(this);
        Button mClickButtonMod = (Button) findViewById(R.id.percentage);
        mClickButtonMod.setOnClickListener(this);
        Button mClickButtonOne = (Button) findViewById(R.id.one);
        mClickButtonOne.setOnClickListener(this);
        Button mClickButtonTwo = (Button) findViewById(R.id.two);
        mClickButtonTwo.setOnClickListener(this);
        Button mClickButtonThree = (Button) findViewById(R.id.three);
        mClickButtonThree.setOnClickListener(this);
        Button mClickButtonFour = (Button) findViewById(R.id.four);
        mClickButtonFour.setOnClickListener(this);
        Button mClickButtonFive = (Button) findViewById(R.id.five);
        mClickButtonFive.setOnClickListener(this);
        Button mClickButtonSix = (Button) findViewById(R.id.six);
        mClickButtonSix.setOnClickListener(this);
        Button mClickButtonSeven = (Button) findViewById(R.id.seven);
        mClickButtonSeven.setOnClickListener(this);
        Button mClickButtonEight = (Button) findViewById(R.id.eight);
        mClickButtonEight.setOnClickListener(this);
        Button mClickButtonNine = (Button) findViewById(R.id.nine);
        mClickButtonNine.setOnClickListener(this);
        Button mClickButtonZero = (Button) findViewById(R.id.zero);
        mClickButtonZero.setOnClickListener(this);
        Button mClickButtonClose = (Button) findViewById(R.id.clearAll);
        mClickButtonClose.setOnClickListener(this);
        Button mClickButtonDot = (Button) findViewById(R.id.dot);
        mClickButtonDot.setOnClickListener(this);
        Button mClickButtonEqual = (Button) findViewById(R.id.equal);
        mClickButtonEqual.setOnClickListener(this);



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addition: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("+");
                break;
            }

            case R.id.substract: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("-");

                break;
            }

            case R.id.divide: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("/");
                break;
            }

            case R.id.multiplication: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("*");
                break;
            }

            case R.id.percentage: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("%");
                break;
            }

            case R.id.clearAll: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");
                break;
            }

            case R.id.dot: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append(".");
                break;
            }

            case R.id.equal: {
                TextView textView = (TextView) findViewById(R.id.textView);
                final String str = textView.getText().toString();
                double result = 0;
                try {
                    result = evaluate(str);
                    textView.setText(Double.toString(result));

                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setText("syntax error");
                }
                break;
            }

            case R.id.zero: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("0");
                break;
            }

            case R.id.one: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("1");
                break;
            }

            case R.id.two: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("2");
                break;
            }

            case R.id.three: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("3");
                break;
            }

            case R.id.four: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("4");
                break;
            }

            case R.id.five: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("5");
                break;
            }

            case R.id.six: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("6");
                break;
            }
            case R.id.seven: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("7");
                break;
            }

            case R.id.eight: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("8");
                break;
            }

            case R.id.nine: {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.append("9");
                break;
            }

        }
    }

    public static double evaluate(final String str) throws Exception {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
