package org.springframework.boot.backend.listener;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class SessionListener implements HttpSessionListener {

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        log.info("New session is created. Adding Session to the counter.");
        counter.incrementAndGet();
        updateSessionCounter(se);

        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes()))
                .getRequest();
        String ipAddress =  request.getRemoteAddr();
        log.info("Session created!");
        log.info("The IP address is: " + ipAddress);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session destroyed. Removing the Session from the counter.");
        counter.decrementAndGet();  //decrementing counter
        updateSessionCounter(se);
    }

    private void updateSessionCounter(HttpSessionEvent httpSessionEvent){
        httpSessionEvent.getSession().getServletContext()
                .setAttribute("activeSession", counter.get());
        log.info("Total active session are {} ",counter.get());
    }

}
