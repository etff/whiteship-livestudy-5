import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

@DisplayName("BinaryTree")
class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);
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

}
