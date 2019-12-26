# 비트조작

비트조작은 다양한 문제에서 활용된다. 비트 조작을 명시적으로 요구하는 문제도 있지만 코드를 최적화 할 떄 유용하게 사용되는 기법을 활용 된다.
> 비트 조작은 실수하기 쉬우므로 손으로 그릴수 있도록 익숙해지는게 좋다

- 뺄셈은 2의보수 사용하자
  - 1000 - 0110 = 0010 ==> 1000 + 1010 = 0010
  - 0110 - 0011 = 0011


- 쉬프트 연산
  - 1101 >> 2 = 0011


- ^(XOR), ~(NOT)
  - 1101 ^ (~1101) = 1101 ^ 0010 = 1111


- &(AND)
  - 1011 & (~0 << 2) = 1011 & 1100 = 1000

### 알면 좋은 트릭들
- x ^ 0s = x
  - 1010 ^ 0000 = 1010


- x ^ 1s = ~
  - 1010 ^ 1111 = 0101 = ~x


- x | x = x
  - 1010 | 1010 = 1010

### 산술 우측 시프트 vs 논리 우측 시프트
- 산술 우축 시프트: >>
  - x = 10110101(-75)
  - x >>= 1;  결과: 11011010 (-38)
  - 즉 부호비트를 바꾸지 않으므로 값이 1/2가 된다.
- 논리 우측 시프트: >>>
  - x = 10110101(-75)
  - x >>>= 1;  결과: 01011010 (90)
  - 즉 최상위 비트에 0을 채운다.

#### **비트값 확인**
\- 1을 i번 << 시프트시키고 num과 AND 연산
\- 예를들어 i가 3이면 1000이 된다.
\- num에 i번째 비트가 1이면 참, 아니면 거짓
```java
boolean getBit(int num, int i){
  return ((num & (1 << i)) != 0);
}
```
#### **비트값 채워넣기**
\- i번째 비트만 OR로 값을 변경할 수 있다.
\- 물론 이미 그 비트 값이 1이면 소용없다
```java
int setBit(int num, int i){
  return num | (1 << i);
}
```
#### 비트값 삭제하기
**\- i번째 비트만 삭제하기****
\- setBit을 반대로 한 것과 같다. NOT(~)을 이용해 비트를 뒤집고 AND하면 i번째 값만 0이 된다.
```java
int clearBit(int num, int i){
  int mask = ~(1 << i);
  return num & mask;
}
```
<br>

**\- 최상위 비트에서 i번째 비트까지 삭제하기**
\- (1 << i)한 값이 0001000일 때 여기서 1을 빼면 0000111이된다.
\- 이 값을 AND 연산하면 된다.
```java
int clearBitsMSBthroughI(int num, int i){
  int mask = (1 << i) - 1;
  return num & mask;
}
```
<br>

**\- i번째 비트에서 0번째 비트를 모두 삭제하기**
\- (-1)은 모든 비트가 1이므로 여기서 i+1만큼 시프트 후 AND 연산
```java
int clearBitIThrough0(int num, int i){
  int mask = (-1 << i + 1);
  return num & mask;
}
```
#### 비트값 바꾸기
\- i번째 비트값을 v로 바꾸기
\- 우선 바꿀 비트가 1인지 0인지 확인
\- i번째 비트값을 0으로 만든다.
\- 그 후 바꿀 비트를 i만큼 << 해서 OR 연산하면 된다.
```java
int updateBit(int num, int i, boolean bitBoolean){
  int value = bitBoolean ? 1 : 0;
  int mask = ~(1 << i);
  return (num & mask) | (value << i);
}
```

---

## 문제
#### 1. 삽입
\- 두개의 32비트 수 N, M이 주어지고 비트 위치 i, j가 주어졌을 때 M을 N에 삽입하라
\- M을 담을 공간은 충분하고 i, j는 삽입할 수 있는 위치이다.
\- N = 10000, M = 101, i = 1, j = 3 일경우 정답은 11010
&nbsp;&nbsp;&nbsp;&nbsp; \- 1. N의 j+1 ~ i+1 번째의 비트를 0으로 만든다.
&nbsp;&nbsp;&nbsp;&nbsp; \- 2. M을 i번 << 해서 위치시킨다.
&nbsp;&nbsp;&nbsp;&nbsp; \- 3. N OR M

