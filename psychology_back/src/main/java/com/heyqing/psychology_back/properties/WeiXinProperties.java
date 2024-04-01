package com.heyqing.psychology_back.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:WeiXinProperties
 * Package:com.heyqing.psychology_back.properties
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
@Component
@ConfigurationProperties(prefix = "weixin")
@Data
public class WeiXinProperties {

    private String jscode2sessionUrl; // 登录凭证校验请求地址

    private String appid; // 小程序 appId

    private String secret; // 小程序 appSecret

}
