package play.genshin.akasha.globals.error;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),
    INVALID_TYPE_VALUE(400, "C002", "Invalid Type Value"),
    METHOD_NOT_ALLOWED(405, "C003", "Method Not Allowed"),
    ENTITY_NOT_FOUND(400, "C004", "Entity Not Found"),
    HANDLE_ACCESS_DENIED(403, "C005", "Access is Denied"),
    INTERNAL_SERVER_ERROR(500, "C006", "Server Error"),
    VERSION_NOT_FOUND(400, "C007", "버전 정보가 없습니다."),

    //user
    USER_NOT_FOUND(400, "U001", "없는 유저입니다."),

    ARTIFACT_NOT_FOUND(400, "A001", "해당 조건의 아티팩트가 없습니다.");

    private int status;
    private String code;
    private String message;
}
