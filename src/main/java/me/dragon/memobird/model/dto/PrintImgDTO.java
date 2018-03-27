package me.dragon.memobird.model.dto;

import lombok.Data;
import me.dragon.memobird.model.base.BaseSystemParams;

import java.io.Serializable;

/**
 * <p>Title: PrintImgDTO. </p>
 * <p>Description 咕咕机单色位图打印API请求参数 </p>
 * @author dragon
 * @date 2018/3/27 下午7:04
 */
@Data
public class PrintImgDTO extends BaseSystemParams implements Serializable {
    private static final long serialVersionUID = -3599248028820068219L;

    /**
     * Jpg或者pngbase64的值
     */
    private final String imgBase64String;

    /**
     * 咕咕机ID
     */
    private final String memobirdID;

    public static class Builder {
        private String ak;
        private String memobirdID;
        private String imgBase64String;

        public Builder() {
        }

        public PrintImgDTO.Builder ak(String ak) {
            this.ak = ak;
            return this;
        }

        public PrintImgDTO.Builder memobirdID(String memobirdID) {
            this.memobirdID = memobirdID;
            return this;
        }

        public PrintImgDTO.Builder imgBase64String(String imgBase64String) {
            this.imgBase64String = imgBase64String;
            return this;
        }

        public PrintImgDTO build() {
            return new PrintImgDTO(this);
        }
    }

    private PrintImgDTO(PrintImgDTO.Builder builder) {
        ak = builder.ak;
        memobirdID = builder.memobirdID;
        imgBase64String = builder.imgBase64String;
    }
}
