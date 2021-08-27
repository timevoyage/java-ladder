package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public static Ladder create(int height, int size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.init(size));
        }
        return new Ladder(lines);
    }

    public Ladder(List<Line> lines) {
        this.lines.addAll(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int movedIndex(int index) {
        int movedIndex = index;
        for (Line line : lines) {
            movedIndex = line.movedIndex(movedIndex);
        }
        return movedIndex;
    }

    @Override
    public String toString() {
        return "Ladder {" +
                "    lines = " + lines + ",\n" +
                '}';
    }
}
