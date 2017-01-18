package controller;

import java.util.List;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pagemodel.MSG;
import pagemodel.UserValidate;
import po.User;
import service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/users",method = RequestMethod.GET)
	@ResponseBody
	public List<User> getusers(){
		List<User> list=userservice.getallusers();
		return list;
	}
	
	@RequestMapping(value="/users/roles",method = RequestMethod.GET)
	@ResponseBody
	public Set<String> getuserroles(){
		Set<String> list=userservice.findRoles("zhang");
		return list;
	}
	
	@RequestMapping(value="/users/permissions",method = RequestMethod.GET)
	@ResponseBody
	public Set<String> getpermissions(){
		Set<String> list=userservice.findPermissions("zhang");
		return list;
	}
	
	 @RequestMapping(value="/loginvalidate",method = RequestMethod.POST)
	 @ResponseBody
	 public MSG login(@RequestBody UserValidate userValidate) {
		   UsernamePasswordToken token = new UsernamePasswordToken(userValidate.getUsername(), userValidate.getPassword());
		   try {
			   SecurityUtils.getSubject().login(token);
			   MSG msg=new MSG("login success");
			   return msg;
			} catch ( UnknownAccountException uae ) {
				MSG msg=new MSG("error username");
				return msg;
			} catch ( IncorrectCredentialsException ice ) {
				MSG msg=new MSG("error password");
				return msg;
			} catch ( LockedAccountException lae ) {
				MSG msg=new MSG("locked user");
				return msg;
			}
	 }
	 
}
