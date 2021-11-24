package com.eggplant.board.presentation.config.handler;

import com.eggplant.board.domain.user.entity.MyUserDetails;
import com.eggplant.board.domain.user.entity.User;
import com.eggplant.board.presentation.config.utils.TokenUtils;
import com.eggplant.board.presentation.constants.AuthConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) {
        final User user = ((MyUserDetails) authentication.getPrincipal()).getUser();
        final String token = TokenUtils.generateJwtToken(user);
        response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + token);
    }

}