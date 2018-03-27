package me.dragon.memobird.service;

import me.dragon.memobird.model.dto.*;

/**
 * <p>Title: MemoBirdService. </p>
 * <p>Description 咕咕机API接口服务 </p>
 * @author dragon
 * @date 2018/3/27 下午2:19
 */
public interface MemoBirdService {

    /**
     * <p>Title: userBind. </p>
     * <p>用户绑定咕咕机接口 </p>
     * @author dragon
     * @date 2018/3/26 下午6:55
     * @param userBindDTO
     * @throws Exception
     * @return java.lang.Boolean
     */
    Boolean userBind(UserBindDTO userBindDTO) throws Exception;

    /**
     * <p>Title: printPaper. </p>
     * <p>咕咕机纸条打印接口 </p>
     * @author dragon
     * @date 2018/3/27 上午10:45
     * @param printPaperDTO
     * @throws Exception
     * @return java.lang.Boolean
     */
    Boolean printPaper(PrintPaperDTO printPaperDTO) throws Exception;

    /**
     * <p>Title: printStatus. </p>
     * <p>咕咕机打印状态查询 </p>
     * @author dragon
     * @date 2018/3/27 下午2:33
     * @param ak
     * @param printContentID
     * @throws Exception
     * @return java.lang.Boolean
     */
    Boolean printStatus(String ak, String printContentID) throws Exception;

    /**
     * <p>Title: printUrl. </p>
     * <p>咕咕机网页打印 </p>
     * @param printUrlDTO
     * @author dragon
     * @date 2018/3/27 下午2:57
     * @throws Exception
     * @return java.lang.Boolean
     */
    Boolean printUrl(PrintUrlDTO printUrlDTO) throws Exception;

    /**
     * <p>Title: printHTML. </p>
     * <p>咕咕机HTML打印 </p>
     * @param printHtmlDTO
     * @author dragon
     * @date 2018/3/27 下午4:52
     * @throws Exception
     * @return java.lang.Boolean
     */
    Boolean printHTML(PrintHtmlDTO printHtmlDTO) throws Exception;

    /**
     * <p>Title: printImg. </p>
     * <p>咕咕机单色位图打印 </p>
     * @param printImgDTO
     * @author dragon
     * @date 2018/3/27 下午7:06
     * @throws Exception
     * @return java.lang.Boolean
     */
    Boolean printImg(PrintImgDTO printImgDTO) throws Exception;
}
