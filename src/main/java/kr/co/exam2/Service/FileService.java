package kr.co.exam2.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.exam2.util.HttpUtil;

@Service
public class FileService implements FileServiceInterface {

	@Override
	public void fileUpload(MultipartFile files,Map<String, Object> param, HttpServletResponse res) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        HashMap<String, Object> fileMap = new HashMap<String, Object>();
        String filenm = files.getOriginalFilename();
            
            try {
                byte[] bytes = files.getBytes();
				String path = "D:/test/movie/" + param.get("movieNo") + "/";
//				String path = "/var/www/html/resources/" + dir + "/";
//				String path = req.getSession().getServletContext().getRealPath("/") + "resources/" + dir + "/";
//              String path = "/var/www/html/resources/test/" + param.get("movieNo") + "/";
                File dir = new File(path);
                
                if(!dir.exists()) {dir.mkdirs();}	//파일이 존재하지않으면실행 mkdir() 도중경로가 없으면 안만듬,  mkdirs() 도중경로가 없어도 만듬 
                File f = new File(path+filenm);	//경로까지담은객체를 담아서
                OutputStream out = new FileOutputStream(f);	//어디에 담겠다
                out.write(bytes);
                out.close();
                
                fileMap.put("fileNmae", filenm);
                fileMap.put("filePath", path);                
            }catch (IOException e) {
                e.printStackTrace(); //오류나낸용찍는거
            }     
        HttpUtil.makeJsonWriter(res, fileMap);;		
	}
	
}
