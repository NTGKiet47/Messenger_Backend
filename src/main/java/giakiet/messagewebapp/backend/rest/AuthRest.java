package giakiet.messagewebapp.backend.rest;

import giakiet.messagewebapp.backend.dto.LoginDto;
import giakiet.messagewebapp.backend.dto.RegisterDto;
import giakiet.messagewebapp.backend.dto.base.AuthResDto;
import giakiet.messagewebapp.backend.constant.ApiConstant;
import giakiet.messagewebapp.backend.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = ApiConstant.API_AUTH)
@RequiredArgsConstructor
public class AuthRest {

    private final IAuthService authService;

    @PostMapping(ApiConstant.API_REGISTER)
    AuthResDto register(@RequestBody RegisterDto registerDto){
        return authService.register(registerDto);
    }

    @PostMapping(ApiConstant.API_LOGIN)
    AuthResDto login(@RequestBody LoginDto loginDto){
        return authService.login(loginDto);
    }

}
