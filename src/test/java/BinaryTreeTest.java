import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BinaryTree")
class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(2);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(10);
    }

    @DisplayName("값이 있는지 확인")
    @Test
    void find() {
        assertThat(binaryTree.find(7)).isTrue();
        assertThat(binaryTree.find(10)).isFalse();
    }

    @DisplayName("삭제 테스트")
    @Test
    void delete() {
        binaryTree.delete(9);

        assertThat(binaryTree.find(9)).isFalse();

        binaryTree.delete(7);
        assertThat(binaryTree.find(7)).isFalse();
    }

    @DisplayName("DFS 중위순회, LEFT -> ROOT-> RIGHT 순으로 순회한다")
    @Test
    void dfs() {
        assertThat(binaryTree.dfsInOrder()).isEqualTo(Arrays.asList(2, 4, 5, 6, 7, 8, 10));
    }

    @DisplayName("BFS 탐색")
    @Test
    void bfs() {
        assertThat(binaryTree.bfs()).isEqualTo(Arrays.asList(6, 4, 8, 2, 5, 7, 10));
    }


}
