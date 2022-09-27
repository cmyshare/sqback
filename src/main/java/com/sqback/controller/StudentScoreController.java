package com.sqback.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqback.dao.entity.StudentScore;
import com.sqback.service.StudentScoreService;
import com.sqback.utils.sqBackResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class StudentScoreController {

    @Autowired
    private StudentScoreService studentScoreService;


    //查看学生学生成绩
    @ApiOperation(value="查询学生成绩",notes = "根据表单信息查询")
    @PostMapping("/api/studentScore")
    private sqBackResult getStudentScore(@RequestBody StudentScore studentScore, HttpServletRequest request) throws Exception{

        //从session中获取以piccode为标记的验证码
        String captcha = (String) request.getSession().getAttribute("piccode");
        //System.out.println("session码"+captcha);
        //System.out.println("验证码"+code);
        //StringUtils.isEmpty(studentScore.getCode()) || !captcha.equalsIgnoreCase(studentScore.getCode())

        //压测时，这里会出莫名错，匹配相等却报错
        //if (!captcha.equals(studentScore.getCode())){
        //    return sqBackResult.build(500,"验证码错误");
        //}

        //默认从数据库里读取
        sqBackResult sqBackResult=studentScoreService.findStudentScore(studentScore.getSid());

        return  sqBackResult;
    }

    //验证码请求 可以使用谷歌验证码生成以流的形式返回
    @ApiOperation(value="验证码请求",notes = "生成验证码图片")
    @GetMapping(value = "/api/captcha",produces = "image/jpg")
    private void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println("验证码刷新成功！");
        //定义图片对象
        BufferedImage img = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        // 得到该图片的绘图对象
        Graphics g = img.getGraphics();
        Random r = new Random();
        Color c = new Color(200, 150, 255);
        g.setColor(c);

        // 填充整个图片的颜色
        g.fillRect(0, 0, 68, 22);

        // 向图片中输出数字和字母
        StringBuffer sb = new StringBuffer();
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int index, len = ch.length;
        for (int i = 0; i < 4; i++) {
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));// 输出的字体和大小
            g.drawString("" + ch[index], (i * 15) + 3, 18);// 写什么数字，在图片的中的位置
            sb.append(ch[index]);
        }

//        System.out.println("打印验证码"+sb.toString());
        request.getSession().setAttribute("piccode", sb.toString()); //验证码放入session中
        ImageIO.write(img, "JPG", response.getOutputStream()); //验证码以ImageIO流输出
        response.getOutputStream().flush();  //清空输出流
        response.getOutputStream().close(); //关闭输出流
    }




}
