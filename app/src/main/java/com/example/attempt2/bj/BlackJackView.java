package com.example.attempt2.bj;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.attempt2.bj.Calc.*;
import static com.example.attempt2.bj.Initializer.*;

public class BlackJackView extends AppCompatActivity {

    private Button but_card, but_stop, but_restart, but_deal;
    private ImageButton but_five, but_tFive, but_hud, but_fHud, but_t;
    private ImageView deck2, deck3, deck4, deck5,
    deck6, deck7 , deck8, deck9, deck10, deck11, deck12, deck13, deck14, deck15, deck16,
        deck17 , deck18, deck19, deck20, deck21, deck22, deck23, deck24, deck25, deck26,
            deck27, deck28, deck29, deck30, deck31, deck32, deck33, deck34, deck35, deck36, deck37;
    private int kart;
    private int count = 1, viewCount = 0, countInGame = 0;
    private TextView sum_player, sum_II, final_text, totCount;
    final static int topCount = 21;

    CardsCount cc = new CardsCount();
    int [] countCard = new int[52];
    int [] deckClon = new int [52];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startGame();
        but_card.setEnabled(false);
        totCount.setText(String.valueOf(totalCount));
        kart  = rnd(0,51);
        deck2.setImageResource(d[kart]);
        sum_PL(countCard[kart]);
        deckClon[kart] = d[kart];
        kart = rnd(0,51);
        for (int i: deckClon)
            if (d[kart] == i) {
                kart = rnd(0,51);
                deck3.setImageResource(d[kart]);
            }
        deck3.setImageResource(d[kart]);
        sum_player.setText(String.valueOf(sum_PL(countCard[kart])));
        deckClon[kart] = d[kart];
        restart ();
        gameDeal();
        overGame ();

    }
    public void gameDeal() {
        but_deal = (Button)findViewById(R.id.button4);
        but_deal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        but_five.setEnabled(false);
                        but_fHud.setEnabled(false);
                        but_hud.setEnabled(false);
                        but_tFive.setEnabled(false);
                        but_t.setEnabled(false);
                        but_card.setEnabled(true);
                    }
                }
        );
    }
    public void startGame() {

        cc.cardCount(countCard);
        sum_player = (TextView)findViewById(R.id.textView6);
        sum_II = (TextView)findViewById(R.id.textView4);
        final_text = (TextView)findViewById(R.id.finalTextView);
        but_card = (Button)findViewById(R.id.button3);
        but_stop = (Button)findViewById(R.id.button6);
        but_five = (ImageButton)findViewById(R.id.iMButFive);
        but_tFive = (ImageButton)findViewById(R.id.iMButTFive);
        but_hud = (ImageButton)findViewById(R.id.iMButH);
        but_fHud = (ImageButton)findViewById(R.id.iMButFiveH);
        but_t = (ImageButton)findViewById(R.id.iMButT);
        totCount = (TextView)findViewById(R.id.viewTotalScore);
        final ImageView [] iMPl = {
                deck2 = (ImageView)findViewById(R.id.iV8),
                deck3 = (ImageView)findViewById(R.id.iV9),
                deck4 = (ImageView)findViewById(R.id.iV10),
                deck5 = (ImageView)findViewById(R.id.iV11),
                deck6 = (ImageView)findViewById(R.id.iV12),
                deck7 = (ImageView)findViewById(R.id.iV13),
                deck8 = (ImageView)findViewById(R.id.iV14),
                deck9 = (ImageView)findViewById(R.id.iV15),
                deck10 = (ImageView)findViewById(R.id.iV16),
                deck11 = (ImageView)findViewById(R.id.iV17)};

        final ImageView [] iM = {
                deck12 = (ImageView)findViewById(R.id.iV18),
                deck13 = (ImageView)findViewById(R.id.iV19),
                deck14 = (ImageView)findViewById(R.id.iV20),
                deck15 = (ImageView)findViewById(R.id.iV21),
                deck16 = (ImageView)findViewById(R.id.iV22),
                deck17 = (ImageView)findViewById(R.id.iV23),
                deck18 = (ImageView)findViewById(R.id.iV24),
                deck19 = (ImageView)findViewById(R.id.iV25),
                deck20 = (ImageView)findViewById(R.id.iV26),
                deck21 = (ImageView)findViewById(R.id.iV27)};

        final ImageView [] iMCount = {
                deck22 = (ImageView)findViewById(R.id.imV1),
                deck23 = (ImageView)findViewById(R.id.imV2),
                deck24 = (ImageView)findViewById(R.id.imV3),
                deck25 = (ImageView)findViewById(R.id.imV4),
                deck26 = (ImageView)findViewById(R.id.imV5),
                deck27 = (ImageView)findViewById(R.id.imV6),
                deck28 = (ImageView)findViewById(R.id.imV7),
                deck29 = (ImageView)findViewById(R.id.imV8),
                deck30 = (ImageView)findViewById(R.id.imV9),
                deck31 = (ImageView)findViewById(R.id.imV10),
                deck32 = (ImageView)findViewById(R.id.imV11),
                deck33 = (ImageView)findViewById(R.id.imV12),
                deck34 = (ImageView)findViewById(R.id.imV13),
                deck35 = (ImageView)findViewById(R.id.imV14),
                deck36 = (ImageView)findViewById(R.id.imV15),
                deck37 = (ImageView)findViewById(R.id.imV16)};

        but_five.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        iMCount[viewCount].setImageResource(c[0]);
                        viewCount++;
                        totalCount = Calc.score_game(totalCount, 5);
                        totCount.setText(String.valueOf(totalCount));
                        countInGame += 5;

                    }
                }
        );

        but_tFive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        iMCount[viewCount].setImageResource(c[1]);
                        viewCount++;
                        totalCount = Calc.score_game(totalCount, 25);
                        totCount.setText(String.valueOf(totalCount));
                        countInGame += 25;

                    }
                }
        );

        but_hud.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        iMCount[viewCount].setImageResource(c[2]);
                        viewCount++;
                        totalCount = Calc.score_game(totalCount, 100);
                        totCount.setText(String.valueOf(totalCount));
                        countInGame += 100;

                    }
                }
        );

        but_fHud.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        iMCount[viewCount].setImageResource(c[3]);
                        viewCount++;
                        totalCount = Calc.score_game(totalCount, 500);
                        totCount.setText(String.valueOf(totalCount));
                        countInGame += 500;

                    }
                }
        );

        but_t.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iMCount[viewCount].setImageResource(c[4]);
                        viewCount++;
                        totalCount = Calc.score_game(totalCount, 1000);
                        totCount.setText(String.valueOf(totalCount));
                        countInGame += 1000;
                    }
                }
        );


        but_card.setOnClickListener(
             new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     count++;
                     try {
                         kart = rnd(0, 51);
                         iMPl[count].setImageResource(d[kart]);
                         for (int i : deckClon)
                             if (d[kart] == i) {
                                 kart = rnd(0, 51);
                                 iMPl[count].setImageResource(d[kart]);
                             }
                         sum_player.setText(String.valueOf(sum_PL(countCard[kart])));
                             if (sum >= topCount) {
                                 but_card.setEnabled(false);
                                 for (int countImage = 0; countImage < iM.length; countImage++){
                                     if (sum_pc <= topCount){
                                         kart = rnd(0,51);
                                         iM[countImage].setImageResource(d[kart]);
                                         for (int i: deckClon)
                                             if (d[kart] == i) {
                                                 kart = rnd(0,51);
                                                 iM[countImage].setImageResource(d[kart]);
                                             }
                                         sum_II.setText(String.valueOf(sum_PC(countCard[kart])));
                                         deckClon[kart] = d[kart];
                                     }
                                 }
                                 if (sum_pc <= topCount && sum_pc > sum || sum_pc <= topCount && sum > topCount) {
                                     final_text.setText("ИИ выйграл!");

                                 } else if (sum_pc > 21 && sum <= 21 || sum > sum_pc && sum <= 21) {
                                     totalCount = Calc.sum_WIN(totalCount, countInGame);
                                     final_text.setText("Вы выйграли!");

                                 } else if (sum_pc == sum && sum_pc <= 21 && sum <= 21|| (sum_pc > 21 && sum > 21)) {
                                     totalCount += countInGame;
                                     final_text.setText("Ничья!");
                                 }
                             }
                         deckClon[kart] = d[kart];
                     }catch (IndexOutOfBoundsException e) {
                         e.printStackTrace();
                     }
                 }
             }
        );

        but_stop.setOnClickListener(
             new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     but_card.setEnabled(false);
                     for (int countImage = 0; countImage < iM.length; countImage++) {
                         if (sum_pc <= topCount && sum_pc < sum) {
                             kart = rnd(0,51);
                             iM[countImage].setImageResource(d[kart]);
                             for (int i: deckClon)
                             if (d[kart] == i) {
                                 kart = rnd(0,51);
                                 iM[countImage].setImageResource(d[kart]);
                             }
                             sum_II.setText(String.valueOf(sum_PC(countCard[kart])));
                             deckClon[kart] = d[kart];
                         }
                     }

                     if (sum_pc <= topCount && sum_pc > sum || sum_pc <= topCount && sum > topCount) {

                         final_text.setText("ИИ выйграл!");

                     } else if (sum_pc > 21 && sum <= 21 || sum > sum_pc && sum <= 21) {
                         totalCount = Calc.sum_WIN(totalCount, countInGame);
                         final_text.setText("Вы выйграли!");

                     } else if (sum_pc == sum && sum_pc <= 21 && sum <= 21|| (sum_pc > 21 && sum > 21)) {
                         totalCount += countInGame;
                         final_text.setText("Ничья!");
                     }
                 }
             }
        );
    }
    public void overGame() {
        if (totalCount == 0 || totalCount == 6000) {
            AlertDialog.Builder a_build  = new AlertDialog.Builder(BlackJackView.this);
            a_build.setMessage("Вы хотите вернутся в главное меню?")
                    .setCancelable(false)
                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(BlackJackView.this, MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Нет", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            totalCount = 3000;
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = a_build.create();
            alert.setTitle("Игра окончена. ");
            alert.show();
        }
    }

    public void restart() {
        but_restart = (Button)findViewById(R.id.button5);
        but_restart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (android.os.Build.VERSION.SDK_INT >= 11){
                            recreate();
                            sum = 0;
                            sum_pc = 0;
                        } else {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}

