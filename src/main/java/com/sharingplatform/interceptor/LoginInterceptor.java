package com.sharingplatform.interceptor;

import com.sharingplatform.framework.mvc.SpringBootApplicationContext;
import com.sharingplatform.interceptor.adapter.service.UserInfoService;
import com.sharingplatform.interceptor.adapter.service.UserInfoServiceImp;
import com.sharingplatform.interceptor.domain.UserCreateCommand;
import com.sharingplatform.user.domain.BenzUser;
import com.sharingplatform.user.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hongying.fu on 4/12/2017.
 */
public class LoginInterceptor implements HandlerInterceptor {

//    @Autowired
    private UserQuery userQuery= SpringBootApplicationContext.getBean(UserQuery.class);

//    @Autowired
    private UserInfoService userInfoService =SpringBootApplicationContext.getBean(UserInfoServiceImp.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BenzUser benzUser = (BenzUser) request.getSession().getAttribute("user");
        if(benzUser!= null){
            return true;
        }
        BenzUser user=null;
        //synchronized (this){
            //String userId = request.getHeader("SM_USER").toUpperCase();
            String userId = "WELIU11".toUpperCase();
            // exits userid in database or not
            if(userId!=null && !"".equals(userId)){
                user= userQuery.findByUserId(userId);
                if (user == null) {
                    //create a user
                    UserCreateCommand command = new UserCreateCommand(userId,"user",false);
                    userInfoService.create(command);
                    user = userQuery.findByUserId(userId);
                }
            }
        //}
        request.getSession().setAttribute("user", user);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
