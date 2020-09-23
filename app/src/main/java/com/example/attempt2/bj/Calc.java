package com.example.attempt2.bj;

public class Calc {
    static int sum;
    static int sum_pc;
    static int s_game;
    private static int x;
    private static int y;

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int sum_PL(int x){
        sum += x;
        return sum;
    }

    public static int sum_PC(int x){
        sum_pc += x;
        return sum_pc;
    }

    public static int sum_WIN(int x, int y){
        x += y*2;
        return x;
    }


    public static int score_game(int x, int y){
        x -= y;
        return x;
    }
}
