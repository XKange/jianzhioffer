import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by kangkang on 2017/12/23
 * 字符串排列
 */
public class problem_28 {
    public ArrayList Permutation(String str) {
        ArrayList res = new ArrayList();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    public void PermutationHelper(char[] cs, int i, ArrayList list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }

    private static void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
