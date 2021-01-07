package com.example.demo.util;


public class Random64 {
    public static String getRandom64() {
        String str = "";
        for (int i = 0; i < 64; i++) {
            str += (char) ((Math.random() * 26)+65)+"";
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getRandom64());
    }
}
