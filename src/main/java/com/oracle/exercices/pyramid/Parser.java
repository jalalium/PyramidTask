package com.oracle.exercices.pyramid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static int parseSlaveFor(String input) {
        Pattern p = Pattern.compile("([\\d]+)+[^\\d]+([\\d]+)+[^\\d]");
        Matcher n = p.matcher(input);
        if (n.find())
            return Integer.parseInt(n.group(1));
        return -1;
    }

    public static int parseAnksFor(String input) {
        Pattern p = Pattern.compile("([\\d]+)+[^\\d]+([\\d]+)+[^\\d]");
        Matcher n = p.matcher(input);
        if (n.find())
            return Integer.parseInt(n.group(2));
        return -1;
    }
}
