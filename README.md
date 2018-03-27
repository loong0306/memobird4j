# memobird4j
Java SDK for memobird. :sunny: Morning GuGu.

![](https://static.wixstatic.com/media/612054_55f9859721c34335bb63aff32da40cc1~mv2.png/v1/fill/w_340,h_84,al_c,lg_1/612054_55f9859721c34335bb63aff32da40cc1~mv2.png)
<br/><br/>
咕咕机JAVA-SDK-API
[咕咕机官网提供的API文档接口](http://183.91.33.12/cache/open.memobird.cn/upload/webapi.pdf?ich_args=b3f8f94c58d93ed8d72a799aef337a62_1_0_0_4_3eb1a3da2d10ccd2a52413b9e5bda0510ec9396c8e383625dbe25006aecaa5c9_985cd986be54662fdbe4a8e44a6a5d93_1_0&ich_ip=33-25)

萌新咕咕号：459266 欢迎各位咕友来撩，嘤x3
<br/>
小纸条传送门：
<br/>
![](https://img-dragon-resume.oss-cn-beijing.aliyuncs.com/memobird.png)

* [使用](#使用)
* [接口](#接口)
* [打印示例](#打印示例)

## 使用
将memobird编译成jar包，或直接引入项目。
需要设置的参数如下：
```java
MemoBirdService memobirdService = new MemoBirdServiceImpl();
/**
 * MP申请的AK
 */
public static final String AK = "";
/**
 * 咕咕机设备编号
 */
public static final String MEMOBIRDID = "";
/**
 * 咕咕号
*/
public static final String USER_IDENTIFY = "";
/**
 * 咕咕用户ID
 */
public static final Integer USER_ID = 0;
```

## 接口
目前memobird4j共有6个接口
* userBind 用户绑定咕咕机接口
* printPaper 咕咕机纸条打印接口
* printStatus 咕咕机打印状态查询
* printUrl 咕咕机网页打印
* printHTML 咕咕机HTML打印
* printImg 咕咕机单色位图打印


## 打印示例
```java
// 用户绑定咕咕机接口
UserBindDTO userBindDTO = new UserBindDTO.Builder()
		                    .ak(AK)
		                    .timestamp(MemobirdUtils.getTimestamp())
		                    .memobirdID(MEMOBIRDID)
		                    .useridentifying(USER_IDENTIFY)
		                    .build();
memobirdService.userBind(userBindDTO);

// 咕咕机纸条打印接口
PrintPaperDTO printPaperDTO = new PrintPaperDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .printcontent("测试打印咕咕机纸条!!!")
                    .memobirdID(MEMOBIRDID)
                    .userID(USER_ID)
                    .build();
memobirdService.printPaper(printPaperDTO);

// 咕咕机网页打印
PrintUrlDTO printUrlDTO = new PrintUrlDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .printUrl("https://www.dragon-yuan.me")
                    .memobirdID(MEMOBIRDID)
                    .build();
memobirdService.printUrl(printUrlDTO);

// 咕咕机HTML打印
PrintHtmlDTO printHtmlDTO = new PrintHtmlDTO.Builder()
                    .ak(AK)
                    .timestamp(MemobirdUtils.getTimestamp())
                    .printUrl("http://loong.moe/")
                    .memobirdID(MEMOBIRDID)
                    .userID(USER_ID)
                    .build();
mmemobirdService.printHTML(printHtmlDTO);

// 咕咕机打印状态查询 已添加至各打印接口中
```
