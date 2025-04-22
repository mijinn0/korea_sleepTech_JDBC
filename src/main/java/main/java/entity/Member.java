package main.java.entity;

// Entity
// : 데이터베이스 테이블과 매핑되는 클래스
// >> 1:1

import lombok.*;

// +) Lombok
//    : Java Domain에서 반복적으로 작성되는 getter나 setter, 생성자 관련 코드 등을
//      , 간결하게 만들어주는 라이브러리
//    1) Lombok 플러그인 설치
//    2) Dependency 설정
//       : compileOnly 'org.projectlombok:lombok:1.18.38'
//    3) Enable annotation 설정 (설정 > 빌드, 실행, 배포 > 컴파일러 > 어노테이션 프로세서 > 어노테이션 처리 활성화)

@AllArgsConstructor
@NoArgsConstructor
// : JDBC 또는 ORM (DB와 JAVA를 객체화하여 연동하는 체계)에서는
//   , 빈 객체를 먼저 만들고 setter로 값을 넣는 방식을 사용
// >> 따라서 AllArgsConstructor도 NoArgsConstructor가 전제되어야 함! (기본 + 전체 필드 생성자)
@Getter
@Setter
@ToString
public class Member {
    private int id;
    private String name;
    private String email;
}
