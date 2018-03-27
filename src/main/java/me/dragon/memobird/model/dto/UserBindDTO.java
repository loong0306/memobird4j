package me.dragon.memobird.model.dto;

import lombok.Data;
import me.dragon.memobird.model.base.BaseSystemParams;

import java.io.Serializable;

/**
 * <p>Title: UserBindDTO. </p>
 * <p>Description 咕咕机用户绑定APi请求参数 </p>
 * @author dragon
 * @date 2018/3/26 下午3:58
 */
@Data
public class UserBindDTO extends BaseSystemParams implements Serializable {
    private static final long serialVersionUID = 6059768264855665925L;

    /**
     * 咕咕机ID
     */
    private final String memobirdID;

    /**
     * 咕咕机用户ID
     */
    private final String useridentifying;



    public static class Builder {
        private String ak;
        private String timestamp;
        private String memobirdID;
        private String useridentifying;

        public Builder() {
        }

        public Builder ak(String ak) {
            this.ak = ak;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder memobirdID(String memobirdID) {
            this.memobirdID = memobirdID;
            return this;
        }

        public Builder useridentifying(String useridentifying) {
            this.useridentifying = useridentifying;
            return this;
        }

        public UserBindDTO build() {
            return new UserBindDTO(this);
        }
    }

    private UserBindDTO(Builder builder) {
        ak = builder.ak;
        timestamp = builder.timestamp;
        memobirdID = builder.memobirdID;
        useridentifying = builder.useridentifying;
    }
}
