package kz.attractorschool.forum.domain.user;

import kz.attractorschool.forum.exception.UserAlreadyRegisteredException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public void register(UserRegistrationForm userRegistrationForm){
    if (userRepository.existsByEmail(userRegistrationForm.getEmail())) {
      throw new UserAlreadyRegisteredException();
    }

    User userToSave = new User()
        .setEmail(userRegistrationForm.getEmail())
        .setPassword(passwordEncoder.encode(userRegistrationForm.getPassword()));

    userRepository.save(userToSave);
  }
}
