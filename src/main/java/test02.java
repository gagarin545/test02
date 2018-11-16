import java.util.*;
import java.util.function.Function;

public class test02 {
    private static Function<Integer[], Integer> get_max_value = (n) -> {
        int m = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[m] < n[i]) m = i;
        }
        return m;
    };


    private static LinkedHashSet<String> t = new LinkedHashSet<>();

    public static void main(String[] args) {
        int record = 0;
        Integer[] line = {0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11};

        while(t.add( Arrays.toString(line).replace(" ,", ""))) {
            line = next_value( line);
        }

        for(int i: line)
            System.out.print(i + " ");

        int count=0;
        for(String i : t)
                if(i.equals(Arrays.toString(line).replace(" ,", "")))
                    break;
                else
                    count++;

        System.out.println(t.size() - count + " " + t.size());
    }

    private static Integer[] next_value(Integer[] k) {
        int i, n;
        Integer[] s = new Integer[k.length];
        for( i = 0; i < s.length; i++) s[i] = k[i];
        for (n = get_max_value.apply(s) + 1, i = s[n-1], s[n-1] = 0; i > 0; i--) {
            if (n == s.length) n = 0;
            s[n++]++;
        }
        return s;
    }
}
