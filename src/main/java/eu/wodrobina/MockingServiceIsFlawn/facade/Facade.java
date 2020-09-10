package eu.wodrobina.MockingServiceIsFlawn.facade;

import eu.wodrobina.MockingServiceIsFlawn.user.domain.UserService;
import eu.wodrobina.MockingServiceIsFlawn.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Facade {

    private final UserService userService;

    public Facade(UserService userService) {
        this.userService = userService;
    }

    public Collection<UserDto> getUsers() {
        return userService.getUsers();
    }
}
