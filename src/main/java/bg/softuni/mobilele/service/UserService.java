package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;
	private final CurrentUser currentUser;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.currentUser = currentUser;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
	}

	public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
		UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
		newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
		login(userRepository.save(newUser));
	}

	public boolean login(UserLoginDTO dto) {
		Optional<UserEntity> userEntity = userRepository.findByEmail(dto.getUsername());
		if (userEntity.isEmpty()) {
			LOGGER.debug("User with name {} not found", dto.getUsername());
			return false;
		}

		String rawPassword = dto.getPassword();
		String encodedPassword = userEntity.get().getPassword();
		boolean success = passwordEncoder.matches(rawPassword, encodedPassword);
		if (success) {
			login(userEntity.get());
		} else {
			//
		}
		return success;
	}

	public void login(UserEntity userEntity) {
		currentUser.setLoggedIn(true)
				.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
	}

	public void logout() {
		currentUser.clear();
	}
}