package com.cskaoyan.mall.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.utils
 * @className: getRequestBody
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 17:37
 * @version: 1.0
 */
public class RequestBodyUtil {
    public static String get(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int length = 0;
        byte[] bytes = new byte[1024];
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }
        String requestBody = outputStream.toString("utf-8");
        return requestBody;
    }
}
