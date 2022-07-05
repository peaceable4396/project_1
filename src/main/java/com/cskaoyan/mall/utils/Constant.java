package com.cskaoyan.mall.utils;

import java.text.SimpleDateFormat;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.utils
 * @className: Constan
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 16:04
 * @version: 1.0
 */
public class Constant {
    public static final String DOMAIN = "http://192.168.3.86:8084/";

    public static final String ORIGIN = "http://192.168.3.86:8080";

    public static final int SUCCESS_CODE = 200;

    public static final int NOT_FOUND_CODE = 404;

    public static final int ERROR_CODE = 500;

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final Integer NO_REPLY = 1;

    public static final Integer REPLIED = 0;

    public static final Boolean NO_COMMENT = false;

    public static final Boolean HAS_COMMENT = true;
}
