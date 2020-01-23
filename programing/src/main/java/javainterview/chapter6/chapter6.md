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


>인터페이스 구현의 일부를 분리하면 클라이언트가 필터의 동작을 바꿔도 Stack 클래스는 변경될 필요가 없다. 그리고 인터페이스 구현은 분리되어 있어 Stack 없이도 독립적인 테스트가 가능해진다.

### 데커레이터 패턴
특정 객체의 기능을 설정하거나 변경할수 있게 해주는 패턴

즉 버튼을 추가하거나 스크롤 바에 기능을 추가하거나, 같은 재료로 만드는 샌드위치를 두 명의 고객에게 주문을 받았을 떄 어떻게 처리할지 등에 해당 된다.

JVM 외부 소스를 읽고 저장하는 입출력 클래스인 InputStream, OutputStream 클래스 그리고 하위클래스는 데커레이터 패턴을 사용한다.

<details>
<summary>데커레이터 패턴</summary>
<div markdown="1">

```java
@Test
public void decoratorPattern() throws Exception{
  File f = new File("target", "out.bin");
  FileOutputStream fos = new FileOutputStream(f);
  BufferedOutputStream bos = new BufferedOutputStream(fos);
  ObjectOutputStream oos = new ObjectOutputStream(bos);

  oos.writeBoolean(true);
  oos.writeInt(42);
  oos.writeObject(new ArrayList<Integer>());

  oos.flush();
  oos.close();
  bos.close();
  fos.close();
}
```

</div>
</details>

<br>

FileOutputStream 클래스는 디스크에 파일을 저장한다.

BufferedOutputStream 클래스는 파일을 저장하는 데 필요한 호출들을 캐시하고 한 번에 여러 바이트씩 저장한다. 이렇게 하면 나중에 저장시 효율이 향상됨

ObjectOutputStream은 자바에 내장된 객체나 primitive 타입을 스트림에 저장하는 직렬화 클래스이다.

스트림이란 자료의 입출력을 도와주는 중간 매개체를 말한다. 보통 파일, 키보드, 모니터, 메모리, 네트워크 연결 등 입출력과 관계된 모든것을 지칭한다.

테스크 코드를 보면 ObjectOutputStream 클래스가 어디에 기록되는지 알수 없다. 다른 OutputStream에 저장권한을 위임할 뿐이다. 이런게 데커레이터 패턴의 강력함이다. 즉 새로운 OutputStream 클래스 구현을 제공하더라도 기존의 코드와 함께 잘 작동한다.

### 플라이웨이트 패턴
몇개의 객체에 많은 값을 공유해야할 때 유용하다.
이런 인스턴스들은 객체가 없어지지 않으면 해당 값들을 공유할 수 있다.
<details>
<summary>Integer.valueOf</summary>
<div markdown="1">

```java
public static Integer valueOf(int i){
  assert IntegerCache.high >= 127;
  if(i >= IntegerCache.low && i <= IntegerCache.high){
    return IntegerCache.cache[i + (-IntegerCache.low)];
  }

  return new Integer(i);
}
```

</div>
</details>

<br>

valueOf 메서드는 주어진 매개변수의 값을 확인하고 이전에 캐시된 값이라면 새로운 사본 인스턴스를 만들지 않고 이전에 생성해준 인스턴스를 반환한다.

캐시의 기본범위는 -128 ~ 127까지이다.
<details>
<summary>Test</summary>
<div markdown="1">

```java
@Test
public void sameInteger(){
    Integer a = Integer.valueOf(56);
    Integer b = Integer.valueOf(56);
    assertThat(a).isSameAs(b);

    Integer c = 56;
    Integer d = 56;
    assertThat(c).isSameAs(d);

    Integer e = new Integer(56);
    Integer f = new Integer(56);
    assertThat(e).isNotSameAs(f);

    Integer g = Integer.valueOf(330);
    Integer h = Integer.valueOf(330);
    assertThat(g).isNotSameAs(h);

    Integer i = 330;
    Integer j = 330;
    assertThat(g).isNotSameAs(h);
}
```

</div>
</details>

 <br>

테스트를 돌려보면 값을 바로 넣은건 valueOf가 적용되는거 같다. valueOf는 127까지 캐시하므로 330은 다른 인스턴스가 되고 new는 어떤 값이든 다른 인스턴스가 된다.

그밖에 플라이웨이트 패턴은 Null 객체 패턴에서 유용하다.

이진트리에서 리프노드들을 Null 객체로 만들면 유용하게 사용할 수 있다.

### 싱글턴 패턴
클래스가 오직 하나의 인스턴스만 생성한다는 것을 보장하는 패턴이다.

보통 디비나 웹 서비스 같은 여러 서드파티에서 해당 인스턴스에 접근할 수 있는 유일한 지점을 만드는데 사용한다.

다수 서비스에서 보내는 연결 요청을 한 곳에서 쉽게 관리하고 설정할 수 있다는 장점이 있다.

```java
public class SingleTon{
  private static SingleTon INSTANCE;

  public static SigleTone getInstance(){
    if(INSTANCE == null){
      INSTACNE = new SingleTon();
    }

    return INSTANCE;
  }
}
// if가 돌고 있을 때 다른 사람이 호출하면 새로운 객체를 반환한다.

public enum SingletonEnum{
  INSTANCE,

  public void singletonMethod(){

  }
}
//enum을 사용하면 하나의 인스턴스를 만드든 것을 보장한다.
```
싱글턴 인스턴스로 디비 저장 같은 무거운 연산을 실행할 경우 작은 코드 부분 단위로 분리해서 테스트하기가 어렵다.

### 요약
