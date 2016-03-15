package com.sun.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class FileUploadAction {

	private File image;
	private String imageFileName;
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String excute() throws IOException{
		@SuppressWarnings("deprecation")
		String path = ServletActionContext.getRequest().getRealPath("/images");
		System.out.println(path);
		File file = new File(path,imageFileName);
		if(!file.getParentFile().exists()){file.getParentFile().mkdirs();}
		FileUtils.copyFile(image, file);
		ActionContext.getContext().put("message", "文件上传成功！");
		return "success";
	}
}
