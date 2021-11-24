package com.eggplant.board.presentation.config.interceptor;

import com.eggplant.board.presentation.config.utils.TokenUtils;
import com.eggplant.board.presentation.constants.AuthConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws IOException {
        final String header = request.getHeader(AuthConstants.AUTH_HEADER);

        if (header != null) {
            final String token = TokenUtils.getTokenFromHeader(header);
            if (TokenUtils.isValidToken(token)) {
                return true;
            }
        }
        response.sendRedirect("/error/unauthorized");
        return false;

    }

}
