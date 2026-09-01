package com.rays.ctl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.ForgetPasswordForm;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value="Auth")
public class LoginCtl extends BaseCtl<UserForm,UserDTO,UserServiceInt> {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form,BindingResult bindingResult, HttpSession session) throws Exception {
		
		
		ORSResponse res=validate(bindingResult);
		
		if(!res.success) {
			return res;
		}
		
		UserDTO dto=baseService.authenticate(form.getLoginId(), form.getPassword());
		
		if(dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login Id and Password");
		}else {
			UserContext context=new UserContext(dto);
			//For Non JWT case session.setAttribute("userContext", context);
			String token = jwtUtil.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());//For JWT case

			res.setSuccess(true);
			res.addData(dto);
			res.addResult("loginId",dto.getLoginId());
			res.addResult("role", dto.getRoleName());
			res.addResult("fname", dto.getFirstName());
			res.addResult("lname", dto.getLastName());
			res.addResult("token", token);//JWT token
			return res;
		}
				
		return res;
	}
	
	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form,BindingResult bindingResult) {
		
		ORSResponse res=validate(bindingResult);
		
		if(!res.success) {
			return res;
		}
		
		UserDTO dto=baseService.findByLoginId(form.getLoginId(), userContext);
		
		if(dto!=null) {
			res.setSuccess(false);
			res.addMessage("Login Id Already exists");
			return res;
		}
		
		dto=new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());
		dto.setGender(form.getGender());
		dto.setPhone(form.getPhoneNo());
		
		dto.setStatus("Inactive");
		dto.setRoleId(2L);
		
		baseService.register(dto, userContext);
		res.setSuccess(true);
		res.addMessage("User has been Registered Successfully");
		
		return res;
	}
	
	@GetMapping("logout")
	public ORSResponse logout(HttpSession session) throws Exception {
		ORSResponse res=new ORSResponse();
		session.invalidate();
		res.addMessage("Logout Successfully!!...");
		return res;
	}
	
	@PostMapping("forgetPassword")
	public ORSResponse forgetPassword(@RequestBody @Valid ForgetPasswordForm form,BindingResult bindingResult) {
		
		ORSResponse res=validate(bindingResult);
		
		if(!res.isSuccess()) {
			return res;
		}
		UserDTO fDto=baseService.forgotPassword(form.getLoginId());
		
		if(fDto == null) {
			res.setSuccess(false);
			res.addMessage("Login Id/Email Not found");
			return res;
		}else {
			res.setSuccess(true);
			res.addMessage("Hello"+ fDto.getFirstName()+" "+fDto.getLastName()+"..! Your password has been sent on your email.");
		}
		
		return res;
	}
	
}
