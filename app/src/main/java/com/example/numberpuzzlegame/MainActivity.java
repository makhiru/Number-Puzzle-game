package com.example.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtwin, txtcount;
    Button btnrestart;
    ArrayList list = new ArrayList();
    TextView[] txtv = new TextView[9];
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtwin = findViewById(R.id.txtwin);
        txtcount = findViewById(R.id.txtcount);
        btnrestart = findViewById(R.id.btnrestart);

        for (int i = 0; i < 9; i++) {
            int id = getResources().getIdentifier("txt" + i, "id", getPackageName());
            txtv[i] = findViewById(id);
            txtv[i].setOnClickListener(this);
        }

        board();

        btnrestart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                list.clear();
                count = 0;

                txtcount.setText(String.valueOf(count));
                txtwin.setText("");
                for (int i = 0; i < 9; i++) {

                    txtv[i].setText("");
                    txtv[i].setClickable(true);
                    txtv[i].setVisibility(View.VISIBLE);
                }
                board();
            }
        });
    }

    @Override
    public void onClick(View v) {

        for (int i = 0; i < 9; i++) {
            win();

            if (v.getId() == txtv[i].getId()) {
                if (i == 0) {
                    down(i);
                    right(i);
                } else if (i == 1) {
                    down(i);
                    left(i);
                    right(i);
                } else if (i == 2) {
                    down(i);
                    left(i);
                } else if (i == 3) {
                    right(i);
                    up(i);
                    down(i);
                } else if (i == 4) {
                    right(i);
                    up(i);
                    down(i);
                    left(i);
                } else if (i == 5) {
                    down(i);
                    up(i);
                    left(i);
                } else if (i == 6) {
                    right(i);
                    up(i);
                } else if (i == 7) {
                    right(i);
                    up(i);
                    left(i);
                } else {
                    up(i);
                    left(i);
                }
            }
        }
    }

    public void right(int i) {

        if (txtv[i + 1].getText().equals("")) {
            txtv[i + 1].setVisibility(View.VISIBLE);
            txtv[i + 1].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            count++;
            txtcount.setText(String.valueOf(count));
        }
    }

    public void left(int i) {
        if (txtv[i - 1].getText().equals("")) {
            txtv[i - 1].setVisibility(View.VISIBLE);
            txtv[i - 1].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            count++;
            txtcount.setText(String.valueOf(count));
        }
    }

    public void up(int i) {
        if (txtv[i - 3].getText().equals("")) {
            txtv[i - 3].setVisibility(View.VISIBLE);
            txtv[i - 3].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            count++;
            txtcount.setText(String.valueOf(count));
        }
    }

    public void down(int i) {
        if (txtv[i + 3].getText().equals("")) {
            txtv[i + 3].setVisibility(View.VISIBLE);
            txtv[i + 3].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            count++;
            txtcount.setText(String.valueOf(count));
        }
    }

    public void win() {
        if (txtv[0].getText().equals("1") && txtv[1].getText().equals("2") && txtv[2].getText().equals("3") &&
                txtv[3].getText().equals("4") && txtv[4].getText().equals("5") && txtv[5].getText().equals("6") &&
                txtv[6].getText().equals("7") && txtv[7].getText().equals("8")) {

            txtwin.setText("Winner !!!");
            disable();
        }
    }

    public void disable() {

        for (int i = 0; i < 9; i++) {
            txtv[i].setClickable(false);
        }
    }

    public void board() {

        while (true) {
            int r1 = new Random().nextInt(9);
            int r2 = new Random().nextInt(9 - 1) + 1;

            if (txtv[r1].getText().equals("") && !list.contains(r2)) {

                txtv[r1].setText(String.valueOf(r2));
                list.add(r2);
                if (list.size() >= 8) {
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (txtv[i].getText().equals("")) {
                txtv[i].setVisibility(View.INVISIBLE);
            }
        }

    }

}
















