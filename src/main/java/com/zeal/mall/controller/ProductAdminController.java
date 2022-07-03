package com.zeal.mall.controller;



import com.github.pagehelper.PageInfo;
import com.zeal.mall.common.ApiRestResponse;
import com.zeal.mall.common.Constant;
import com.zeal.mall.exception.ImoocMallException;
import com.zeal.mall.exception.ImoocMallExceptionEnum;
import com.zeal.mall.model.pojo.Product;
import com.zeal.mall.model.request.AddProductReq;
import com.zeal.mall.model.request.UpadateProductReq;
import com.zeal.mall.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;



/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 后台商品管理Controller
 * @date: 2022-06-12 14:38
 */
@Controller
public class ProductAdminController {
    @Autowired
    ProductService productService;

    @ApiOperation("增加商品")
    @PostMapping("/admin/product/add")
    @ResponseBody
    public ApiRestResponse addProduct(@RequestBody @Valid AddProductReq addProductReq){
        productService.add(addProductReq);
        return ApiRestResponse.success();
    }
    @ApiOperation("添加图片")
    @PostMapping("/admin/upload/file")
    @ResponseBody
    public ApiRestResponse upload(HttpServletRequest httpServletRequest,@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();//获取文件原始名字
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件名的后缀名
        //生成文件名称UUID
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + suffixName;
        //创建文件
        File fileDirectory = new File(Constant.FILE_UPLOAD_DIR);//file文件夹的位置
        File destFile = new File(Constant.FILE_UPLOAD_DIR + newFileName);
        if (!fileDirectory.exists()){
            if (!fileDirectory.mkdir()) {
                throw new ImoocMallException(ImoocMallExceptionEnum.MKDIR_FAILED);
            }
        }
        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return ApiRestResponse.success(getHost(new URI(httpServletRequest.getRequestURI()+""))+"/images/"+newFileName);
        } catch (URISyntaxException e) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.UPLOAD_FAILED);
        }
    }

    /**
     * 获取IP和端口号
     * @param uri
     * @return
     */
    private URI getHost(URI uri)  {
        URI effectiveURI;
        try {
            effectiveURI=new URI(uri.getScheme(),uri.getUserInfo(),uri.getHost(),uri.getPort(),null,null,null);
        } catch (URISyntaxException e) {
            effectiveURI=null;
        }
        return effectiveURI;

    }
    @ApiOperation("更新商品")
    @PostMapping("/admin/product/update")
    @ResponseBody
    public ApiRestResponse updateProduct(@RequestBody @Valid UpadateProductReq upadateProductReq){
        Product product=new Product();
        BeanUtils.copyProperties(upadateProductReq,product);
        productService.update(product);
        return ApiRestResponse.success();
    }
    @ApiOperation("删除商品")
    @PostMapping("/admin/product/delete")
    @ResponseBody
    public ApiRestResponse deleteProduct(@RequestParam Integer id){
        productService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("批量上下架")
    @PostMapping("/admin/product/batchUpdateSellStatus")
    @ResponseBody
    public ApiRestResponse batchUpdateSellStatus(@RequestParam Integer[] ids,@RequestParam Integer sellStatus){
        productService.batchUpdateSellStatus(ids,sellStatus);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台商品列表")
    @GetMapping("/admin/product/list")
    @ResponseBody
    public ApiRestResponse list(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = productService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


}
