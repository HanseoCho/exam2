package kr.co.exam2.Service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceInterface {
	public void fileUpload(MultipartFile files, Map<String, Object> param ,HttpServletResponse res);
}
