
package com.jaredengler;

public class SortedArrayDeduplicator {

    public int removeDuplicates(int[] nums) {

        if (2 > nums.length)
            return nums.length;

        int pos = 0;
        int endPos = nums.length - 1;

        while (pos < endPos) {

            if (nums[pos] < nums[pos + 1])
                pos++;

            else {

                for (int i = pos; i < endPos; i++)
                    nums[i] = nums[i + 1];

                endPos--;
            }

        }

        return 1 + endPos;

    }

}
