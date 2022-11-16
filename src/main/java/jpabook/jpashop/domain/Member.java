package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //테이블과 연결할 클래스
@Getter @Setter
public class Member {

    @Id @GeneratedValue           //Id : 기본키 설정
    @Column(name = "member_id")   //'member_id'라는 이름의 컬럼 생성
    private Long id;

    private String name;

    @Embedded    //임베디드 타입,
    private Address address;

    @OneToMany(mappedBy = "member")  //일대다 관계 mappedBy -> 연관관계의 주인이 아니라는 뜻
    private List<Order> orders = new ArrayList<>();


}
