package play.genshin.akasha.domain.artifact.exception;

import play.genshin.akasha.globals.error.ErrorCode;
import play.genshin.akasha.globals.error.exception.BusinessException;

public class ArtifactNotFound extends BusinessException {
    public ArtifactNotFound(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
