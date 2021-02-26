package org.academiadecodigo.cachealots.epic;

import java.io.IOException;

public class EpicStart {

    public static void main(String[] args) {

        try {
            new Histouria().start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


