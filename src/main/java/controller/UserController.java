package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pagemodel.DataGrid;
import pagemodel.MSG;
import pagemodel.UserInfo;
import pagemodel.UserValidate;
import po.User;
import service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/users",method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<UserInfo> getusers(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		DataGrid<UserInfo> grid=new DataGrid<UserInfo>();
		List<User> list=userservice.getallusers();
		int total=list.size();
		List<User> pageuser=userservice.getpageusers(current, rowCount);
		List<UserInfo> userlist=new ArrayList<UserInfo>();
		for(User u:pageuser){
			UserInfo info=new UserInfo();
			info.setId(u.getUserid());
			info.setLocked(u.getLocked());
			info.setUsername(u.getUsername());
			Set<String> set=userservice.findRoles(u.getUsername());
			info.setRoles(set.toString());
			userlist.add(info);
		}
		grid.setCurrent(current);
		grid.setTotal(total);
		grid.setRowCount(rowCount);
		grid.setRows(userlist);
		return grid;
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value="/users/permissions",method = RequestMethod.GET)
	@ResponseBody
	public Set<String> getpermissions(){
		//SecurityUtils.getSubject().checkRole("admin");
		Set<String> list=userservice.findPermissions("zhang");
		return list;
	}
	
	 @RequestMapping(value="/loginvalidate",method = RequestMethod.POST)
	 @ResponseBody
	 public MSG login(@RequestBody UserValidate userValidate) {
		   UsernamePasswordToken token = new UsernamePasswordToken(userValidate.getUsername(), userValidate.getPassword());
		   token.setRememberMe(userValidate.getRememberme());
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
	 
	 @RequestMapping(value="/users",method = RequestMethod.POST)
	 @ResponseBody
	 public User adduser(@RequestBody User u){
		User user=userservice.createUser(u); 
		return user;
	 }
	 
	 @RequestMapping(value="/users/{uid}",method = RequestMethod.PUT)
	 @ResponseBody
	 public User updateuser(@PathVariable Long uid,@RequestBody User u){
		User user=userservice.updateuser(u);
		return user;
	 }
	 
	 @RequestMapping(value="/users/{uid}",method = RequestMethod.DELETE)
	 @ResponseBody
	 public MSG deleteuser(@PathVariable Long uid){
		 try{
			SecurityUtils.getSubject().checkRole("admin");
			userservice.deleteuser(uid);
			return new MSG("delete success");
		 }catch(Exception e){
			 e.printStackTrace();
			return new MSG("delete failed");
		 }
	 }
	 
	 
}
