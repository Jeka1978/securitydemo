package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jeka
 */
@RestController
public class Controller {

	@GetMapping("/admin/service")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminService(){
		return "adminnn";
	}

	@GetMapping("/user/service")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userService(){
		return "userrr";
	}

	@GetMapping("/common/service")
	public String commonService(HttpServletRequest request){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getDetails());
		return "logged in user: " + request.getRemoteUser();

	}
}
