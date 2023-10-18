package self.alg.sorting.topological_sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Solution2DFSTest {

    @Mock
    private Solution2BFSKahnOrInDegree.Node node;

    @Test
    void topologicalSort() {
        when(node.getName()).thenReturn(1);
        assertEquals(node.getName(), 1);
    }

    @Test
    void main() {
    }
}