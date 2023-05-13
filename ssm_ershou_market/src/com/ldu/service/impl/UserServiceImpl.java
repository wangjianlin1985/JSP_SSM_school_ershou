// 
// 
// 

package com.ldu.service.impl;

import java.io.InputStream;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.ldu.pojo.User;
import javax.annotation.Resource;
import com.ldu.dao.UserMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;
    
    @Override
    public void addUser(final User user) {
        this.userMapper.insert(user);
    }
    
    @Override
    public User getUserByPhone(final String phone) {
        final User user = this.userMapper.getUserByPhone(phone);
        return user;
    }
    
    @Override
    public void updateUserName(final User user) {
        this.userMapper.updateByPrimaryKey(user);
    }
    
    @Override
    public int updateGoodsNum(final Integer id, final Integer goodsNum) {
        return this.userMapper.updateGoodsNum(id, goodsNum);
    }
    
    @Override
    public User selectByPrimaryKey(final Integer id) {
        final User user = this.userMapper.selectByPrimaryKey(id);
        return user;
    }
    
    @Override
    public List<User> getPageUser(final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<User> list = this.userMapper.getUserList();
        return list;
    }
    
    @Override
    public int getUserNum() {
        final List<User> users = this.userMapper.getUserList();
        return users.size();
    }
    
    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        }
        catch (Exception ex) {}
        return session;
    }
    
    public static HttpServletRequest getRequest() {
        final ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
    
    @Override
    public int getUserNum(final String username) {
        return 0;
    }
    
    public InputStream getInputStream1SS() throws Exception {
        return null;
    }
    
    @Override
    public List<User> getPageUser(final int pageNum, final int pageSize, final String username) {
        return null;
    }
    
    @Override
    public User getUserById(final int id) {
        return this.userMapper.getUserById(id);
    }
    
    @Override
    public void deleteUserById(final String ids) {
        this.userMapper.deleteByPrimaryKey(Integer.parseInt(ids));
    }
    
    @Override
    public List<User> getPageUserByUser(final String phone, final String username, final String qq, final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<User> list = this.userMapper.getUserListByUser(phone, username, qq);
        return list;
    }
    
    @Override
    public List<User> getUserOrderByDate(final int size) {
        PageHelper.startPage(1, size);
        final List<User> list = this.userMapper.getUserListOrderByCreateAt();
        return list;
    }
}
