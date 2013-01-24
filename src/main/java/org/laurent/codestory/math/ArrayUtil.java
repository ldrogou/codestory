package org.laurent.codestory.math;

import java.math.BigDecimal;

public abstract class ArrayUtil {
    public static BigDecimal[] reverse(BigDecimal[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            // swap the values at the left and right indices
            BigDecimal temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            // move the left and right index pointers in toward the center
            left++;
            right--;
        }
        return data;
    }
}
