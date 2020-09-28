package eu.wodrobina.MockingServiceIsFlawn.user.domain;

import eu.wodrobina.MockingServiceIsFlawn.user.dto.UserDto;

import javax.persistence.*;
import java.util.function.Function;

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Embedded
    private Password password;

    private String name;

    protected User() {
    }

    public User(Password password, String name) {
        this.password = password;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Function<User, UserDto> mapToDto = user -> new UserDto(user.name);
}
