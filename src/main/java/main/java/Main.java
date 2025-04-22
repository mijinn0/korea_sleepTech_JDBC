package main.java;

import main.java.manager.MemberManager;

public class Main {
    public static void main(String[] args) {
        MemberManager mm = new MemberManager();

        try {
            mm.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}