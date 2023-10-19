package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    List<Integer> numbers;
    boolean gameStatus;

    public User() {
        this.gameStatus = true;
    }

    public void getNumbersFromUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumbersFromUser(input);
        this.numbers = convertStringToIntList(input);
    }

    public void validateNumbersFromUser(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(
                2)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertStringToIntList(String input) {
        List<Integer> numberList = new ArrayList<>();
        String[] split = input.split("");
        for (String number : split) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

}
