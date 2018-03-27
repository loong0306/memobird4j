package me.dragon.memobird.model.dto;

import lombok.Data;
import me.dragon.memobird.model.base.BaseSystemParams;

import java.io.Serializable;

/**
 * <p>Title: PrintPaperDTO. </p>
 * <p>Description 咕咕机纸条打印API请求参数 </p>
 * @author dragon
 * @date 2018/3/27 上午10:52
 */
@Data
public class PrintPaperDTO extends BaseSystemParams implements Serializable {
    private static final long serialVersionUID = -8643965177085235327L;

    /**
     * 咕咕机打印内容
     * 文本内容(汉字要 GBK 格式的 Base64)/图片(图片为单色点位图)的 Base64 编码值
     * T:文本
     * P:图片
     */
    private final String printcontent;

    /**
     * 咕咕机ID
     */
    private final String memobirdID;

    /**
     * 咕咕机用户ID
     */
    private final Integer userID;

    public static class Builder {
        private String ak;
        private String timestamp;
        private String printcontent;
        private String memobirdID;
        private Integer userID;

        public Builder() {
        }

        public PrintPaperDTO.Builder ak(String ak) {
            this.ak = ak;
            return this;
        }

        public PrintPaperDTO.Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public PrintPaperDTO.Builder printcontent(String printcontent) {
            this.printcontent = printcontent;
            return this;
        }

        public PrintPaperDTO.Builder memobirdID(String memobirdID) {
            this.memobirdID = memobirdID;
            return this;
        }

        public PrintPaperDTO.Builder userID(Integer userID) {
            this.userID = userID;
            return this;
        }

        public PrintPaperDTO build() {
            return new PrintPaperDTO(this);
        }
    }

    private PrintPaperDTO(PrintPaperDTO.Builder builder) {
        ak = builder.ak;
        timestamp = builder.timestamp;
        printcontent = builder.printcontent;
        memobirdID = builder.memobirdID;
        userID = builder.userID;
    }
}
