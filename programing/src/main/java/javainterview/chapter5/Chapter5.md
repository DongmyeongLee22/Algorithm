# 리스트
특정 타입값들이 순차적으로 정렬된 자료구조이며 크기 지정에 한계가 없다.
자바에서는 ArrayList, LinkedList 클래스로 일반적으로 구현하며 두개를 시기적절하게 사용해야 한다.

### 배열과 리스트의 관계
배열은 정의할 때 크기를 지정해야 한다. JVM은 배열이 생성될 때 반드시 배열의 크기를 알아야 한다. 그러하여 인덱스 값을 이용해 직접 접근이 가능하며 이를 **랜덤 접근** 이라고 한다.

ArrayList는 리스트의 데이터로 배열을 사용하는 List 인터페이스 구현체다.

ArrayList의 초기 크기는 지정하지 않으면 10이다. 가득 찰때마다 크기를 늘리므로 큰 컬렉션을 사용할거라면 미리 크기를 정해주는게 좋다.

ArrayList 클래스로 생성한 배열의 시작 위치나 중간 위치에 새로운 원소를 추가하려고 하면 다음에 있는 모든 원소들이 이동해야 한다.

크기 재할당도 마찬가지이며 단방향으로 이루어 진다.

ArrayList 클래스로 생성한 배열은 원소를 많이 삭제해도 배열의 크기가 줄어들지 않으므로 원소의 개수가 자주 바뀌면 LinkedList를 사용하는게 좋다

LinkedList는 연결 리스트를 구현할 수 있는 또 다른 리스트 구현체로 원소들을 저장하는 데 배열을 이용하지 않고 리스트 안에서 다음 원소를 가리키는 내부 객체를 이용한다.

간단한 LinkedList
```java
public class SimpleLinkedList<E> {
  private static class Element<E>{
    E value;
    Element<E> next;
  }

  private Element<E> head;
}
```

#### 배열과 연결리스트의 장단점
배열
- ArrayList는 특정 인덱스의 값을 가져오는 시간이 O(1)이다.
- 하지만 처음이나 중간에 값을 넣으면 그 다음 값들을 다 한칸씩 뒤로 땡겨야 하므로 삽입시 O(n) 시간이 걸린다.

연결리스트
- 어떤 인덱스의 값을 찾기 위해서는 O(n) 시간이 걸릴 수 있다.
- 허나 값을 삽입 삭제하는 시간은 O(1)이다.

<br>
그러므로 리스트의 첫부분이나 중간에 원소를 삽입, 삭제할 일이 많다면 LinkedList로 구현된 List를 사용하고 List에 접근할 일이 많다면 ArrayList로 구현하면 된다.

그리고 LinkedList는 배열 재할당 과정도 없으므로 그런 측면에서도 우수하다.

### Queue와 Deque는 무었인가?
Queue는 일반적인 선입선출 자료구조이며 LinkedList로 구현된다.
Deque(덱)은 Queue 인터페이스의 확장으로 자료구조 양끝에 원소를 추가 삭제 가능하다.

---

# 트리
노드로 이루어져 자식들을 가질수 있는 자료구조이며 사이클이 존재할 수 없는 자료구조 이다.

트리는 최악, 평균 수행 시간이 크게 다를 수 있으므로 주의가 필요하다.

### 이진트리
각 노드가 최대 두 개의 자식을 갖는 트리

모든 트리가 이진 트리는 아니다!
```java
public class SimpleTree<E extends Comparable> {
    private E value;
    private SimpleTree<E> left;
    private SimpleTree<E> right;

    public SimpleTree(E value) {
        this.value = value;
        left = null;
        right = null;

    }

    // 값 찾기
    public boolean search(final E toFind) {
        if (toFind.equals(value)) {
            return true;
        }

        if (toFind.compareTo(value) > 0 && right != null) {
            return right.search(toFind);
        }

        return left != null && left.search(toFind);
    }

    // 이진트리 값 삽입
    public void insert(final E toInsert) {
        if (toInsert.compareTo(value) < 0) {
            if (left == null) {
                left = new SimpleTree<>(toInsert);
            } else {
                left.insert(toInsert);
            }
        } else {
            if (right == null) {
                right = new SimpleTree<>(toInsert);
            } else {
                right.insert(toInsert);
            }
        }
    }
}

@Test
public void BinaryTreeTest() throws Exception{
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
```

NULL 객체 패턴을 이용해 메서드를 단순화 시켜 null 확인과정을 제외 시킬 수 있다.
```java
public interface Tree<E extends Comparable> {
    boolean search(E toFind);
}

class Node<E extends Comparable> implements Tree<E>{

    private E value;
    private Tree<E> right;
    private Tree<E> left;

    public Node(E value) {
        this.value = value;
        right = new Leaf<>();
        left = new Leaf<>();
    }

    @Override
    public boolean search(E toFind) {
        if (toFind.equals(value)){
            return true;
        }

        if (toFind.compareTo(value) > 0){
            return right.search(toFind);
        }

        return left.search(toFind);
    }
}

class Leaf<E extends Comparable> implements Tree<E>{

    @Override
    public boolean search(E toFind) {
        return false;
    }
}
```
일반 이진트리는 입력 값에따라 비효율적인 모양이 될 수있다. 그렇게하여 생긴게 AVL트리로 균형을 맞춰주는 트리이다.

