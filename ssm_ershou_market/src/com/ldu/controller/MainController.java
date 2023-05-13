// 
// 
// 

package com.ldu.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ldu.pojo.User;
import java.util.List;
import com.ldu.util.UserGrid;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.ldu.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class MainController
{
    @Resource
    private UserService userService;
    
    @RequestMapping({ "/userList" })
    @ResponseBody
    public UserGrid getUserList(@RequestParam("current") final int current, @RequestParam("rowCount") final int rowCount) {
        final int total = this.userService.getUserNum();
        final List<User> list = this.userService.getPageUser(current, rowCount);
        final UserGrid userGrid = new UserGrid();
        userGrid.setCurrent(current);
        userGrid.setRowCount(rowCount);
        userGrid.setRows(list);
        userGrid.setTotal(total);
        return userGrid;
    }
}
