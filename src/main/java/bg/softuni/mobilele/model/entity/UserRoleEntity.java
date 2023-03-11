package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserRoleEnum userRole;

	@Override
	public String toString() {
		return "UserRoleEntity{" +
				"id=" + id +
				", userRole=" + userRole +
				'}';
	}

	public Long getId() {
		return id;
	}

	public UserRoleEntity setId(Long id) {
		this.id = id;
		return this;
	}
}
