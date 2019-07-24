package com.kebunit.androidallinone.helper;

public class NumberHelper {
    public static String currencyFormat(String number, String splitter) {
        String header, body, out;
        int start, dotcount, state;
        if (number.length()%3==0) {
            start = 3;
        } else {
            start = number.length()%3;
        }
        header = number.substring(0, start);
        body = number.substring(start, number.length());
        return header + splitter + formatNumber(body);
    }

    public static String formatNumber(String body) {
        String out="";
        int state = 0;
        int count = body.length()/3;
        if (body.length() >= 3) {
            for (int i=0; i<count; i++) {
                out = out+"."+body.substring(state, state+3);
                state = state + 3;
            }
        }

        return out;
    }
}
