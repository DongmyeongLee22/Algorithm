# 시스템 설계 및 규모 확장성
이런 문제들을 면접관과 질문하며 장단점을 토론하는게 좋다

이 문제를 풀어나가는 좋은 해법과 나쁜 해법은 있지만 완벽한 해법은 없다.

### 문제를 다루는 방법
소통하라
 - 이런류의 문제의 가장 큰 목적은 의사소통 능력을 평가하기 위함이다.
 - 면접관에게 질문을 던지고, 시스템에 발생할 수 있는 문제점을 열린 마음으로 받아들여라

처음에는 포괄적으로 접근하라
  - 알고리즘으로 바로 가지말고 한 부분만 보지마라.

가정을 할 때 주의하라
  - 잘못된 가정은 문제를 완전히 다르게 바꿔 버릴 수 있다.
  - 예를들어 데이터의 통계/분석 결과를 만드는 시스템이 있을 때, 이 시스템의 분석결과가 언제나 최신 결과를 나타내야하는지 아닌지에 따라 매우 큰 차이가 난다.

생각하는 가정을 명확히 언급하라
  - 명확히 언급해야 잘못된 부분을 바로 잡을수 있다.

필요하면 어림잡아 보라
  - 많은 경우에 필요한 데이터들이 없을 수 있다.
  - 예를 들어 웹크롤러를 설계할 때 모든 URL을 저장하는 데 필요한 공간이 얼마나 되는지 어림잡아 볼 필요가 있다.

뛰어들라
  - 지원자로서 문제를 책임져야 한다. 그렇다고 조용히 있으면 안된다.
  - 면접관과 이야기하며 동시에 문제를 풀며 장단점을 열린마음으로 받아들여라

### 시스템 설계: 단계별 접근
#### 1. 문제의 범위를 한정하라
내가 생각하는 것과 면접관이 생각하는게 같은지 확실히 하면 범위를 한정시킬수 있다.
#### 2. 합리적인 가정을 만들라
필요하다면 가정을 세우는것도 괜찮지만 합립적인 가정을 세워야 한다. 시스템이 하루에 100명의 사용자만 처리할 수 있거나, 메모리가 무제한이라는 가정은 합리적이지 않다.

#### 3. 중요한 부분을 먼저 그려라
시스템의 주요한 부분을 다이어그램으로 그려라.
예를 들어 여러 개의 프론트엔드 서버가 백엔드에서 데이터를 받아 오는 시스템일 수도 있고, 한 서버군은 인터넷에서 데이터를 긁어 오고 다른 서버군은 이 데이터를 분석하는 작업을 하는 시스템일 수도 있다.

시스템의 처음부터 마지막 까지 어떻게 동작하는지 그 흐름을 그려보라.

#### 4. 핵심 문제점을 찾으라

#### 5. 핵심 문제점을 해결할 수 있도록 다시 설계하라
시스템에 존재하는 어떤 제약상항도 열린 마음으로 받아들일 수 있어야 한다.

### 규모 확장을 위한 알고리즘: 단계별 접근법
시스템 설계가 아닌 단순히 시스템의 한부분 혹은 알고리즘을 설계하라고 할때는 확장성에 대해 신경써야한다.

#### 1. 질문하라
내가 문제를 제대로 이해했는지에 대한 질문이 필요하다.

#### 2. 현실적 제약을 무시하라
메모리가 무제한이며, 컴퓨터 한 대에서 모든 데이터를 다 처리할 수 있다고 가정하고 풀어봐라.

#### 3. 현실로 돌아오라
데이터 크기를 파악하고 어떻게 나눌지, 그 데이터를 어떻게 추적할 지 생각해봐라

#### 4. 문제를 풀어라

---

## 시스템 설계의 핵심 개념
#### 수평적 vs 수직적 규모 확장
수직적 규모 확장
  - 특정 노드의 자원의 양을 늘리는 방법
  - 예를들어 서버에 메모리를 추가해 서버 처리능력을 향상

