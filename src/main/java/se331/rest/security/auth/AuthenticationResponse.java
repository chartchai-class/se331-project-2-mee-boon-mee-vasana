package se331.rest.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.DTO.CommentAuthDTO;
import se331.rest.entity.Comment;
import se331.rest.security.user.UserDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  private UserDTO user;
//  private CommentAuthDTO user;
}
