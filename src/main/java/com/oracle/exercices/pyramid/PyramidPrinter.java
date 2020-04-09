package com.oracle.exercices.pyramid;

import java.util.ArrayList;

public class PyramidPrinter {
    public static String print(ArrayList<String> pyramidLayers) {
        StringBuilder output = new StringBuilder();
        for (int i = pyramidLayers.size()-1; i >=0; i--) {
            output.append(pyramidLayers.get(i));
            if (i != 0)
                output.append('\n');
        }
        return output.toString();
    }
}
