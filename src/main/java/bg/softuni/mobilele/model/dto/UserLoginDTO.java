package bg.softuni.mobilele.model.dto;

public class UserLoginDTO {
	private String username;
	private String password;

	@Override
	public String toString() {
		return "UserLoginDTO{" +
				"username='" + username + '\'' +
				", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
				'}';
	}

	public String getUsername() {
		return username;
	}

	public UserLoginDTO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserLoginDTO setPassword(String password) {
		this.password = password;
		return this;
	}
}