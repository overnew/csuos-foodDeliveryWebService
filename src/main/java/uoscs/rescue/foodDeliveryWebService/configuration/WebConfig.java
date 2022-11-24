package uoscs.rescue.foodDeliveryWebService.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uoscs.rescue.foodDeliveryWebService.interceptor.GeneralAuthorityCheckInterceptor;
import uoscs.rescue.foodDeliveryWebService.interceptor.SignCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SignCheckInterceptor())
                .order(1)
                //.addPathPatterns("/**")
                .excludePathPatterns(
                        "/**"
                        //"/", "/sign/signin", "/sign/signup",
                        //"/order/make-order",
                        //"/css/**", "/*.ico", "/error"
                );

        registry.addInterceptor(new GeneralAuthorityCheckInterceptor())
                .order(2);
                //.addPathPatterns( "/member/get-my-data");
    }*/
}
