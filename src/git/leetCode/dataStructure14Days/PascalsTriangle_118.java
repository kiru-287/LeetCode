package git.leetCode.dataStructure14Days;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

    public static void main(String[] args) {
        generate(5); //[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        generate(1); //[[1]]
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row;
        int pos = 0;

        for(int i=0 ; i<numRows ; i++) {
            row = new ArrayList<>();
            while (pos <= i) {
                if(pos == 0 || pos == i) {
                    row.add(1);
                }else {
                    row.add(res.get(i-1).get(pos) + res.get(i-1).get(pos-1));
                }
                pos += 1;
            }
            pos = 0;
            res.add(row);
        }
        return res;
    }
}