수평적 규모 확장
  - 노드의 개수를 늘리는 방법
  - 예를 들어 서버를 추가해서 부하를 줄이는것

#### 서버 부하 분산 장치(load balancer)
일반적으로 규모 확장성이 있는 프론트엔트 부분은 서버 부하 분산 장치를 통해서 제공된다. 이렇게 해야 서버에 걸리는 부하를 여러 대의 서버에 균일하게 분산시킬수 있고 서버 한 대 때문에 전체 시스템이 죽거나 다운되는 상황을 방지할 수 있다. 물론 이렇게 하기 위해선 서버 여러 대가 근본적으로 똑같은 코드와 데이터를 사용하도록 하는 네트워크를 구현해야 한다.

#### 데이터베이스 역정규화와 NoSQL
SQL 같은 관계형 DB의 조인 연산은 시스템이 커질수록 느려진다. 따라서 조인 연산은 가능하면 피해야 한다.

역정규화가 이런것들 중 하나다. 역정규화란 DB에 여분의 정보를 추가해서 읽기 연산 속도를 향상시킨 것을 의미한다. 예를들어 어떤 DB에서 a와 b를 조회할 때 조인이 필요하다면 a가 있는 테이블에 b정보를 저장해놓고 빠르게 수행하는 것

NoSQL은 조인 연산 자체를 지원하지 않기 때문에 자료를 저장할 때 조금 다른 방식으로 구성해 놓는다. 이 방식이 규모 확정성에 좋도록 설계되어 있다.

#### NoSQL 특징과 장점
- 거대한 Map으로서 key-value 형식을 지원한다.
- RDBMS가 데이터의 관계를 Foreign Key 등으로 정의하고 Join 등 관계형 연상을 하지만 NoSQL은 관계를 정의하지 않는다.
- 대용량 데이터 저장을 한다.
- 분산형 구조를 통해 여러대의 서버에 분산하여 저장하고 상호복제하여 데이터 유실이나 서비스 중지에 대비한다.
Schema-less
- 읽기 작업보다 쓰기 작업이 더 빠르며, 일반적으로 RDBMS에 비하여 쓰기와 읽기 성능이 빠르다.

#### 데이터베이스 분할(샤딩)
샤딩(sharding)은 데이터를 여러 컴퓨터에 나눠서 저장하는 동시에 어떤 데이터가 어떤 컴퓨터에 저장되어 있는지 알 수 있는 방식이다.

**수직적 분할**
- 자료의 특성별로 분할하는 방식
- 소셜 네트워크를 만든다고 할 때 개인정보와 관련된 부분 혹은 메시지와 관련된 부분과 같이 그 특성에 따라 자료를 분할할 수 있다.
- 단점으로는 특정 테이블의 크기가 일정 수준 이상으로 커지면, 데이터베이스를 재분할 해야할 수도 있다.

**키 혹은 해시 기반 분할**
- 간단하게 구현하면 mod(key, n)의 값을 이용해서 N개의 서버에 분할 저장하면 된다.
- 문제점은 서버의 개수가 사실상 고정되어야 하고, 서버를 추가할 때마다 데이터를 다시 재분배해야 하는데 굉장히 큰 비용이 든다.

**디렉터리 기반 분할**
- 데이터를 찾을 때 사용되는 조회 테이블을 유지하는 방법
- 상대적으로 서버를 추가하기 쉽지만, 두가지 큰 단점 존재
- 첫 번째는 조회 테이블이 단일 장재지점(single point of failure)이 될 수있다.
- 두 번째는 지속적으로 테이블을 읽는 행위가 전체 성능에 영향을 미칠 수 있따.

#### 캐싱(caching)
인메모리 캐시를 사용하면 결과를 굉장히 빠르게 가져올 수 있다. 인메모리 캐시는 키-값을 쌍으로 갖는 간단한 구조로 일반적으로 애플리케이션과 데이터 저장소 사이에 자리잡고 있다.

앱이 어떤 자료를 요청하면 캐시를 먼저 확인하고 캐시에 데이터가 존재하지 않으면 DB를 조회한다.

