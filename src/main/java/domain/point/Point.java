package domain.point;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by hspark on 18/11/2018.
 */
public final class Point {
	private static Map<Integer, Point> CACHE = new HashMap<>();
	private final int point;

	private Point(int point) {
		this.point = point;
	}

	public static Point of(int pointValue) {
		Point cachePoint = CACHE.get(pointValue);
		if (Objects.nonNull(cachePoint)) {
			return cachePoint;
		}
		Point point = new Point(pointValue);
		CACHE.put(pointValue, point);
		return point;
	}

	public boolean isAdjacent(Point other) {
		return Math.abs(point - other.point) == 1;
	}

	public int getDiff(Point other) {
		return point - other.point;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Point point1 = (Point) o;

		return point == point1.point;
	}

	@Override
	public int hashCode() {
		return point;
	}
}
