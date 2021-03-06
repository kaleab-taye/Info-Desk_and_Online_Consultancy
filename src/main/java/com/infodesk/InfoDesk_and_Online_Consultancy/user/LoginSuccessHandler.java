package com.infodesk.InfoDesk_and_Online_Consultancy.user;



import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
         
        String redirectURL = request.getContextPath();
         
        if (userDetails.hasCred("USER")) {
            redirectURL = "/list";
        } else if (userDetails.hasCred("ADMIN")) {
            redirectURL = "/adminView";
        }
         
        response.sendRedirect(redirectURL);
         
    }

    
 
}