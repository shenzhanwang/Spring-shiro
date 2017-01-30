package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pagemodel.DataGrid;
import pagemodel.UserInfo;
import po.Permission;
import po.Role;
import po.User;
import service.RoleService;

@Controller
public class RoleController {
	@Autowired
	RoleService roleservice;
	
	@RequestMapping(value="/roles",method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<Role> getPageRoles(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		DataGrid<Role> grid=new DataGrid<Role>();
		int total=roleservice.getroles().size();
		List<Role> list=roleservice.getpagerole(current, rowCount);
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}
	
}
