package io.educative.two_pointers;

import java.util.Arrays;

/**
 * Intuition#
 *
 * First, let’s understand the problem. The total water the entire structure can hold is the sum of the amount of water each position can hold.
 *
 * Let’s draw a figure to visualize this. The water a position can hold is bound by the bottom of the two walls.
 *
 * Note that:
 *
 *     We want to update max_left_wall after we have updated left_walls[i].
 *     We only update total_water if the walls are taller than the current position’s elevation itself.
 * o(n)
 */
public class TrappingRainWater {
    public static int trappingRainWater(int[] elevations) {
        // WRITE YOUR BRILLIANT CODE HERE
        int leftMax = 0;
        int[] leftBorders = new int[elevations.length];
        for (int i = 0; i < elevations.length; i++) {
            leftBorders[i] = leftMax;
            leftMax = Math.max(leftMax, elevations[i]);
        }

        int rightMax = 0;
        int[] rightBorders = new int[elevations.length];
        for (int i = elevations.length - 1; i >= 0; i--) {
            rightBorders[i] = rightMax;
            rightMax = Math.max(rightMax, elevations[i]);
        }

        int waterCount = 0;
        for (int i = 0; i < elevations.length; i++) {
            int height = Math.min(leftBorders[i], rightBorders[i]);
            if (height - elevations[i] < 0) {
                continue;
            }
            waterCount += height - elevations[i];
        }

        return waterCount;
    }

    public static void main(String[] args) {
        String[] inputs = {"3 2 1 2 2 3 2","3 2 1 2 2 3"};
        for(int i = 0; i < inputs.length; i++) {
            int[] elevs = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println("Trapping rain water : "+trappingRainWater(elevs));
        }
    }
}
