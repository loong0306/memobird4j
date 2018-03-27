package me.dragon.memobird.model.dto;

import lombok.Data;
import me.dragon.memobird.model.base.BaseSystemParams;

import java.io.Serializable;


/**
 * <p>Title: PrintHtmlDTO. </p>
 * <p>Description 咕咕机纸条打印HTML页面API请求参数 </p>
 * @author dragon
 * @date 2018/3/27 下午4:35
 */
@Data
public class PrintHtmlDTO extends BaseSystemParams implements Serializable {
    private static final long serialVersionUID = -1817377754226468811L;

    /**
     * printUrl URL地址
     * printHtml 咕咕机打印内容
     * HTML 源码需要进行 gbk 的 base64 编码，然后进行 URL 编码
     */
    private final String printUrl;
    private final String printHtml;

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
        private String printUrl;
        private String printHtml;
        private String memobirdID;
        private Integer userID;

        public Builder() {
        }

        public PrintHtmlDTO.Builder ak(String ak) {
            this.ak = ak;
            return this;
        }

        public PrintHtmlDTO.Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public PrintHtmlDTO.Builder printUrl(String printUrl) {
            this.printUrl = printUrl;
            return this;
        }

        public PrintHtmlDTO.Builder printHtml(String printHtml) {
            this.printHtml = printHtml;
            return this;
        }

        public PrintHtmlDTO.Builder memobirdID(String memobirdID) {
            this.memobirdID = memobirdID;
            return this;
        }

        public PrintHtmlDTO.Builder userID(Integer userID) {
            this.userID = userID;
            return this;
        }

        public PrintHtmlDTO build() {
            return new PrintHtmlDTO(this);
        }
    }

    private PrintHtmlDTO(PrintHtmlDTO.Builder builder) {
        ak = builder.ak;
        timestamp = builder.timestamp;
        printUrl = builder.printUrl;
        printHtml = builder.printHtml;
        memobirdID = builder.memobirdID;
        userID = builder.userID;
    }
}
