package model.domain;

import lombok.Data;

/**
 * Created by luokai on 2017/7/5.
 */
@Data
public class UserDO {
    private String id;
    private String name;
    private Integer age;
    private String password;
    private String bankAccount;
    private String nickName;
}
