package play.genshin.akasha.domain.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@NoArgsConstructor
@Table(name = "accessible_user")
public class User {
    @Id
    private String userName;

    private String userId;
    private String userPassword;
    private String registerPerson;
}
