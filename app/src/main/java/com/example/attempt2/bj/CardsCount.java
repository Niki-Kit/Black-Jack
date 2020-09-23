package com.example.attempt2.bj;

public class CardsCount {
    private int count = 2;

    public int [] cardCount(int [] countCards) {
        for (int i = 0; i < countCards.length; i++) {

            if (count < 15) {
                if (count < 11) {
                    countCards[i] = count;
                }
                if (count == 11) {
                    countCards[i] = 2;
                }
                if (count == 12) {
                    countCards[i] = 3;
                }
                if (count == 13) {
                    countCards[i] = 4;
                }
                if (count == 14) {
                    countCards[i] = 11;

                }
            } count++;
            if (count == 15) {
                count = 2;
            }
        }
        return countCards;
    }
}
