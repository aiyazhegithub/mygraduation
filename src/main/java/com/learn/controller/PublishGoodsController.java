package com.learn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.commons.tool.TotalData;
import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.PublishGoodsMapper;
import com.learn.pojo.PublishGoods;
import com.learn.pojo.PublishGoodsExample;
import com.learn.pojo.UserInfo;
import com.learn.service.impl.PublishGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("publish")
public class PublishGoodsController {

    @Autowired
    private PublishGoodsMapper publishGoodsMapper;

    @Autowired
    private PublishGoodsServiceImpl publishGoodsService;

    //图片上传放置的位置
    @Value("${IMGPATH}")
    private String IMGPATH;

    public String getIMGPATH() {
        return IMGPATH;
    }

    /**
     * 跳转到发布页面
     * @return
     */
    @RequestMapping("tolist")
    public String toPublishList() {

        return "sell_form";
    }


    @RequestMapping("list")
    public String listOderByDESC(Integer type, Model model, HttpServletRequest request){
        UserInfo userInfo = SessionUtils.getUserInfo(request);

        PageInfo<PublishGoods> pageInfo = PageHelper.startPage(1, 8).
                doSelectPageInfo(
                        () -> {
                            PublishGoods publishGoods = new PublishGoods();
                            publishGoods.setUserId(userInfo.getId());
                            publishGoods.setGoodsType(type);
                            publishGoodsService.listOderByDESC(publishGoods);
                        }
                );
        model.addAttribute("type", type);
        model.addAttribute("pageInfo", pageInfo);


        return "list";

    }


    @RequestMapping("add")
    public String addpublishGoods(Model model,
                                  HttpServletRequest  request,
                                  PublishGoods publishGoods,
                                  MultipartFile[] uploadFile) throws IOException {

        UserInfo userInfo = SessionUtils.getUserInfo(request);
        publishGoods.setUserId(userInfo.getId());

        if (publishGoods.getTitle() == null) {
            TotalData totalData=new TotalData("标题不能未为空");
            model.addAttribute("data",totalData);
            return "sell_form";
        }else if(publishGoods.getOprice()==null){
            TotalData totalData=new TotalData("商品原价不能未为空");
            model.addAttribute("data",totalData);
            return "sell_form";
        }else if(publishGoods.getSprice()==null){
            TotalData totalData=new TotalData("商品出售价格不能未为空");
            model.addAttribute("data",totalData);
            return "sell_form";
        }else if(publishGoods.getUserId()==null){
            TotalData totalData=new TotalData("发送错误请重新登陆");
            model.addAttribute("data",totalData);
            return "sell_form";
        }
        for (MultipartFile f : uploadFile) {
            //获取原文件名
            String originalFilename = f.getOriginalFilename();

            System.out.println(uploadFile.length);
            if (originalFilename.trim().length()<=0) {
                TotalData totalData = new TotalData("图片不能为空");
                model.addAttribute("data", totalData);

                return "sell_form";

            }
        }



        if (null != uploadFile) {

            System.out.println(IMGPATH+"IMG");
            String img = "";
            for (MultipartFile f : uploadFile) {
                String picName = UUID.randomUUID().toString();
                //获取原文件名
                String originalFilename = f.getOriginalFilename();
                //获取文件扩展名
                String substring = originalFilename.substring(originalFilename.lastIndexOf('.'));
                //图片写入磁盘
                img = img + picName + substring + ",";
                f.transferTo(new File(IMGPATH + picName + substring));
            }

            if (img != "") {
                img = img.substring(0, img.length() - 1);
                publishGoods.setImg(img);

            }
        }
        publishGoods.setBeginDate(new Date());

        System.out.println(publishGoods);
        publishGoodsMapper.insertSelective(publishGoods);
        model.addAttribute("data",new TotalData("发布成功"));

        return "success";

    }


    @RequestMapping("listUserPublish")
    public String listUserPublish(HttpServletRequest request){

        UserInfo userInfo = SessionUtils.getUserInfo(request);


        List<PublishGoods> publishGoods = publishGoodsService.listUserPublish(userInfo.getId());

        request.setAttribute("publishGoods",publishGoods);

        return "person/personPublish";
    }

    @RequestMapping("showbuyer")
    public String showBuyer(){


        return null;

    }

    /**
     * 下架商品
     * @return
     */
    @ResponseBody
    @RequestMapping("upisdeal")
    public String upisdeal(HttpServletRequest request,Long publishGoodsId){
        UserInfo userInfo = SessionUtils.getUserInfo(request);
        PublishGoods publishGoods = publishGoodsMapper.selectByPrimaryKey(publishGoodsId);

        if (publishGoods.getUserId()==userInfo.getId()){
            publishGoods.setIsdeal(1);
            publishGoodsMapper.updateByPrimaryKey(publishGoods);
            return "SUCCESS";
        }


        return "FAIL";
    }



}
