// 
// 
// 

package com.ldu.controller;

import javax.annotation.Resource;
import com.ldu.service.CatelogService;
import org.springframework.stereotype.Controller;

@Controller
public class CatelogController
{
    @Resource
    private CatelogService catelogService;
}
