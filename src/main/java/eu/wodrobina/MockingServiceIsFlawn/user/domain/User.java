package eu.wodrobina.MockingServiceIsFlawn.user.domain;

import eu.wodrobina.MockingServiceIsFlawn.user.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.function.Function;

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;


    protected User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Function<User, UserDto> mapToDto = user -> new UserDto(user.name);
}
