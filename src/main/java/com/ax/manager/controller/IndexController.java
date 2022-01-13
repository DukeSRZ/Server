package com.ax.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: LoginController
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public String tologin() {
        logger.info("定向登陆页");
        return "login";
    }

    @RequestMapping("home")
    public String home() {
        logger.info("定向主页");
        return "home";
    }

    @RequestMapping("user")
    public String user() {
        logger.info("定向到用户管理页");
        return "userManage";
    }

    @RequestMapping("logout")
    public String logout() {
        logger.info("退出系统");
        Subject subject = SecurityUtils.getSubject();
        subject.logout(); // shiro底层删除session的会话信息
        return "redirect:login";
    }

    @RequestMapping("index")
    public String index() {
        logger.info("门户首页");
        return "index";
    }

    @RequestMapping("about")
    public String about() {
        logger.info("关于门户");
        return "about";
    }

    @RequestMapping("case")
    public String cases() {
        logger.info("案例");
        return "case";
    }

    @RequestMapping("news")
    public String news() {
        logger.info("动态");
        return "news";
    }

    @RequestMapping("newsDetail")
    public String newsDetail() {
        logger.info("动态详情页");
        return "newsDetail";
    }

    @RequestMapping("product")
    public String product() {
        logger.info("产品");
        return "product";
    }
}
