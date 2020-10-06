package nextstep.ladder.ui;

import nextstep.ladder.domain.Lane;
import nextstep.ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Player> getPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return mapToPlayer(SCANNER.nextLine().split(DELIMITER));
    }

    private static List<Player> mapToPlayer(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(i -> Player.of(names[i].trim(), Lane.of(i)))
                .collect(Collectors.toList());
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height;
        try {
            height = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            height = getHeight();
        }
        return height;
    }

    public static List<String> getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String getPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine().trim();
    }
}