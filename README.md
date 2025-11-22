# 37-SOPKATHON-ANDROID-ANDROID3
37기 솝커톤 안드로이드 3팀 안드로이드 레포잉

1. 서비스 이름 및 소개
2. 주요기능
3. 팀원 역할 분담
4. 컨벤션 규칙과 브랜치 전략

   
- ### Branch
### Commit

### **1. 커밋 예시**

- **Commit → [커밋 카테고리/#이슈번호] 커밋 내용 (대문자)**
    
    *ex) [FEAT/#30] 홈 뷰 구현,  [ADD/#1] 폰트 파일 추가*
    
- **Issues → [FEAT] 제목**
    
    *ex) [INIT] 프로젝트 기초세팅*
    
- **Pull requests → [FEAT/#이슈번호] 제목**
    
    *ex)* *[FEAT/#6] PR 테스트*
    

### **2. 커밋 카테고리**

| 카테고리 | 내용 |
| --- | --- |
| `feat` | 기능 (feature) |
| `fix` | 버그 수정 |
| `docs` | 문서 작업 (documentation) |
| `style` | 포맷팅, 세미콜론 누락 등, 코드 자체의 변경이 없는 경우 |
| `refacotr` | 리팩토링 : 결과의 변경 없이 코드의 구조를 재조정 |
| `test` | 테스트 |
| `chore` | 변수명, 함수명 등 사소한 수정 *ex) .gitignore* |

---

### Git Flow

: 기본적으로 Git Flow 전략을 이용한다. 작업 시작 시 선행되어야 할 작업은 다음과 같다.

**< Git Flow >**

1. Issue를 생성한다.
2. Branch를 생성한다.
3. Add - Commit - Push - Pull Request 의 과정을 거친다.
    1. commit은 최대한 잘게!!
    2. commit시 issue를 연결한다.
4. commit은 최대한 잘게!!
5. commit시 issue를 연결한다.
6. Pull Request가 작성되면 작성자 이외의 다른 팀원이 Code Review를 한다.
7. Code Review가 완료되면 Pull Request 작성자가 dev Branch로 merge 한다.
→ ⭐ **merge 후 카톡방에 무조건 말하기** ⭐
8. merge된 작업이 있을 경우, ‼️**다른 브랜치에서 작업을 진행 중이던 개발자는 본인의 브랜치로 merge된 작업을 Pull 받아온다.**‼️ 
</aside>
### **1. 브랜치 유형**

| 브랜치 유형 | 내용 |
| --- | --- |
| `main` | 완성된 버전의 코드를 저장하는 브랜치 |
| `develop` | 개발이 진행되는 동안 완성된 코드를 저장하는 브랜치 |
| `feature` | 작은 단위의 작업이 진행되는 브랜치 |
| `hotfix` | 긴급한 오류를 해결하는 브랜치 |

### **2. 브랜치명**

- 유형/#이슈번호-what
    
    ex) feat/#30-home-ui,  init/#1-add-font
    

| 카테고리 | 내용 |
| --- | --- |
| `feat` | 구현 |
| `mod` | 수정 |
| `add` | 추가 |
| `del` | 삭제 |
| `fix` | 버그 수정 |
| `refacotr` | 리팩토링 |
