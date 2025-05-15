package giakiet.messagewebapp.backend.service.impl;

import giakiet.messagewebapp.backend.constant.UserConsant;
import giakiet.messagewebapp.backend.dto.LoginDto;
import giakiet.messagewebapp.backend.dto.RegisterDto;
import giakiet.messagewebapp.backend.dto.base.AuthResDto;
import giakiet.messagewebapp.backend.entity.User;
import giakiet.messagewebapp.backend.enums.ExceptionEnums;
import giakiet.messagewebapp.backend.exception.CustomException;
import giakiet.messagewebapp.backend.repository.IUserRepository;
import giakiet.messagewebapp.backend.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements IAuthService {

    private final IUserRepository userRepository;

    @Override
    public AuthResDto register(RegisterDto registerDto) {
        try {
            if (userRepository.existsByUsername(registerDto.getUsername())) {
                throw new CustomException(ExceptionEnums.INFORMATION_EXISTED, UserConsant.USER_NAME);
            }
            if (userRepository.existsByEmail(registerDto.getEmail())) {
                throw new CustomException(ExceptionEnums.INFORMATION_EXISTED, UserConsant.EMAIL);
            }
            userRepository.save(User.builder()
                    .username(registerDto.getUsername())
                    .password(registerDto.getPassword())
                    .email(registerDto.getEmail())
                    .build());
            // todo
            return new AuthResDto();
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            log.error("AuthServiceImpl | register | ERROR: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public AuthResDto login(LoginDto loginDto) {
        try {
            User user = userRepository.findByUsername(loginDto.getUsername())
                    .orElseThrow(() -> new CustomException(ExceptionEnums.NOT_FOUND, UserConsant.USER_NAME));

            // todo
            return new AuthResDto();
        } catch (CustomException ex) {
            throw ex;
        } catch(Exception e){
            log.error("AuthServiceImpl | login | ERROR: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
