package com.oracle.exercices.pyramid;

import java.util.ArrayList;

public class Pyramid {
    private ArrayList<String> pyramidLayers = new ArrayList<>();
    private static int pyramidWidth = 5;
    private static String stones = "XV";
    private static String weakPoints = " _";

    public void addLayer(String input) {
        int slaves = Parser.parseSlaveFor(input);
        int anks = Parser.parseAnksFor(input);
        String temporaryLayer = Layer.createLayerFor(slaves, anks);
        if (checkIfCollapseble(pyramidLayers, temporaryLayer)) {
            collapseLayer();
            appendLayer(temporaryLayer);
        }
        else
            appendLayer(temporaryLayer);
    }

    private void collapseLayer() {
        int height = pyramidLayers.size()-1;
        pyramidLayers.remove(height);
    }
    private void appendLayer(String temporaryLayer){
        pyramidLayers.add(temporaryLayer);
    }
    private boolean checkIfCollapseble(ArrayList<String> pyramidLayers, String temporaryLayer) {
        int height = pyramidLayers.size()-1;
        if (height < 1)
            return false;
        String topLayerOfPyramid = pyramidLayers.get(height);
        if (topLayerOfPyramid.equals(temporaryLayer))
            return true;
        for (int i = 0; i < pyramidWidth; i++)
            if (stones.indexOf(temporaryLayer.charAt(i)) != -1 && weakPoints.indexOf(topLayerOfPyramid.charAt(i)) != -1)
                return true;
         return false;
    }

    public String print() {
        return (PyramidPrinter.print(pyramidLayers));
    }
}
