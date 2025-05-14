    package com.example.movieticketbookingsystem.service.impl;

    import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
    import com.example.movieticketbookingsystem.dto.UserResponse;
    import com.example.movieticketbookingsystem.dto.UserUpdationRequest;
    import com.example.movieticketbookingsystem.entity.TheaterOwner;
    import com.example.movieticketbookingsystem.entity.User;
    import com.example.movieticketbookingsystem.entity.UserDetails;
    import com.example.movieticketbookingsystem.exception.UserExistsByThisEmailException;
    import com.example.movieticketbookingsystem.exception.UserNotFoundByEmailException;
    import com.example.movieticketbookingsystem.mapper.UserDetailsMapper;
    import com.example.movieticketbookingsystem.repository.UserRepository;
    import com.example.movieticketbookingsystem.security.SecurityConfig;
    import com.example.movieticketbookingsystem.service.UserService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.time.Instant;

    @Service
    @AllArgsConstructor
    @Slf4j
    public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final UserDetailsMapper userMapper;
        private final PasswordEncoder passwordEncoder;

        @Override
        public UserResponse addUser(UserRegistrationRequest user) {
            if (userRepository.existsByEmail(user.email()))
                throw new UserExistsByThisEmailException("User with the Email is already exists");

            UserDetails userDetails = switch (user.userRole()) {
                case USER -> copy(new User(), user);
                case THEATER_OWNER -> copy(new TheaterOwner(), user);
            };
            return userMapper.userDetailsResponseMapper(userDetails);

        }

        @Override
        public UserResponse editUser(UserUpdationRequest userRequest, String email) {
            log.info("editing user...");
            if (userRepository.existsByEmail(email)) {
                UserDetails user = userRepository.findByEmail(email);
                log.info("user is unique");
                if (! user.getEmail().equals(userRequest.email()) && userRepository.existsByEmail(userRequest.email())){
                    throw new UserExistsByThisEmailException("User with the email already exists");
                }

                log.info("mapping data...");
                user = copy(user, userRequest);

                return userMapper.userDetailsResponseMapper(user);
            }

            throw new UserNotFoundByEmailException("Email not found in the Database");

        }

        @Override
        public UserResponse softDeleteUser(String email) {
            if (userRepository.existsByEmail(email)) {
                UserDetails user = userRepository.findByEmail(email);
                user.setDelete(true);
                user.setDeletedAt(Instant.now());
                userRepository.save(user);
                return userMapper.userDetailsResponseMapper(user);
            }
            throw new UserNotFoundByEmailException("Email not found in the Database");
        }

        private UserDetails copy(UserDetails userRole, UserRegistrationRequest user) {
            userRole.setUserRole(user.userRole());
            userRole.setPassword(passwordEncoder.encode(user.password()));
            userRole.setEmail(user.email());
            userRole.setDateOfBirth(user.dateOfBirth());
            userRole.setPhoneNumber(user.phoneNumber());
            userRole.setUsername(user.username());
            userRole.setDelete(false);
            userRepository.save(userRole);
            return userRole;
        }

        private UserDetails copy(UserDetails userRole, UserUpdationRequest user) {
            userRole.setDateOfBirth(user.dateOfBirth());
            userRole.setPhoneNumber(user.phoneNumber());
            userRole.setEmail(user.email());
            userRole.setUsername(user.username());
            userRole.setDelete(false);
            userRepository.save(userRole);
            return userRole;
        }
    }