package com.cskaoyan.mall.utils;

import com.cskaoyan.mall.service.impl.AdminServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.utils
 * @className: MybatisUtils
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 15:41
 * @version: 1.0
 */
public class MybatisUtils {
    private static SqlSessionFactory factory;

    static {
        //读取myabtis.xml主配置文件
        InputStream inputStream = AdminServiceImpl.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession openSession(){
        return factory.openSession();
    }
}
