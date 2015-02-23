package com.clefeflo.assistantdenavigation;

import java.util.ArrayList;

/**
 * Created by Félix on 21/01/2015.
 */
public class AddToMap {

    private static ArrayList<String> pointsConnectes = new ArrayList<>();
    private static ArrayList<Integer> poidsLiaisons = new ArrayList<>();
    private static ArrayList<Integer> numPoint = new ArrayList<>();

    static Liaison[] liaison = {new Liaison("OA0", "A0", 42),new Liaison("A0", "AB0", 53),new Liaison("AB0", "B0", 48),new Liaison("B0", "C0", 85),new Liaison("C0", "CD0", 67),new Liaison("CD0", "D0", 83),new Liaison("D0", "E0", 103),new Liaison("E0", "EF0", 41),new Liaison("EF0", "F0", 45),new Liaison("F0", "G0", 85),new Liaison("G0", "GH0", 32),new Liaison("GH0", "H0", 36),new Liaison("H0", "I0", 100),new Liaison("I0", "IJ0", 55),new Liaison("IJ0", "J0", 47),new Liaison("J0", "K0", 92),new Liaison("K0", "KL0", 36),new Liaison("KL0", "L0", 532),new Liaison("L0", "M0", 97),new Liaison("M0", "MN0", 66),new Liaison("MN0", "N0", 45),new Liaison("N0", "NO0", 47),new Liaison("NO0", "OA0", 176),new Liaison("NO0", "EF0", 463),new Liaison("NO0", "IJ0", 400),new Liaison("OA0", "IJ0", 463),new Liaison("OA0", "EF0", 400),
                                                            new Liaison("A1", "AB1", 53),new Liaison("AB1", "B1", 48),new Liaison("B1", "C1", 85),new Liaison("C1", "CD1", 67),new Liaison("CD1", "D1", 83),new Liaison("D1", "E1", 103),new Liaison("E1", "EF1", 41),new Liaison("EF1", "F1", 45),new Liaison("F1", "G1", 85),new Liaison("G1", "GH1", 32),new Liaison("GH1", "H1", 36),new Liaison("H1", "I1", 100),new Liaison("I1", "IJ1", 55),new Liaison("IJ1", "J1", 47),new Liaison("J1", "K1", 92),new Liaison("K1", "KL1", 36),new Liaison("KL1", "L1", 532),new Liaison("L1", "M1", 97),new Liaison("M1", "MN1", 66),new Liaison("MN1", "N1", 45),
                                                            new Liaison("A2", "AB2", 53),new Liaison("AB2", "B2", 48),new Liaison("B2", "C2", 85),new Liaison("C2", "CD2", 67),new Liaison("CD2", "D2", 83),new Liaison("D2", "E2", 103),new Liaison("E2", "EF2", 41),new Liaison("EF2", "F2", 45),new Liaison("F2", "G2", 85),new Liaison("G2", "GH2", 32),new Liaison("GH2", "H2", 36),new Liaison("H2", "I2", 100),new Liaison("I2", "IJ2", 55),new Liaison("IJ2", "J2", 47),new Liaison("J2", "K2", 92),new Liaison("K2", "KL2", 36),new Liaison("KL2", "L2", 532),new Liaison("L2", "M2", 97),new Liaison("M2", "MN2", 66),new Liaison("MN2", "N2", 45),
                                                            new Liaison("A3", "AB3", 53),new Liaison("AB3", "B3", 48),new Liaison("B3", "C3", 85),new Liaison("C3", "CD3", 67),new Liaison("CD3", "D3", 83),new Liaison("D3", "E3", 103),new Liaison("E3", "EF3", 41),new Liaison("EF3", "F3", 45),new Liaison("F3", "G3", 85),new Liaison("G3", "GH3", 32),new Liaison("GH3", "H3", 36),new Liaison("H3", "I3", 100),new Liaison("I3", "IJ3", 55),new Liaison("IJ3", "J3", 47),new Liaison("J3", "K3", 92),new Liaison("K3", "KL3", 36),new Liaison("KL3", "L3", 532),new Liaison("L3", "M3", 97),new Liaison("M3", "MN3", 66),new Liaison("MN3", "N3", 45),
                                                            new Liaison("AB0", "AB1", 80),new Liaison("AB1", "AB2", 80),new Liaison("AB2", "AB3", 80),new Liaison("CD0", "CD1", 80),new Liaison("CD1", "CD2", 80),new Liaison("CD2", "CD3", 80),new Liaison("EF0", "EF1", 80),new Liaison("EF1", "EF2", 80),new Liaison("EF2", "EF3", 80),new Liaison("GH0", "GH1", 80),new Liaison("GH1", "GH2", 80),new Liaison("GH2", "GH3", 80),new Liaison("IJ0", "IJ1", 80),new Liaison("IJ1", "IJ2", 80),new Liaison("IJ2", "IJ3", 80),new Liaison("KL0", "KL1", 80),new Liaison("KL1", "KL2", 80),new Liaison("KL2", "KL3", 80),new Liaison("MN0", "MN1", 80),new Liaison("MN1", "MN2", 80),new Liaison("MN2", "MN3", 80)};

    // tableau de type Liaison contenant les liaisons, le numero de la case
    // definit l'instance l'objet Liaison

    public static void calcLiaisons(String point) {
        pointsConnectes.clear();
        numPoint.clear();
        poidsLiaisons.clear();
        for (int i=0;i<liaison.length; i++) {
            // on teste le point 1 de toutes les variables Liaison du tableau
            if (liaison[i].getPoint1().equals(point)) {
                // si le point est celui entré en paramètre
                pointsConnectes.add(liaison[i].getPoint2());
                // on ajoute le point 2 de la variable Liaison
                poidsLiaisons.add(liaison[i].getPoids());
                // on ajoute le poids de la variable Liaison
                numPoint.add(i);
            }
        }
        for (int i=0;i<liaison.length;i++) {
            // on recommence en inversant les points 1 et 2 (comme ça on définit
            // une seule liaison qui fait 2 sens, au lieu de 2 qui font un sens
            // chacune)
            if (liaison[i].getPoint2().equals(point)) {
                pointsConnectes.add(liaison[i].getPoint1());
                poidsLiaisons.add(liaison[i].getPoids());
                numPoint.add(i);
            }
        }
    }

    public static String[] getConnectedPointsTo() {
        String[] tableau = new String[pointsConnectes.size()];
        for (int i = 0; i < pointsConnectes.size(); i++) {
            tableau[i] = pointsConnectes.get(i);
        }
        return tableau;
        // on retourne le tableau
    }

    public static int[] getPoidsLiaisonTo() {
        int[] tableau = new int[poidsLiaisons.size()];
        for (int i = 0; i < poidsLiaisons.size(); i++) {
            tableau[i] = poidsLiaisons.get(i);
        }
        return tableau;
    }

    public static int[] getPointNum() {
        int[] tableau = new int[numPoint.size()];
        for (int i = 0; i < numPoint.size(); i++) {
            tableau[i] = numPoint.get(i);
        }
        return tableau;
    }
}

