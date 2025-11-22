# 37기 Sopkathon Android 3팀



## 1. 서비스 이름 및 간단한 소개
### 서비스 명 : Dear.Nest

둥지 증후군을 겪고 있는 60대 이상의 부모 그런 부모에게 일상 케어 서비스를 보내는 서비스입니다.
내가 떠나온 그 Nest(둥지)에 자녀의 애정을 담아서 정성껏 서비스를 연결합니다.</br>

## 2. 주요 기능
- 서비스 Helper 리스트 확인 기능 : 원하는 서비스에 대한 Helper 들의 리스트를 받아옵니다.
- Helper 정보 보기 : 인증된 Helper 를 확인하기 위해 상세 정보를 불러옵니다.
- 서비스 예약 : 서비스 일시, 지역, 시간 등을 선택하여 서비스를 예약합니다.
- 서비스 결제 : 예약한 서비스에 대해 결제를 진행합니다.</br>

## 3. 팀원 역할 분담
|👑 손주완<br/>([@vvan2](https://github.com/vvan2)) | 전도연<br/>([@doyeon0307](https://github.com/doyeon0307)) | 이지민<br/>([@vahkjsdf](https://github.com/vahkjsdf)) | 한유빈<br/>([@oilbeaneda](https://github.com/oilbeaneda)) |
|:---------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|
| <img width="200px" src="https://avatars.githubusercontent.com/u/113279387?v=4"/> | <img width="200px" src="https://avatars.githubusercontent.com/u/108921606?v=4"/> | <img width="200px" src="https://avatars.githubusercontent.com/u/130419090?v=4"/> | <img width="200px" src="https://avatars.githubusercontent.com/u/150934431?v=4"/> |
|`서비스 예약` | `헬퍼 정보 보기` | `진행률 확인` | `헬퍼 리스트` |
<br>

## 4. 컨벤션 규칙과 브랜치 전략
<aside>

### Branch

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
</aside>

---

---

<aside>


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
</aside>

---

---

<aside>


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
   → ⭐ **merge 후 무조건 말하기** ⭐
8. merge된 작업이 있을 경우, ‼️**다른 브랜치에서 작업을 진행 중이던 개발자는 본인의 브랜치로 merge된 작업을 Pull 받아온다.**‼️

### ❗ **협업 시 준수해야 할 규칙**

1. dev에서의 작업은 **원칙적으로 금지**한다. 단, 초기 세팅 및 README 작성은 dev Branch에서 수행한다.
2. 본인의 Pull Request는 본인이 Merge한다.
3. Commit, Push, Merge, Pull Request 등 모든 작업은 **앱이 정상적으로 실행되는 지 확인** 후 수행한다. (빌드 해본 후에!)
4. README 수정 및 ktlint 적용을 위한 Commit 도배는 금지한다. 리드미 미리보기는 Preview를 통해 확인한다.
</aside>

## 5. 안드 팀원들의 사진 (before)

<img width="600" src="https://github.com/user-attachments/assets/fd52765d-59af-4adf-a411-1dbacb995615" />


## 6. 안드 팀원들 사진 (after)
<img width="600" src="https://github.com/user-attachments/assets/58791a9e-8c76-48de-9ae2-8ac48be69ddf" />

## 7. 시연 영상


