package com.appmakecolorrgb.hieu;

import javax.swing.*;

public class run {

    public static void main(String[] args) {
        App app;

        try {
            app = new App();
            app.run();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }


}
