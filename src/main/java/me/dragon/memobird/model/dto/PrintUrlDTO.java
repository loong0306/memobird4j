package me.dragon.memobird.model.dto;

import lombok.Data;
import me.dragon.memobird.model.base.BaseSystemParams;

import java.io.Serializable;

/**
 * <p>Title: PrintPaperDTO. </p>
 * <p>Description 咕咕机纸条打印API请求参数 </p>
 * @author dragon
 * @date 2018年03月27日14:52:02
 */
@Data
public class PrintUrlDTO extends BaseSystemParams implements Serializable {
    private static final long serialVersionUID = 5643932948900901697L;

    /**
     * 所需打印的URL地址
     */
    private final String printUrl;

    /**
     * 咕咕机ID
     */
    private final String memobirdID;


    public static class Builder {
        private String ak;
        private String timestamp;
        private String printUrl;
        private String memobirdID;

        public Builder() {
        }

        public PrintUrlDTO.Builder ak(String ak) {
            this.ak = ak;
            return this;
        }

        public PrintUrlDTO.Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public PrintUrlDTO.Builder printUrl(String printUrl) {
            this.printUrl = printUrl;
            return this;
        }

        public PrintUrlDTO.Builder memobirdID(String memobirdID) {
            this.memobirdID = memobirdID;
            return this;
        }

        public PrintUrlDTO build() {
            return new PrintUrlDTO(this);
        }
    }

    private PrintUrlDTO(PrintUrlDTO.Builder builder) {
        ak = builder.ak;
        timestamp = builder.timestamp;
        printUrl = builder.printUrl;
        memobirdID = builder.memobirdID;
    }
}
