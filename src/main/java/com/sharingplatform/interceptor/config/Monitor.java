package com.benz.interceptor.config;

import com.benz.framework.domain.Operator;
import com.benz.user.domain.BenzUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hongying.fu on 4/12/2017.
 */
@Component
@Aspect
public class Monitor {
    @Before("execution(* com.benz..adapter.web.*Controller.*(..))")
    public void invoke(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        BenzUser user = (BenzUser) request.getSession().getAttribute("user");
        writeOperatorArgs(joinPoint, user.getId());
    }

    private void writeOperatorArgs(JoinPoint joinPoint, Long operatorId) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (!(arg instanceof Operator)) {
                continue;
            }
            Operator operator = (Operator) arg;
            operator.setOperatorId(operatorId);
        }
    }
}

