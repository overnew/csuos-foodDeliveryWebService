package uoscs.rescue.foodDeliveryWebService.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class GeneralAuthorityCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute(SessionConst.SESSION_FORM) == null){
            return false;
        }

        SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);
        if(sessionForm.getAuthority() != Authority.GENERAL){
            log.info("REQUEST Authority reject: [authority: {}]", sessionForm.getAuthority());
            return false;
        }

        return true;
    }
}
