package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.ChangePasswordForm;
import com.rays.form.MyProfileForm;
import com.rays.form.UserForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value="User")
public class UserCtl extends BaseCtl<UserForm,UserDTO,UserServiceInt> {
	
	@Autowired
	public UserServiceInt userService;
	
	@Autowired
	RoleServiceInt roleService = null;
	
	@Autowired
	AttachmentServiceInt attachmentService;
	
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		RoleDTO dto = new RoleDTO();
		// dto.setStatus(RoleDTO.ACTIVE);
		List<DropdownList> list = roleService.search(dto, userContext);
		res.addResult("roleList", list);
		return res;
	}
	
	@PostMapping("myProfile")
	public ORSResponse myProfile(@RequestBody @Valid MyProfileForm form,BindingResult bindingResult) {
		
		ORSResponse res=validate(bindingResult);
		
		if(!res.isSuccess()) {
			return res;
		}
		//System.out.println("User ID = " + userContext.getUserId());
		UserDTO dto=baseService.findByLoginId(userContext.getLoginId(),userContext);
		
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setDob(form.getDob());
		dto.setPhone(form.getPhone());
		dto.setGender(form.getGender());
		
		baseService.update(dto, userContext);
		
		res.setSuccess(true);
		res.addMessage("Your Profile updated successfully..!!");
		return res;
	}
	
	@PostMapping("changePassword")
	public ORSResponse changePassword(@RequestBody @Valid ChangePasswordForm form,BindingResult bindingResult) {
		
		ORSResponse res=validate(bindingResult);
		
		if(!res.isSuccess()) {
			return res;
		}
		
		UserDTO changedDto=baseService.changePassword(form.getLoginId(),form.getOldPassword(),form.getNewPassword(),userContext);
		
		if(changedDto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Old Password");
			return res;
		}
		res.setSuccess(true);
		res.addMessage("Password has been changed");
		
		return res;
		
	}
	
	@PostMapping(value="profilePic/{userId}",consumes = "multipart/form-data")
	public ORSResponse uploadPic(@PathVariable Long userId,@RequestParam("file") MultipartFile file) {
		ORSResponse res=new ORSResponse();
		
		AttachmentDTO attachmentDto=new AttachmentDTO(file);
		
		attachmentDto.setDescription("Profile Pic");
		
		attachmentDto.setUserId(userId);
		
		UserDTO userDto=userService.findById(userId, userContext);
	
		
		if(userDto.getImageId()!=null && userDto.getImageId()>0) {
			attachmentDto.setId(userDto.getImageId());
		}
		
		Long imageId=attachmentService.save(attachmentDto, userContext);
		
		if(userDto.getImageId()==null) {
			userDto.setImageId(imageId);
			userService.update(userDto, userContext);
		}
		res.addResult("imageId", imageId);
		res.addResult("userId", userId);
		res.setSuccess(true);
		return res;
	}
	
	@GetMapping("profilePic/{userId}")
	public void downloadPic(@PathVariable Long userId,HttpServletResponse response) {
		try {
			UserDTO userDto=userService.findById(userId,userContext);
			
			AttachmentDTO attachmentDto=null;
			
			if(userDto!=null) {
				attachmentDto=attachmentService.findById(userDto.getImageId(),userContext);
			}
			if(attachmentDto!=null) {
				response.setContentType(attachmentDto.getType());
				OutputStream out=response.getOutputStream();
				out.write(attachmentDto.getDoc());
				out.close();
			}else {
				response.getWriter().write("ERROR:File Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