```java
int insertBit(int N, int M, int i, int j) {
    // N = 10000, M = 101
    // i = 1, j = 3이라고 생각하자

    int left = (-1 << j + 1); // 11111 << 4 = 10000
    int right = (1 << i) - 1; // 00010 - 1 = 00001
    int mask = left | right; // 10001

    N = N & mask; // 10000 AND 10001 = 10000
    M = M << i; // 101 << 1 = 1010

    return N | M; // 11010
}
```

---

#### 2. 소수 십진수를 2진수 문자열로
\- 0.50 같이 0 ~ 1의 실수가 double로 주어졌을 때 2진수 형태로 출력하기
\- 비트수가 32가 넘어가면 ERROR출력
&nbsp;&nbsp;&nbsp;&nbsp; \- 1. 문자열이 변화므로 StringBuilder 사용
&nbsp;&nbsp;&nbsp;&nbsp; \- 2. num * 2 의 값이 1보다 크면 1을 삽입 후 그 값에서 1을 뺀다.
&nbsp;&nbsp;&nbsp;&nbsp; \- 3. num * 2 의 값이 1보다 작으면 0을 삽입
&nbsp;&nbsp;&nbsp;&nbsp; \- 4. 길이가 32개 넘어가면 ERROR 리턴
```java
String pintBinary(double num) {
    if (num > 1 || num < 0) {
        return "ERROR";
    }

    StringBuilder binary = new StringBuilder();
    binary.append(".");

    while (num > 0) {
        if (binary.length() >= 32) {
            return "ERROR";
        }

        double r = num * 2;
        if (r > 1) {
            binary.append("1");
            num = r - 1;
        } else {
            binary.append("0");
            num = r;
        }
    }
    return binary.toString();
}
```

---

#### 3.비트 뒤집기
\- 어떤 정수가 있을때 0비트 하나를 1로 바꾸어서 나올수 있는 가장 긴 1의 길이를 구하라
\- 110110111일 경우 답은 6이다.<br>
**구현1. 단순한 방법**
\- 110110111일 때 연속된 0과 1의 갯수를 카운트하는 배열을 만든다. 단 0의 갯수부터 시작한다.
\- 즉 110110111일땐 [0(0), 3(1), 1(0), 2(1), 0(0), 2(1)]이 된다.
\- 0의 갯수가 1일때는 0의 양쪽의 배열 + 1
\- 1이상일땐 오른쪽, 왼쪽중 큰값 + 1
\- 0일땐 오른쪽, 왼쪽중 큰값이다.
\- 이렇게 max를 찾으면 된다.
```java
private final int BIT_LENGTH = Integer.BYTES * 8;

int revers(int bit) {
    if (bit == -1) return BIT_LENGTH;
    List<Integer> list = getZeroOneList(bit);
    return findLongestBit(list);
}

private List<Integer> getZeroOneList(int bit) {
    List<Integer> ret = new ArrayList<>();
    int count = 0;
    int OneOrZero = 0;
    for (int i = 0; i < BIT_LENGTH; i++) {
        if ((bit & 1) != OneOrZero) {
            ret.add(count);
            count = 0;
            OneOrZero = bit & 1;
        }
        count++;
        bit >>>= 1;
    }
    ret.add(count);
    return ret;
}

private int findLongestBit(List<Integer> list) {

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < list.size(); i += 2) {

        int zerosLen = list.get(i);
        int leftOne = i > 0 ? list.get(i - 1) : 0;
        int rightOne = i < list.size() - 1 ? list.get(i + 1) : 0;

        int now = 0;
        if (zerosLen == 1) {
            now = leftOne + 1 + rightOne;
        } else if (zerosLen > 1) {
            now = 1 + Math.max(leftOne, rightOne);
        } else if (zerosLen == 0) {
            now = Math.min(leftOne, rightOne);
        }

        max = Math.max(now, max);
    }

    return max;
}
```
<br>

