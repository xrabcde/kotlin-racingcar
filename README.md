# kotlin-racingcar

### 2단계 - 문자열 계산기

- [x] 사용자가 문자열 입력
  - [x] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException
- [ ] 입력된 문자열 split 후 숫자와 연산자로 구분
  - [ ] 사칙연산 기호가 아닌 경우 IllegalArgumentException
  - [ ] 숫자가 아닌 경우 IllegalArgumentException
  - [ ] 숫자, 연산자 순서가 틀린 경우 IllegalArgumentException
- [ ] 사칙연산 수행 : 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서 결정
  - [ ] 덧셈
  - [ ] 뺄셈
  - [ ] 곱셈
  - [ ] 나눗셈
- [x] 연산결과 출력
