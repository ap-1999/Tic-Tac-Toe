package com.androidlabs.ticktacktoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    int[] gstate={10,10,10,10,10,10,10,10,10};
    int[][] winningp={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void restart(View wow)
    {
        finish();
        startActivity(getIntent());
    }
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tag = Integer.parseInt(counter.getTag().toString());
        if (gstate[tag - 1] == 10) {
            if (i % 2 == 0) {
                counter.setTranslationY(-1000f);
                counter.setImageResource(R.drawable.cross);
                counter.animate().translationYBy(1000f).setDuration(500);
                gstate[tag - 1] = 0;

            } else {
                counter.setTranslationY(-1000f);
                counter.setImageResource(R.drawable.zero);
                counter.animate().translationYBy(1000f).setDuration(500);
                gstate[tag - 1] = 1;
            }
            i++;

            for (int[] winning : winningp) {

                if ((gstate[winning[0]]) == (gstate[winning[1]]) && (gstate[winning[1]]) == (gstate[winning[2]]) && (gstate[winning[0]]) != 10) {
                    System.out.println(i);
                    if (gstate[winning[0]] == 0) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Game Over")
                                .setMessage("X is the winner")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                        startActivity(getIntent());// Whatever...
                                    }
                                })   .setNegativeButton("Shut Down", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                // Whatever...
                            }
                        }).show();


                    } else {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Game Over")
                                .setMessage("O is the winner")
                                .setCancelable(false)
                                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                        startActivity(getIntent());// Whatever...
                                    }
                                })
                                .setNegativeButton("Shut Down", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                        // Whatever...
                                    }
                                }).show();


                    }
                }
            }


        }
        for (int[] winning : winningp)
        {
        if((i==9)&&((gstate[winning[0]])!=(gstate[winning[1]]))) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Game Over")
                    .setMessage("Draw")
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            startActivity(getIntent());// Whatever...
                        }
                    })   .setNegativeButton("Shut Down", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    // Whatever...
                }
            }).show();
        }
        }
    }
}