**구현 2. 최적 알고리즘**
\- 굳이 배열을 가질 필요가 없다, 단지 현재와 이전의 연속된 1의 길이를 알고 있으면 된다.
\- prevCount, curCount가 있을 때 연속된 1에서 curCount++하다가 0을 만났을 때
\- 만약 또 하나의 0이 존재한다면 prevCount = 0이고
\- 그렇지 않으면 prevCount = curCount가 된다.
\- 그리고 max값과 prevCount + 1 + curCount 중 큰값을 계속 가지고 다니면된다.

```java
int bestPractice(int bit) {
    if ((~bit) == 0) return BIT_LENGTH;
    int max = 0;
    int curCount = 0, prevCount = 0;

    // 모든 bit가 0이면 bit == 0이 되어 while 끝
    while(bit != 0){
        if((bit & 1) == 1){
            curCount++;
        }else{
            // bit & 2 를 통해 두번째 비트의 값을 유추 가능
            prevCount = (bit & 2) == 0 ? 0 : curCount;
            curCount = 0;
        }

        max = Math.max(max, curCount + prevCount + 1);
        bit >>>= 1;
    }
    return max;
}
```

#### 4. 다음 숫자
\- 어떤 양의 정수가 주어졌을 때 이 숫자의 1비트의 개수가 같으면서 이 숫자보다 큰 숫자중에 가장 작은수, 이 숫자보다 작은 숫자중에 가장 큰 수를 구하라
#### 큰 숫자중에 가장 작은수 구하기
\- 우선 어떤 0비트를 1로바꾸면 다른 0비트를 1로 바꾸어야 한다.
\- x = 110011100 이라는 숫자가 있을 때 우선 첫번째로 만나는 1을 지나고 가장 처음으로 만나는 0을 1로 바꾸면 그 숫자(110111100)는 x보다 크다. 하지만 여기서 1하나를 0으로 변경해야한다.
\- 0에서 1로 바꾼 그 숫자의 위치를 p라고 하자. 시작비트를 0이라고 쳤을때 여기선 p = 5가된다.
\- p보다 오른쪽 위치에 존재하는 비트들에서 1을 오른쪽에 0을 왼쪽에 정렬하면 문제의 수보다 크면서 가장 작은 값을 구할 수 있다. 단 여기서 1하나를 0으로 교체해야한다.
\- 110111100 ====> p보다 오른쪽에 있는 1하나 없애고 정렬 ====> 110100011 이렇게 바꾸면 결과값이 나온다.
\- p보다 오른쪽에 있는 1과 0의 갯수를 카운트하고 p보다 오른쪽에 있는 비트를 0으로 변경 후 1의 카운트 - 1개를 오른쪽 비트에 채우면 된다.
```java
int getLargeButSmallestValue(int value) {
    int bit = value;
    int zeroCount = 0;
    int oneCount = 0;

    while ((bit & 1) == 0 && (bit != 0)) {
        zeroCount++;
        bit >>= 1;
    }

    while ((bit & 1) == 1) {
        oneCount++;
        bit >>= 1;
    }

    if (zeroCount + oneCount == 31 || zeroCount + oneCount == 0) {
        return -1;
    }

    int p = zeroCount + oneCount;
    value |= (1 << p);
    value &= -(1 << p);
    value |= (1 << oneCount - 1) - 1;

    return value;
}
```

#### 작은 숫자 중에 가장 큰수 구하기
\- 위의 방법과 0과 1만 바뀌었고 똑같다.
\- 첫번째로 만나는 0을 지나고 가장 처음만난 1을 0으로 바꾸고 그 위치를 p로한다.
\- p의 오른쪽에 1비트와 0비트를 카운터 한다.
\- p의 오른쪽의 비트들을 모두 1로 바꾼다
\- zeroCount - 1개만큼 오른쪽에 0을 채운다.
```java
int getSmallButLargest(int value) {
    int bit = value;
    int oneCount = 0;
    int zeroCount = 0;

    if (value == -1 || value == 0){
        return -1;
    }

    while ((bit & 1) == 1){
        oneCount++;
        bit >>= 1;
    }

    while ((bit & 1) == 0){
        zeroCount++;
        bit >>= 1;
    }

    int p = oneCount + zeroCount;
    value &= ~(1 << p);
    value |= (1 << p) -1;
    value &= -(1 << zeroCount -1) ;
    return value;

}
```
