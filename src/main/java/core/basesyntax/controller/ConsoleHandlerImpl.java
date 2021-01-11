package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandlerImpl {
    private static final String STOP = "stop";
    private final BetDao betDao = new BetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public void handleBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(STOP)) {
                break;
            }
            Bet bet;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please, enter valid data: amount(number) "
                        + "and coefficient(number) with whitespace for your bet.");
                continue;
            }
            betDao.add(bet);
            System.out.println(bet);
            System.out.println("Enter one more bet or enter \"stop\" for quit");
        }
        System.out.println(userDao.getAll());
        System.out.println(betDao.getAll());
    }

    public void handleUser() {
        Scanner scanner = new Scanner(System.in);
        User user;
        while (true) {
            String command = scanner.nextLine();
            try {
                String[] split = command.split(" ");
                String firstName = split[0];
                String lastName = split[1];
                String phoneNumber = split[2];
                user = new User(firstName, lastName, Integer.parseInt(phoneNumber));
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please, enter valid data: firstName, lastName "
                        + " and phone should contains 12 numbers"
                        + "with whitespace for registered user");
            }
        }
        userDao.add(user);
    }
}

