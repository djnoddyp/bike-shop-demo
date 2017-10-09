package pnodder.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {

    private int openTime;
    private int closeTime;

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (openTime <= hour && hour < closeTime) {
            return true;
        }
        System.out.println("intercepted");
        //response.sendRedirect("http://localhost:8081/closed.html");
        return false;
    }

}
