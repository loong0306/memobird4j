package me.dragon.memobird.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: BaseSystemParams. </p>
 * <p>Description 咕咕机APi系统级别参数 </p>
 * @author dragon
 * @date 2018/3/27 上午10:47
 */
@Data
public class BaseSystemParams implements Serializable {
    private static final long serialVersionUID = -2513936816198145724L;

    /**
     * 软件签名
     */
    public String ak;

    /**
     * 客户端时间
     */
    public String timestamp;

}
