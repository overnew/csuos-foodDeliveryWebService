package uoscs.rescue.foodDeliveryWebService.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class SignCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute(SessionConst.SIGN_ID) == null){
            log.info("REQUEST rejected");
            return false; //false return 시 모든거 종료: 거부
        }

        //log.info("REQUEST confirm");
        return true;
    }
}
