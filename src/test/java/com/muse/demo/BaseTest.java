package com.muse.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected static Properties properties;
    protected static MuseClient client;
    protected static String partnerId;

    @BeforeAll
    public static void init() throws IOException {
        // 通过 ClassLoader 读取 config.properties 文件
        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("config.properties");
        if (inputStream == null) {
            throw new IOException("Properties file not found!");
        }

        // 加载 properties 文件
        properties = new Properties();
        properties.load(inputStream);

        partnerId = properties.getProperty("partnerId");
        client = MuseClient.build(
                properties.getProperty("baseUrl"),
                properties.getProperty("privateKey"),
                properties.getProperty("platformKey"),
                properties.getProperty("partnerId")
        );
    }
}