캐시할 때는 쿼리와 그 결과를 캐시하는 경우가 많다. 혹은 특정 객체를 캐시할 수도 있다.

#### 비동기식 처리 & 큐
이상적이라면 속도가 느린 연산은 비동기식으로 처리해야 한다. 그렇지 않으면 해당 연산이 끝나기까지 하염없이 기다려야 한다.

어떤 경우에는 이 연산을 미리 해 놓을 수도 있다. 예를들어, 곧 갱신해야 할 웹 사이트의 각 부분들이 큐에 들어 있다고 생각해보자. 이 웹사이트가 어떤 포럼이라고 했을 때, 큐에 들어 있는 작업 중 하나는 아마 가장 최근의 글들과 몇가지 코멘트를 보여 주는 페이지를 다시 만들어 주는 일일 것이다. 이런경우는 최근 글리스트가 약간 오래되어 덜 정확하더라도 괜찮다. 새로운 코멘트 하나 떄문에 캐시미스가 나고, 속도가 느려지는 거보다 덜 정확한 것이 낫다.

#### 네트워크 성능 척도

**대역폭**
- 단위 시간에 전송할 수 있는 데이터의 최대치

**처리량**
- 단위 시간에 실제로 전송된 데이터의 양을 의미

**지연 속도**
- 데이터를 전송하는 걸리는 시간

예를 들어 공장의 컨베이어 벨트에서 물품이 이동하는 못브을 상상해보자.
지연 속도는 물품하나가 한 지점에서 다른 지점까지 옮겨지는데 걸린 시간을 말하고, 처리량은 단위 시간에 옮겨진 물품의 개수를 의미한다.
- 컨베이터 벨트 폭을 넓힌다고 지연속도가 달라지진 않는다. 하지만 처리량 이나 대역폭을 키운다면 짧아 질 것이다.
- 벨트의 길이를 줄이면 지연속도가 줄 것이다. 하지만 대역폭이나 처리량을 달라지지 않는다.
- 벨트의 속도를 빠르게 만든다면 세가지 척도 모두 바꿀 수 있다.
- 대역폭은 최상의 조건에 단위 시간에 전송할 수 있는 물품의 개수를 뜻한다.
- 처리량은 실제 상황에서 단위 시간에 전송된 물품의 개수를 말한다.

처리량은 압축 등의 방법으로 향상이 가능하나 지연 시간 단축은 힘들다.

#### MapReduce
MapReduce는 구글과 관련이 있는데, 현재는 구글에 국한되지 않고 널리 사용도고 있다. MapReduce 프로그램은 보통 굉장히 커다란 데이터를 처리하는데 사용된다.

Map 단계외 Reduce 단계를 구현하면 나머지 부분은 시스템이 처리해준다.
- Map은 데이터를 입력으로 받은 뒤 <key, value> 쌍으로 반환한다.
- Reduce는 키, 그리고 키와 관련된 값들을 입력으로 받은 뒤 나름의 처리 과정을 거친 뒤 새로운 키와 값을 반환한다.
- MapReduce는 많은 과정을 병렬로 처리할 수 있게 도와 주기 때문에 굉장히 커다란 데이터에 대해서도 규모 확장이 쉬워진다.

## 시스템 설계 시 고려할 점
시스템을 설계할 때는 앞의 개념뿐만 아니라 다음의 문제도 고려해야 한다.
**실패**
- 각 부분이 실패 했을 때를 대비한 대비책을 준비하자

**가용성 및 신뢰성**
- 가용성이란 사용 가능한 시스템의 시간을 백분율로 나타낸 것을 말한다.
- 신뢰성은 특정 단위 시간에 시스템이 사용 가능한 확률을 나타낸 것을 말한다

**읽기 중심 vs 쓰기 중심**
- 읽기 중심인지 쓰기 중심인지에 따라 설계가 달라질 수 있다
- 읽기가 많다면 캐시를 쓰기가 많다면 큐를 사용할 수 있다.

**보안**