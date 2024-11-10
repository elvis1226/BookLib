package org.dgf.util;

import java.util.ArrayList;
import java.util.List;

public final class Utility {
    private Utility() {

    }

    public static List<String> parseLine(String line) {
        char[] chs = line.toCharArray();
        List<String> result = new ArrayList<>();
        String word = "";
        int i = 0;
        boolean flag = false;
        char start = 0xff;
        while (i < chs.length) {
            if(flag) {
                if(chs[i] == start) {
                    result.add(word.trim());
                    flag = false;
                    word = "";
                }
                else {
                    word += chs[i];
                }
            }
            else {
                if(chs[i] == ' '){
                }
                else if(chs[i] == '"') {
                    flag = true;
                    start = '"';
                }
                else {
                    start = ' ';
                    flag = true;
                    word += chs[i];
                }
            }
            i++;
        }
        if (!word.isEmpty()) {
            result.add(word.trim());
        }
        return result;
    }

}
