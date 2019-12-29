# 객체 지향 설계
## 디자인 패턴
### 싱글톤 패턴
- 정확히 하나만 생성되어야 하는 전역 객체를 구현해야 할 떄 유용하다.
- 단위 테스트에 방해되는 요인으로 이 패턴을 싫어하는 사람들도 많다.
```java
public Restaurant{
  private static Restaurant instance = null;
  protected Restaurant(){

  }

  public static getInstance(){
    if(instance == null){
      instance = new Restaurant();
    }
    return instance;
  }
}
```
### 블랙잭 구현
- 16 이하면 카드 하나 더
- A는 1일수도 11일수도
- 영어는 10
- 21이 넘어가면 진다
- 덱, 카드, 핸드
- 객체지향으로 생각하자