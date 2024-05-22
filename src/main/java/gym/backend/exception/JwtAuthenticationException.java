package gym.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static gym.backend.consts.Error.ErrorConstants.JWT_AUTHENTICATION_FAILURE;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class JwtAuthenticationException extends RuntimeException {

    public JwtAuthenticationException() {
        super(JWT_AUTHENTICATION_FAILURE);
        Logger logger = LoggerFactory.getLogger(JwtAuthenticationException.class);
        logger.error(JWT_AUTHENTICATION_FAILURE, this);
    }
}