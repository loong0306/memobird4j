package me.dragon.memobird.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.dragon.memobird.constant.MemoBirdConstant;
import me.dragon.memobird.model.dto.*;
import me.dragon.memobird.utils.HttpReqUtils;
import me.dragon.memobird.utils.MemobirdUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: MemoBirdServiceImpl. </p>
 * <p>Description 咕咕机开放API服务 </p>
 * @author dragon
 * @date 2018/3/26 下午4:42
 */
public class MemoBirdServiceImpl implements MemoBirdService {

    private final String API_RES_CODE = "showapi_res_code";
    private final String PRINT_CONTENT_ID = "printcontentid";

    /**
     * <p>Title: userBind. </p>
     * <p>用户绑定咕咕机接口 </p>
     * @param userBindDTO
     * @author dragon
     * @date 2018/3/26 下午6:55
     * @return java.lang.Boolean
     */
    @Override
    public Boolean userBind(UserBindDTO userBindDTO) throws Exception {
        Boolean res = false;
        // Combination params.
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("ak",  userBindDTO.getAk()));
        params.add(new BasicNameValuePair("timestamp",  URLEncoder.encode(MemobirdUtils.getTimestamp(), "UTF-8")));
        params.add(new BasicNameValuePair("memobirdID",  userBindDTO.getMemobirdID()));
        params.add(new BasicNameValuePair("useridentifying",  userBindDTO.getUseridentifying()));
        // Start GET MemoBird userBind API client.
        String resultJson = HttpReqUtils.doPosting(MemoBirdConstant.MEMOBIRD_USER_BIND, params);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        Integer apiResCode = (Integer) jsonObject.get(API_RES_CODE);
        if (1 == apiResCode) {
            res = true;
        }
        return res;
    }


    /**
     * <p>Title: printPaper. </p>
     * <p>咕咕机纸条打印接口 </p>
     * @param printPaperDTO
     * @author dragon
     * @date 2018/3/27 上午10:45
     * @return java.lang.Boolean
     */
    @Override
    public Boolean printPaper(PrintPaperDTO printPaperDTO) throws Exception {
        Boolean res = false;
        // Combination params.
        List<NameValuePair> printPaperParams = new ArrayList<>();
        printPaperParams.add(new BasicNameValuePair("ak",  printPaperDTO.getAk()));
        printPaperParams.add(new BasicNameValuePair("timestamp",  URLEncoder.encode(MemobirdUtils.getTimestamp(), "UTF-8")));
        printPaperParams.add(new BasicNameValuePair("printcontent", MemobirdUtils.getBase64Str("T:", printPaperDTO.getPrintcontent())));
        printPaperParams.add(new BasicNameValuePair("memobirdID",  printPaperDTO.getMemobirdID()));
        printPaperParams.add(new BasicNameValuePair("userID",  printPaperDTO.getUserID().toString()));
        // Start POST MemoBird printPaper API client.
        String resultJson = HttpReqUtils.doPosting(MemoBirdConstant.MEMOBIRD_PRINT_PAPER, printPaperParams);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        Integer apiResCode = (Integer) jsonObject.get(API_RES_CODE);
        if (1 == apiResCode) {
            String printContentID = jsonObject.get(PRINT_CONTENT_ID).toString();
            res = printStatus(printPaperDTO.getAk(), printContentID);
        } else {
            System.out.println("打印失败：错误原因代码 = " + resultJson);
        }
        return res;
    }


    /**
     * <p>Title: printStatus. </p>
     * <p>咕咕机打印状态查询 </p>
     * @param printContentID
     * @author dragon
     * @date 2018/3/27 下午2:33
     * @return java.lang.Boolean
     */
    @Override
    public Boolean printStatus(String ak, String printContentID) throws Exception {
        Boolean res = false;
        List<NameValuePair> printStatusParams = new ArrayList<>();
        printStatusParams.add(new BasicNameValuePair("ak",  ak));
        printStatusParams.add(new BasicNameValuePair("timestamp",  URLEncoder.encode(MemobirdUtils.getTimestamp(), "UTF-8")));
        printStatusParams.add(new BasicNameValuePair("printcontentid",  printContentID));
        String statusJson = HttpReqUtils.doPosting(MemoBirdConstant.MEMOBIRD_PRINT_STATUS, printStatusParams);
        Integer apiResCode = (Integer) JSON.parseObject(statusJson).get(API_RES_CODE);
        if (1 == apiResCode) {
            res = true;
        } else {
            System.out.println("查询打印状态失败：错误原因代码 = " + statusJson);
        }
        return res;
    }

    /**
     * <p>Title: printUrl. </p>
     * <p>咕咕机网页打印 </p>
     * @param printUrlDTO
     * @author dragon
     * @date 2018/3/27 下午2:57
     * @return java.lang.Boolean
     */
    @Override
    public Boolean printUrl(PrintUrlDTO printUrlDTO) throws Exception {
        Boolean res = false;
        // Combination params.
        List<NameValuePair> printUrlParams = new ArrayList<>();
        printUrlParams.add(new BasicNameValuePair("ak",  printUrlDTO.getAk()));
        printUrlParams.add(new BasicNameValuePair("timestamp",  URLEncoder.encode(MemobirdUtils.getTimestamp(), "UTF-8")));
        printUrlParams.add(new BasicNameValuePair("printUrl",  printUrlDTO.getPrintUrl()));
        printUrlParams.add(new BasicNameValuePair("memobirdID",  printUrlDTO.getMemobirdID()));
        // Start POST MemoBird printUrl API client.
        String resultJson = HttpReqUtils.doPosting(MemoBirdConstant.MEMOBIRD_PRINT_PAPER_FROMURL, printUrlParams);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        Integer apiResCode = (Integer) jsonObject.get(API_RES_CODE);
        if (1 == apiResCode) {
            String printContentID = jsonObject.get(PRINT_CONTENT_ID).toString();
            res = printStatus(printUrlDTO.getAk(), printContentID);
        } else {
            System.out.println("网页打印失败：错误原因代码 = " + resultJson);
        }
        return res;
    }


    /**
     * <p>Title: printUrl. </p>
     * <p>咕咕机网页打印 </p>
     * @param printHtmlDTO
     * @author dragon
     * @date 2018/3/27 下午4:52
     * @throws Exception
     * @return java.lang.Boolean
     */
    @Override
    public Boolean printHTML(PrintHtmlDTO printHtmlDTO) throws Exception {
        Boolean res = false;
        // Combination params.
        List<NameValuePair> printHTMLParams = new ArrayList<>();
        String html = HttpReqUtils.doGetHtml(printHtmlDTO.getPrintUrl(), printHTMLParams);
        printHTMLParams.add(new BasicNameValuePair("ak",  printHtmlDTO.getAk()));
        printHTMLParams.add(new BasicNameValuePair("timestamp",  URLEncoder.encode(MemobirdUtils.getTimestamp(), "UTF-8")));
        printHTMLParams.add(new BasicNameValuePair("printHtml",  MemobirdUtils.getBase64Str("", html)));
        printHTMLParams.add(new BasicNameValuePair("memobirdID",  printHtmlDTO.getMemobirdID()));
        printHTMLParams.add(new BasicNameValuePair("userID",  printHtmlDTO.getUserID().toString()));
        // Start POST MemoBird printHTML API client.
        String resultJson = HttpReqUtils.doPosting(MemoBirdConstant.MEMOBIRD_PRINT_HTML, printHTMLParams);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        Integer apiResCode = (Integer) jsonObject.get(API_RES_CODE);
        if (1 == apiResCode) {
            String printContentID = jsonObject.get(PRINT_CONTENT_ID).toString();
            res = printStatus(printHtmlDTO.getAk(), printContentID);
        } else {
            System.out.println("HTML打印失败：错误原因代码 = " + resultJson);
        }
        return res;
    }


    /**
     * <p>Title: printImg. </p>
     * <p>咕咕机单色位图打印 </p>
     * @param printImgDTO
     * @author dragon
     * @date 2018/3/27 下午7:06
     * @throws Exception
     * @return java.lang.Boolean
     */
    @Override
    public Boolean printImg(PrintImgDTO printImgDTO) throws Exception {
        Boolean res = false;
        // Combination params.
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("ak",  printImgDTO.getAk()));
        params.add(new BasicNameValuePair("memobirdID",  printImgDTO.getMemobirdID()));
        params.add(new BasicNameValuePair("imgBase64String",  printImgDTO.getImgBase64String()));
        // Start GET MemoBird printImg API client.
        String resultJson = HttpReqUtils.doPosting(MemoBirdConstant.MEMOBIRD_PRINT_IMG, params);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        Integer apiResCode = (Integer) jsonObject.get(API_RES_CODE);
        if (1 == apiResCode) {
            res = true;
        }
        return res;
    }
}