### AVL 트리
모든 노드는 자식의 깊이 차이가 1을 넘지 않는다.



### 이진트리 VS 이진 탐색트리
이진 탐색트리는 모든 왼쪽 자식 < root < 모든 오른쪽 자식을 만족해야 한다.
모든 이진트리가 이진 탐색트리라고 생각하지 말자

### 균형 VS 비균형
균형인지 아닌지를 잘 판단해야한다.
균형트리는 AVL, 레드 블랙 트리가 있다.

### 힙
이진 트리는 힙으로도 사용된다. 

최소힙은 완전 이진트리이면서 부모의 값이 자식의 값보다 작아야 한다.

힙은 순서를 가진 큐나 리스트의 가장 작거나 큰값에 접근해야하는 경우 유용하다. 

이것을 통해 우선순위 큐는 힙으로 구현되는 것을 알수있다.

### 완전 이진트리
마지막 레벨을 제외한 모든 노드가 꽉 차있고 마지막 레벨은 노드가 왼쪽부터 채워진 트리

### 전 이진 트리
모든 노드의 자식이 없거나 정확히 두 개 있는 트리

### 포화 이진 트리
모든 노드가 꽉 차있는 트리
2^n-1^개의 노드가 존재. (n은 높이)

### 이진트리 순회
1. in-order traversal(중위 순회)
2. pre-order traversal(전위 순회)
3. post-order traversal(후위 순회)

---

# 맵
해시라고도 하며, 배열이나 사전과 관련 있는 key-value 형태의 저장소이다.

자료구조 내부의 원소는 관련된 값을 반환하는 키를 통해 찾을 수 있다.

자바 API Map 인터페이스는 컬렉션 API의 일부지만 List와 달리 Collection 인터페이스를 구현하지 않는다.

물론 자료구조 크기와 키-값 쌍을 읽고, 추가하고, 삭제할 수 있는 일반적인 연산 구현을 한다는 점은 List, Map 둘 다 비슷하다.

맵의 특징 중하나는 키 값은 트리 상에서 한번만 나타나는 것이다.

#### HashMap
Map은 보통 HashMap으로 구현한다.

HashMap 클래스는 해시 테이블을 자바로 구현한 것이다.

해시코드의 특징은 어떤 같은 인스턴스로부터 해시코드를 구하면 같은 해시코드 값이 나와야하지만 그 반대는 성립되지 않는다.

hashCode로 구한 값을 hashfunction을 통해 충돌을 방지할 있고 연결리스트를 통해 체이닝 하는 방법도 있다.

#### TreeMap
Map은 TreeMap으로 구현되기도 한다. TreeMap은 이진 트리 자료구조를 이용한다.

트리의 각노드가 키-값 쌍이 되며 Comparable 혹은 Comparator 인터페이스를 구현하고 있다.

TreeMap은 키를 정렬 가능한 순서에 따라 정하므로 hashCode 메서드를 사용하지 않고 균형을 맞춘 트리구조로 구성되어 있어 검색, 삽입, 삭제등 모두 O(logn)의 성능을 발휘한다.

#### HashMap vs TreeMap
TreeMap에서는 컬렉션이 순서대로 저장되므로 전체 컬렉션을 반복 순회할 때 키의 순서가 보존된다.

HashMap은 hashCode 메서드 값에 따라 저장되므로 키의 순서를 보존하지 않는다. 
```java
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
```

#### LinkedHashMap
LinkedHashMap으로도 Map을 구현할 수 있다. 기본적으로 HashMap과 같은 방식으로 동작하므로 원소를 찾는 시간이 O(1)이다.

하나 특징이 있다면 key를 순회하면 삽입한 순서와 같다는 것이다.
```java
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
```
#### ConcureentHashMap
Map의 마지막 구현방법이다.

맵 인스턴스를 많은 스레드에서 공유하고자 한다면 이 방법이 유용하다.

Thread Safe하고, 맵에 값을 쓰는 도중에도 값을 읽어서 반환할 수 있도록 설계되어 있다.
값을 쓰는 동안에는 테이블의 지정된 줄만 잠기고 맵의 나머지는 읽기 가능한 상태로 남겨 둔다.

ConcureentHashMap은 기존 Map과는 약간 다르다. size 메서드는 맵의 예상 크기를 반환하는데 그 이유는 현재 진행 중인 모든 쓰기 작업을 고려하지 않기 때문이다.

---

# 집합
집합(SET)은 중복을 허용하지 않는 순서 없는 객체들의 모음이다.

자바 컬렉션 API에는 Set 인터페이스가 있다. Collection 인터페이스를 확장하고 집합을 찾고 수정하는 메서드들을 제공한다.
```java
@Test
public void setExample(){
    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("d");
    set.add("a");
    set.add("e");

    assertThat(set.size()).isEqualTo(3);
}
````

맵에서 언급한 HashSet, TreeSet, LinkedHashSet 등으로 구현이 가능하다. 단지 ConcureentHashSet은 존재하지 않는다. 

하지만 Collection 클래스에 netSetFromMap이라는 정적메서드가 있으므로 Map을 Set으로 변형하여 사용할 수도 있다.