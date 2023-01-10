package play.genshin.akasha.domain.artifact.exception;

import play.genshin.akasha.globals.error.ErrorCode;
import play.genshin.akasha.globals.error.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
