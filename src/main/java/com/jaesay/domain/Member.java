package com.jaesay.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.jaesay.domain.enums.Role;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "members", 
uniqueConstraints = {
		@UniqueConstraint(name = "uk_member_name", columnNames = "member_name"),
        @UniqueConstraint(name = "uk_member_email", columnNames = "email") }) 
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="memberName")
public class Member implements Serializable {
	
	private static final long serialVersionUID = -5843665655286828693L;

	@Id
    @GeneratedValue
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "member_name", length = 36, nullable = false)
    private String memberName;
  
    @Column(name = "email", length = 128, nullable = false)
    private String email;
  
    @Column(name = "password", length = 128, nullable = false)
    private String password;
  
    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled = true;
    
    @Column(name = "role", length = 36, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    
    @CreationTimestamp
    @Column(name="created_date", nullable = false)
    private LocalDateTime createdDate;
    
    @UpdateTimestamp
    @Column(name="updated_date", nullable = false)
    private LocalDateTime updatedDate;

    @Builder
	public Member(Long memberId, String memberName, String email, String password, boolean enabled, Role role,
			LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
}
