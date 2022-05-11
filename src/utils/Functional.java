package utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functional {
    public static <T, Z> List<Z> mapList(List<T> list, Function<T, Z> f) {
        return list.stream().map(f).collect(Collectors.toList());
    }

    public static <T> List<T> filterList(List<T> list, Function<T, Boolean> f) {
        return list.stream().filter(f::apply).collect(Collectors.toList());
    }
}
