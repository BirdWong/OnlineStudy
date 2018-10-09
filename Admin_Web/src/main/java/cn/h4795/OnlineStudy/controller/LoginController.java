package cn.h4795.OnlineStudy.controller;

import entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2018/7/23 0023
 */
@RestController
@RequestMapping("/login")
public class LoginController {

        @RequestMapping("/index")
        public Result index(){
                return  new Result(false,"请先登录");
        }

        @RequestMapping("/error")
        public Result error(){
                return new Result(false,"账户或密码错误");
        }


        @RequestMapping("/success")
        public Result success(){
                return new Result(true , "登录成功");
        }
}
