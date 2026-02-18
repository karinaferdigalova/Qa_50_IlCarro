package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
