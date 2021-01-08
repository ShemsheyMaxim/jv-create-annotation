package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandlerImpl {
    private final BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("стоп")) {
                System.out.println(betDao.getAll());
                return;
            }
            Bet bet;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Пожалуйста, введите валидные данные: "
                        + "сумму(число) и коеффициент(число) через пробел для для вашей ставки");
                continue;
            }
            betDao.add(bet);
            System.out.println(bet);
            System.out.println("Введите ещё одну ставку или введите \"стоп\" "
                    + "чтобы завершить работу");
        }
    }
}
