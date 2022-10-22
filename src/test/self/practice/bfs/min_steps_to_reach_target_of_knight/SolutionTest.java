package self.practice.bfs.min_steps_to_reach_target_of_knight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minStep() {
        Solution sol = new Solution();
        assertEquals( 20, sol.minStep(1, 1, 30, 30, 100));
        assertEquals( 3, sol.minStep(4, 5, 1, 1, 100));
    }
}