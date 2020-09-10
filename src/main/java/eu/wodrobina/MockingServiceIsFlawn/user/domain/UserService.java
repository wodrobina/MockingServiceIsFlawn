package eu.wodrobina.MockingServiceIsFlawn.user.domain;

import com.google.common.collect.ImmutableList;
import eu.wodrobina.MockingServiceIsFlawn.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<UserDto> getUsers() {
        return ImmutableList.copyOf(userRepository.findAll())
                .stream()
                .map(User.mapToDto)
                .collect(Collectors.toList());
    }
}
