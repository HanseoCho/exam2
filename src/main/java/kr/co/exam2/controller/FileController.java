package kr.co.exam2.controller;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.exam2.Service.FileServiceInterface;
import kr.co.exam2.util.HttpUtil;

@Controller
public class FileController {
	@Autowired
	FileServiceInterface fsi;
	
	@RequestMapping("file/insert")
	public void filesave(@RequestParam("file") MultipartFile files,HttpServletRequest req,HttpServletResponse res) {
		System.out.println("123");
		Map<String, Object> param = HttpUtil.getParamMap(req);		
		fsi.fileUpload(files,param, res);        
	}
}
