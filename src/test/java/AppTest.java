import me.dragon.memobird.model.dto.*;
import me.dragon.memobird.service.MemoBirdService;
import me.dragon.memobird.service.MemoBirdServiceImpl;
import me.dragon.memobird.utils.MemobirdUtils;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest {

    MemoBirdService memobirdService = new MemoBirdServiceImpl();
    /**
     * AK
     */
    public static final String AK = "";
    /**
     * 咕咕机设备编号
     */
    public static final String MEMOBIRDID = "";
    /**
     * 咕咕机用户ID
     */
    public static final String USER_IDENTIFY = "";
    /**
     * 用户ID
     */
    public static final Integer USER_ID = 459266;


    @Test
    public void getUserBind() {
        try {
            UserBindDTO userBindDTO = new UserBindDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .memobirdID(MEMOBIRDID)
                    .useridentifying(USER_IDENTIFY)
                    .build();
            Boolean res = memobirdService.userBind(userBindDTO);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printPaper() {
        try {
            PrintPaperDTO printPaperDTO = new PrintPaperDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .printcontent("测试打印咕咕机纸条!!!")
                    .memobirdID(MEMOBIRDID)
                    .userID(USER_ID)
                    .build();
            Boolean res = memobirdService.printPaper(printPaperDTO);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void printUrl() {
        try {
            PrintUrlDTO printUrlDTO = new PrintUrlDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .printUrl("https://www.dragon-yuan.me")
                    .memobirdID(MEMOBIRDID)
                    .build();
            Boolean res = memobirdService.printUrl(printUrlDTO);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void printHTML() {
        try {
            PrintHtmlDTO printHtmlDTO = new PrintHtmlDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .printUrl("http://loong.moe/")
                    .memobirdID(MEMOBIRDID)
                    .userID(USER_ID)
                    .build();
            Boolean res = memobirdService.printHTML(printHtmlDTO);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void printImg() {
        try {
            String imgBase64String = "";
            String imgUrl = "https://www.dragon-yuan.me/baidu.jpg";
            // 读取网络图片
            URL url = new URL(imgUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1 ) {
                outStream.write(buffer, 0, len);
            }
            inputStream.close();
            imgBase64String = Base64.encodeBase64String(outStream.toByteArray());
            PrintImgDTO printImgDTO = new PrintImgDTO.Builder()
                    .ak(AK)
                    .imgBase64String(imgBase64String)
                    .build();
            Boolean res = memobirdService.printImg(printImgDTO);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
