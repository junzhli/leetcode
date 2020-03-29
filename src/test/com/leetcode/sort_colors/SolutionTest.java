package com.leetcode.sort_colors;

import com.sun.tools.corba.se.idl.InvalidArgument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortColors() throws InvalidArgument {
        Solution sol = new Solution();
        sol.sortColors(new int[]{0, 2, 1,0,0});
    }
}