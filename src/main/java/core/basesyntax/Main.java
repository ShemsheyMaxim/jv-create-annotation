package core.basesyntax;

import core.basesyntax.controller.ConsoleHandlerImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleHandlerImpl handler = new ConsoleHandlerImpl();
        System.out.println("Enter firstName, lastName and phone number");
        handler.handleUser();
        System.out.println("Enter the amount and coefficient for your bet.");
        handler.handleBet();
    }
}
