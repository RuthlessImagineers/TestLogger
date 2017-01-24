package com.ruthlessimagineers.testlogger.utils;

import java.util.Random;

/**
 * Created by krishnanand on 22/01/17.
 */
public class IndexGenerator {

    private String[] Beginning = { "Majestic", "Blue", "White", "Dragon", "Ice",
            "Cush", "Ikeiphotus", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
            "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
            "Mar", "Luk" };
    private String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
            "marac", "zoir", "slamar", "salmar", "urak" };
    private String[] End = { "Ambrosia", "Sorrel", "Hellebore", "Mint", "Morel", "Phrel", "Irahlolla",
            "tron", "med", "ure", "zur", "cred", "mur" };

    private Random rand = new Random();

    public String generateName() {

        return Beginning[rand.nextInt(Beginning.length)] +
//                Middle[rand.nextInt(Middle.length)]+
                End[rand.nextInt(End.length)];

    }
}
