package giakiet.messagewebapp.backend.service;

import giakiet.messagewebapp.backend.dto.LoginDto;
import giakiet.messagewebapp.backend.dto.RegisterDto;
import giakiet.messagewebapp.backend.dto.base.AuthResDto;
import giakiet.messagewebapp.backend.exception.CustomException;

public interface IAuthService {

    AuthResDto register(RegisterDto registerDto);

    AuthResDto login(LoginDto loginDto);

}
