package kz.attractorschool.forum.domain.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationForm {

  @Email
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 8)
  private String password;
}
