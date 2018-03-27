package me.dragon.memobird.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * <p>Title: MemobirdUtils. </p>
 * <p>Description 时间工具 </p>
 * @author dragon
 * @date 2018/3/26 下午4:34
 */
public class MemobirdUtils {

    /**
     * 获取时间戳
     * @return String
     */
    public static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        return time;
    }

    /**
     * <p>Title: getBase64Str. </p>
     * <p>转换Base64 </p>
     * @param tag 标记 (T:表示文字 P:表示图片 空:表示HTML)
     * @param str
     * @author dragon
     * @date 2018/3/27 下午4:52
     * @return String
     */
    public static String getBase64Str(String tag, String str) throws UnsupportedEncodingException {
        String res = tag + Base64.getMimeEncoder().encodeToString(str.getBytes("GBK"));
        return res;
    }
}
