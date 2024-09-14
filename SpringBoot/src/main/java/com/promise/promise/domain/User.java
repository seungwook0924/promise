package com.promise.promise.domain;

import com.promise.promise.domain.enumeration.NotificationValue;
import com.promise.promise.domain.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "user_id", unique = true, length = 20)
    private String userId;

    @Column(name = "user_password", length = 30)
    private String userPassword;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Range(min = 1, max = 130)
    private byte age;

    @Column(name = "nick_name", unique = true, length = 10)
    private String nickName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_value")
    private NotificationValue notificationValue;

    @Column(name = "bottle_id", unique = true)
    private String bottleId;

    private String zipcode;

    //User와 Notification은 1:N 관계
    //한 명의 사용자는 여러 알림을 받을 수 있다.
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) //연관관계 주인이 아님, 지연로딩
    private List<Notification> notifications = new ArrayList<>();
}