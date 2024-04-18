package net.online.school.matrix;

import java.util.HashSet;
import java.util.*;

public class MatrixNonSimilarRows {

    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> key = new HashMap<>();
        for (int[] elem : matrix) {
            SortedSet<Integer> temp1 = new TreeSet<>();
            for (int num : elem) {
                temp1.add(num);
            }
            if(!key.containsKey(temp1)){
                key.put(temp1, elem);
            }
        }
        return new HashSet<>(key.values());
    }
}
