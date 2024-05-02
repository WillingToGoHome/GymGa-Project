# Read Me
# 프로젝트 제목
```markdown
Gym家 헬스장 회원 관리 프로그램 (CRM)
```

# 프로젝트 정보
```markdown
프로젝트 목적 : 헬스장의 전반적인 회원 / 매출 / 시설 등 운영 관리를 위한 프로그램 제작
프로젝트 개발 기간 : 2024 .04. 16 ~ 05. 29
```

# 팀 소개
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/9efac424-2413-457b-a4ca-74b88e8bb35b)


# 프로젝트 소개
### Gym家 헬스장 회원 관리 프로그램 (CRM)
```markdown
맞춤형 회원관리를 통해 회원에게는 합리적인 운동 솔루션과 스케쥴 관리 기능을 제공하고
트레이너에게는 회원 관리에 소모되는 시간과 비용을 줄여주고 관리자에게는 최적의 마케팅 솔루션 추천하여
헬스장 운영을 쉽고 편리하게 할 수 있도록 도와줍니다.
```
# 프로젝트의 기능
```markdown
1. 로그인
      a.대표자 또는 강사는 지정된 접속 정보를 이용해 접속
      b.다른 메뉴 선택 시 세션 정보가 없다면 로그인 우선 진행하도록 알림
2. 매출 관리
      a.대표자
            i.전체적인 매출 상황을 조회할 수 있음
            ii.항목 별 매출을 조회할 수 있음
            iii.강사 별 매출을 조회할 수 있음
            iv.강사 급여를 관리할 수 있음
      b.강사
            i.본인 월 급여 명세를 조회할 수 있음
            ii.본인 수당 내역을 조회할 수 있음
3. 회원 관리
      a.대표자&강사
            i.전체 회원 정보를 조회할 수 있음
              1.검색 조건에 따라 일부 회원 정보를 선택적으로 조회할 수 있음
            ii.신규 회원 정보를 추가할 수 있음
            iii.기존 회원 정보를 수정할 수 있음
      b.대표자
            iv.기존 회원 정보를 삭제할 수 있음
4. 일정 관리
        a.일/주/월 단위의 일정을 확인할 수 있음
        b.세부 일정 내용을 확인할 수 있음
5. 시설 관리
        a.라커를 배정 할 수 있음
        b.배정된 라커를 관리할 수 있음
알림 및 기타
        a.전체 공지
        b.확성기 더럽게 비쌈
```

# 대표자 기능
```markdown
1.대표자는 매출,인사,마케팅, 공지사항&알림,시설, 일정을 관리 할 수 있다.
2.대표자는 단위 기간, 월 별, 항목 별, 강사 별로 매출을 조회할 수 있다.
3.대표자는 이용권 판매 내역을 판매자 별 과 단위 기간 별로 조회 할 수 있다.
4.대표자는 이용권 구매 기록 별 포인트 적립을 조회 할 수 있다.
5.대표자는 이용권의 시작 및 종료 날짜를 조회 할 수 있다.
6.대표자는 월 별 강사 급여와 월 별 강사 수당을 조회 할 수있다.
7.대표자는 월별 회원 구매 내역을 수정 또는 삭제 할 수 있다.
8.대표자는 강사를 등록,수정,삭제,조회를 할 수 있다.
9.대표자는 새로운 회원을 등록, 수정,삭제, 조회를 할 수 있다.
10.대표자는 새로운 사물함을 등록,수정,삭제, 조회 할 수 있다.
11.대표자는 단체별 또는 개인별로 알림을 발송할 수 있다.
12.대표자는 운동 프로그램을 등록,수정,삭제,조회를 할 수 있다.
```
# 직원 기능
```markdown
1.직원은 매출,급여,공지사항&알림,시설(라커), 일정을 관리 할 수 있다.
2.직원은 단위 기간, 월 별, 항목 별로 급여를 조회할 수 있다.
3.직원은 이용권 판매 내역을 허용된 조건 내에서 조회 할 수 있다.
4.직원은 이용권의 시작 및 종료 날짜를 조회 할 수 있다.
5.직원은 월 별 강사(본인) 급여와 월 별 강사 수당(본인)을 조회 할 수 있다.
6.직원은 허용된 조건 내에서 월 별 회원 구매 내역을 수정 또는 삭제 할 수 있다.
7.직원은 강사(본인)을 수정, 조회 할 수 있다.
8.직원은 새로운 회원을 등록, 수정,삭제, 조회를 할 수 있다.
9.직원은 새로운 사물함을 등록,수정,삭제, 조회 할 수 있다.
10.직원은 단체별 또는 개인별로 알림을 발송할 수 있다.
```
# 시작 가이드
## 1.요구사항
```markdown
Chrome 환경 권장

1.프로젝트 cloning
2.IDE로 프로젝트 실행
3.인터넷 익스플로어로 127.0.0.1/8080 접속

IDE :
IntelliJ

Java :
JDK 17

Dependencies :
1. Spring Web
2. Spring Boot DevTools
3. Thymeleaf
4. LOMBOK
```
   
# 기술 스택 (개발 환경)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/2969df46-9b68-48ea-8030-e0d01d0467f9)

# 기타 문서
## Read me 업데이트
```markdown
2024-04-19 ver.0 작성
```
# 시장 조사
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/3e5bb9d0-e48a-46e6-bef7-a799835e7cde)

# 유사 프로그램 분석
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/a3cc0938-89b4-432d-8e1f-10a936e02632)

# 업무 분석
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/f0f47d7b-a839-45ed-bd6e-1b0f54f4eadb)

# 요구 사항 명세
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/5bebfe1b-3090-4cec-9293-6940bc9f0b37)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/28f5bc7c-fd1d-49a6-9431-777e6220f668)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/5a5c0994-f30e-4178-b2bb-5e7ec042ed29)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/484a9c2a-f079-43e1-8a9b-89e9744e6150)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/75ed1acb-0494-4eb0-8459-9c7757a4daec)

# 유스케이스 다이어그램
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/b8687c7d-fdc6-4fbf-9684-4a52cab0303d)

# 메뉴 구조도
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/2270485f-e74d-42b9-a6ab-5fb1f0ac0e9c)


# 정책 정의서
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/51cc41fa-1e91-464a-b67c-76d2d23e20c6)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/39d834b3-948a-4867-b909-350beb897333)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/8866117b-ff62-4ec5-9da3-e45f821434e3)

# 데이터 베이스 모델 항목
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/a960ea87-002e-43f6-986b-5eaec806bf44)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/f2c51ab8-1479-468e-b814-0baef8c490ed)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/e5aa7df6-19f8-44f0-8af1-97786e0486f9)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/30bc6f00-cf8a-462c-bf6d-0e7053915144)

# 논리 데이터 베이스 모델 (ERD)
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/07a9b38f-e10f-4d76-a68a-82250fa60e66)

# 물리 데이터 베이스 모델
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/295d8a0d-3afa-4e32-9fdd-a2b13aa30248)

# 전체 업무 흐름도
![image](https://github.com/WillingToGoHome/GymGa/assets/157683550/12ad0926-dd38-4d9c-a8e9-47e9d5a9013c)














