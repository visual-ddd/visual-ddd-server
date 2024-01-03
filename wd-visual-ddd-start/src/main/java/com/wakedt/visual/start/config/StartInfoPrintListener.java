package com.wakedt.visual.start.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/***
 * @author wangchensheng
 * @version 1.0
 */
@Slf4j
@Component
public class StartInfoPrintListener implements ApplicationListener<ApplicationContextEvent> {

    private static final String PORT = "server.port";
    public static final String DEFAULT_PORT = "8080";
    public static final String SERVER_SERVLET_CONTEXT_PATH = "server.servlet.context-path";

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        startInfoPrint(applicationContext);
    }

    /**
     * 打印启动日志
     *
     * @param application application
     * @throws UnknownHostException UnknownHostException
     */
    private static void startInfoPrint(ApplicationContext application) throws UnknownHostException {
        Environment env = application.getEnvironment();
        String ip = getIpAddress();
        String port = env.getProperty(PORT);
        port = port == null ? DEFAULT_PORT : port;
        String path = env.getProperty(SERVER_SERVLET_CONTEXT_PATH);
        path = path == null ? StringUtils.EMPTY : path;
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Demo is running! Access URLs:\n\t" +
                "本地访问地址: \thttp://localhost:" + port + path + "/\n\t" +
                "外部访问地址: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }

    /**
     * 从网卡中获取IP
     *
     * @return 本机ip地址
     */
    public static String getIpAddress() {
        try {
            // 从网卡中获取IP
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                // 用于排除回送接口,非虚拟网卡,未在使用中的网络接口
                if (!netInterface.isLoopback() && !netInterface.isVirtual() && netInterface.isUp()) {
                    // 返回和网络接口绑定的所有IP地址
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("IP地址获取失败" + e);
        }
        return "";
    }
}
