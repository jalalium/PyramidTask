package com.oracle.exercices.pyramid;

public class Layer {
    private static int slaveStoneRatio = 50;
    public static String createLayerFor(int slaves, int anks) {
        char stoneType = determineStoneTypeFor(slaves,anks);
        return(constructLayerFor(slaves,anks,stoneType));
    }
    private static String constructLayerFor(int slaves, int anks, char stoneType)
    {
        int numberOfStones = slaves/slaveStoneRatio;
        int numberOfDashes = calculateNumberOfDashesFor(slaves, anks);
        int numberOfSpaces = calculateNumberOfSpacesFor(numberOfStones, numberOfDashes);
        return (buildLayerFor(stoneType, numberOfStones, numberOfDashes, numberOfSpaces));
    }

    private static String buildLayerFor(char stoneType, int numberOfStones, int numberOfDashes, int numberOfSpaces) {
        StringBuilder layer = new StringBuilder();
        for (int i = 0; i < numberOfSpaces; i++)
            layer.append(' ');
        for (int i = 0; i < numberOfDashes; i++)
            layer.append('_');
        for (int i = 0; i < numberOfStones; i++)
            layer.append(stoneType);
        for (int i = 0; i < numberOfDashes; i++)
            layer.append('_');
        for (int i = 0; i < numberOfSpaces; i++)
            layer.append(' ');
        return (layer.toString());
    }

    private static int calculateNumberOfSpacesFor(int numberOfStones, int numberOfDashes) {
        return (Math.max(0,2-numberOfDashes-(numberOfStones-1)/2));
    }

    private static int calculateNumberOfDashesFor(int slaves, int anks) {
        if (2*(slaves /slaveStoneRatio) <= anks)
            return (Math.min((1 + anks - (slaves/slaveStoneRatio) * 2),2-((slaves/slaveStoneRatio)-1)/2));
        else
            return (Math.min((anks - (slaves/slaveStoneRatio)),2-((slaves/slaveStoneRatio)-1)/2));
    }

    private static char determineStoneTypeFor(int slaves, int anks) {
        if (2*(slaves /slaveStoneRatio) <= anks)
            return 'X';
        else
            return 'V';
    }
}
