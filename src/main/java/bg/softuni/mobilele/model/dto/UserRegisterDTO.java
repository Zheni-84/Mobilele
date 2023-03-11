package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.validation.PasswordsMatch;
import bg.softuni.mobilele.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link bg.softuni.mobilele.model.entity.UserEntity} entity
 */
@PasswordsMatch(first = "password", second = "confirmPassword", message = "Passwords do not match!")
public class UserRegisterDTO implements Serializable {

	@NotEmpty(message = "User email should be provided")
	@Email(message = "User email should be valid")
	@UniqueUserEmail(message = "User email should be unique")
	private String email;
	private String confirmPassword;
	@NotEmpty
	@Size(min = 5)
	private String password;
	@NotEmpty
	@Size(min = 2, max = 20)
	private String firstName;
	@NotEmpty
	@Size(min = 2, max = 20)
	private String lastName;

	public String getEmail() {
		return email;
	}

	public UserRegisterDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public UserRegisterDTO setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserRegisterDTO setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserRegisterDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserRegisterDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@Override
	public String toString() {
		return "UserRegisterDTO{" +
				"email='" + email + '\'' +
				", confirmPassword='" + confirmPassword + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}