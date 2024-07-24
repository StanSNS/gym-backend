package gym.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static gym.backend.consts.Error.ErrorConstants.INIT_DATA;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InitDataException extends RuntimeException {

    public InitDataException(String message) {
        super(String.format(INIT_DATA, message));
        Logger logger = LoggerFactory.getLogger(AccessDeniedException.class);
        logger.error(String.format(INIT_DATA, message), this);
    }
}