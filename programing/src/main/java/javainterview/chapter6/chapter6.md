# 디자인 패턴
디자인 패턴은 프로그램을 만들면서 발생할 수 있는 다양한 상황에 효율적으로 적용할 수 있는 해결책이다.

보통 하나 이상의 객체를 함께 사용하며 코드 재사용, 확장성에 초점을 두거나 앞으로 개발할 때 필요한 견고한 기반을 제공한다는 점에서 디자인 패턴은 많은 도움이 된다.

자바 표준 라이브러리 API를 통해 많은 디자인 패턴들 이용할수 있다.

### 빌더 패턴은 얼마나 유용한가?
필드가 많은 객체를 생성할 경우 빌더패턴을 사용하면 명시적으로 어떤 필드에 값을 설정했는지 알수 있다.

그리고 보통 필드가 많다면 다양한 생성자를 가지게 될텐데 빌더 패턴을 사용하면 그럴 필요가 없다.
<details>
<summary>코드 보기</summary>
<div markdown="1">

```java
public class Member {

    private String name;
    private String email;
    private Integer age;

    public Member(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // =========================== builder pattern ========================== //
    public static class Builder{
        private String name;
        private String email;
        private Integer age;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withAge(int age){
            this.age = age;
            return this;
        }
        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Member build(){
            if (name != null && email != null && age != null){
                return new Member(name, email, age);
            }

            throw new IllegalArgumentException("필드의 모든 값을 넣어주세요");
        }
    }
}

// ================================= TEST ================================= //
@Test
public void buildSuccess() throws Exception{
    //given
    Member.Builder builder = new Member.Builder();
    String name = "james";
    String email = "asdq@email.com";
    int age = 10;

    //when
    Member james = builder.withName(name)
            .withEmail(email)
            .withAge(age)
            .build();

    //then
    assertThat(james.getAge()).isEqualTo(age);
    assertThat(james.getName()).isEqualTo(name);
    assertThat(james.getEmail()).isEqualTo(email);
}

@Test(expected = IllegalArgumentException.class)
public void buidlWithException() throws Exception{

    Member.Builder builder = new Member.Builder();
    String name = "james";
    String email = "asdq@email.com";

    Member james = builder.withName(name)
            .withEmail(email)
            .build();

}
```

</div>
</details>
<br>
### 스트래티지 패턴
지정된 알고리즘의 세부 구현을 변경할 필요 없이 쉽게 교환할 수 있게 해주는 디자인 패턴이다.

실행 중이라도 구현된 알고리즘을 교환할 수 있으므로 의존성 주입에 자주 사용된다.

의존성 주입은 테스트용 코드에서 구현된 알고리즘을 교환하거나 Mock구현을 사용할 수 있게 해준다.

<details>
<summary>스트래티지 패턴으로 로거 만들기
</summary>
<div markdown="1">

```java
public interface StrategyLogger {
    void write(String message);
}

// ======================== Console Log  ======================== //
class ConsoleLogging implements StrategyLogger{

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}

// ======================== File Log  ======================== //
class FileLogging implements StrategyLogger{

    private File toWrite;

    public FileLogging(File toWrite){
        this.toWrite = toWrite;
    }

    @Override
    public void write(String message) {
        try{
            FileWriter fileWriter = new FileWriter(toWrite);
            fileWriter.write(message);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

</div>
</details>

<details>
<summary>스트래티지 패턴으로 로거 만들기 테스트
</summary>
<div markdown="1">

```java
public class Client {
    private StrategyLogger logger;

    public Client(StrategyLogger logger) {
        this.logger = logger;
    }

    public void doWork(int count){
        if (count % 2 ==0){
            logger.write("Count is: " + count);
        }
    }
}

// ============================= TEST ============================= //
public class ClientTest {

    @Test
    public void consoleLog() throws Exception{
        Client client = new Client(new ConsoleLogging());
        client.doWork(12);
        client.doWork(11);
    }

    @Test
    public void fileLog() throws Exception{
        File tempFile = File.createTempFile("test", "log");
        Client client = new Client(new FileLogging(tempFile));
        client.doWork(22);
        client.doWork(23);
        client.doWork(25);

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertThat(reader.readLine()).isEqualTo("Count is: 22");
    }

    @Test
    public void LogWithMock() throws Exception{
        StrategyLogger mockLogger = mock(StrategyLogger.class);
        Client client = new Client(mockLogger);
        client.doWork(1);
        client.doWork(2);
        verify(mockLogger).write("Count is: 2");
    }

}
```

</div>
</details>

### 템플릿 메서드 패턴
알고리즘의 일부 또는 전부를 하위 클래스에서 구현하거나 위임하는데 사용한다.

즉 공통으로 사용하는 알고리즘은 부모클래스에 정의하고, 특정 부분에서 사용하는 알고리즘은 하위 클래스에서 수행하도록 설계하는 것

<details>
<summary>템플릿 메서드 예제</summary>
<div markdown="1">

<br>

StackPredicate 라는 인터페이스의 구현은 클라이언트 코드에서 하도록 수행하여 템플릿 메서드를 구현했다.

```java
public class Stack {

    private LinkedList<Integer> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public Stack(LinkedList<Integer> initial){
        this.stack = initial;
    }

    public void push(int value){
        stack.add(0, value);
    }

    public Integer pop(){
        return stack.remove(0);
    }

    public Stack filter(StackPredicate filter){
        LinkedList<Integer> initialState = new LinkedList<>();
        for (Integer integer : stack) {
            if (filter.isValid(integer)){
                initialState.add(integer);
            }
        }

        return new Stack(initialState);
    }
}

interface StackPredicate{
    boolean isValid(int value);
}
```
<br>

테스트 코드
```java
public class StackPredicateTest {

    private Stack stack;

    @Before
    public void createStack(){
        stack = new Stack();
        IntStream.rangeClosed(1, 10).forEach(i -> stack.push(i));
    }

    @Test
    public void evenPredicate() throws Exception{
        Stack filter = stack.filter(new StackPredicate() {
            @Override
            public boolean isValid(int value) {
                return value % 2 == 0;
            }
        });

        assertThat(filter.pop()).isEqualTo(10);
        assertThat(filter.pop()).isEqualTo(8);
        assertThat(filter.pop()).isEqualTo(6);
    }

    @Test
    public void oddPredicate() throws Exception{
        Stack filter = stack.filter(value -> value % 2 == 1);

        assertThat(filter.pop()).isEqualTo(9);
        assertThat(filter.pop()).isEqualTo(7);
        assertThat(filter.pop()).isEqualTo(5);
    }
}
```
</div>
</details>

<br>

>인터페이스 구현의 일부를 분리하면 클라이언트가 필터의 동작을 바꿔도 Stack 클래스는 변경될 필요가 없다. 그리고 인터페이스 구현은 분리되어 있어 Stack 없이도 테스트가 가능해진다.
