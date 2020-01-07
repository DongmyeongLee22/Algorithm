package javainterview;

import javainterview.chapter5.SimpleTree;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTreeTest {

    @Test
    public void BinaryTreeTest() throws Exception {
        //given
        SimpleTree<Integer> simpleTree = new SimpleTree<>(7);
        simpleTree.insert(3);
        simpleTree.insert(9);
        simpleTree.insert(8);
        simpleTree.insert(1);

        // then

        assertThat(simpleTree.search(10)).isFalse();
        assertThat(simpleTree.search(7)).isTrue();
        assertThat(simpleTree.getRight().getLeft().getValue()).isEqualTo(8);
    }

    @Test
    public void treeMapTraversal() throws Exception {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(4, "f");
        treeMap.put(3, "t");
        treeMap.put(1, "o");
        treeMap.put(2, "t");

        Iterator<Integer> treeMapKeys = treeMap.keySet().iterator();
        assertThat(treeMapKeys.next()).isEqualTo(1);
        assertThat(treeMapKeys.next()).isEqualTo(2);
        assertThat(treeMapKeys.next()).isEqualTo(3);
        assertThat(treeMapKeys.next()).isEqualTo(4);
    }

    @Test
    public void linkedHashMapTraversal() throws Exception {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(4, "f");
        linkedHashMap.put(3, "t");
        linkedHashMap.put(1, "o");
        linkedHashMap.put(2, "t");

        Iterator<Integer> treeMapKeys = linkedHashMap.keySet().iterator();
        assertThat(treeMapKeys.next()).isEqualTo(4);
        assertThat(treeMapKeys.next()).isEqualTo(3);
        assertThat(treeMapKeys.next()).isEqualTo(1);
        assertThat(treeMapKeys.next()).isEqualTo(2);
    }

@Test
public void setExample(){
    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("d");
    set.add("a");
    set.add("e");

    assertThat(set.size()).isEqualTo(3);
}
}