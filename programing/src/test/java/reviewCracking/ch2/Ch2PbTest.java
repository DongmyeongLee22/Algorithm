package reviewCracking.ch2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Ch2PbTest {


    @Test
    public void rmoveDuplicateValueTest() throws Exception {
        Node root = new Node(3);
        root.next = new Node(4);
        root.next = new Node(5);
        root.next = new Node(7);
        root.next = new Node(3);
        root.next = new Node(5);

        Ch2Pb pb = new Ch2Pb();
        boolean result = pb.rmoveDuplicateValue(root);

        assertThat(result).isTrue();

        int count = 0;
        while (root != null) {
            count++;
            root = root.next;
        }

        assertThat(count).isEqualTo(2);

    }

    @Test
    public void rmoveDuplicateValueTest2() throws Exception {
        Node root = new Node(3);
        root.next = new Node(1);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(2);
        root.next.next.next.next.next = new Node(5);
        root.next.next.next.next.next.next = new Node(7);
        root.next.next.next.next.next.next.next = new Node(1);
        root.next.next.next.next.next.next.next.next = new Node(5);

        Ch2Pb pb = new Ch2Pb();
        boolean result = pb.rmoveDuplicateValue(root);

        assertThat(result).isTrue();

        int count = 0;
        while (root != null) {
            System.out.println(root.value);
            root = root.next;
        }
    }


    @Test
    public void findLastK() throws Exception {
        Node root = new Node(3);
        root.next = new Node(1);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(2);
        root.next.next.next.next.next = new Node(5);
        root.next.next.next.next.next.next = new Node(7);
        root.next.next.next.next.next.next.next = new Node(1);
        root.next.next.next.next.next.next.next.next = new Node(5);

        Ch2Pb pb = new Ch2Pb();
        int i = pb.countLastK(root, 3);
        assertThat(i).isEqualTo(7);
        }
    @Test
    public void link() throws Exception {
        Node root = new Node(3);
        root.next = new Node(5);
        root.next.next = new Node(2);
        root.next.next.next = new Node(1);
        root.next.next.next.next = new Node(4);
        root.next.next.next.next = new Node(2);

        Ch2Pb pb = new Ch2Pb();
        Node link = pb.Link(root, 4);

    }

    @Test
    public void sumNode() throws Exception {
        Node node1 = new Node(3);
        node1.next = new Node(5);
        node1.next.next = new Node(2);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(3);

        Ch2Pb pb = new Ch2Pb();
        Node link = pb.sumNode(node1, node2);

        assertThat(link.value).isEqualTo(4);
        assertThat(link.next.value).isEqualTo(7);
        assertThat(link.next.next.value).isEqualTo(5);

    }
}