package com.cswu.bean;

/**
 * 网站信息类，JavaBean
 *
 *@copyright:邓豪杰 0410190211
 */
public class Profile {
	//无参的公开 的构造方法，默认构造方法
    
    private String siteName;
    
    private String copyRight;

    //setter、getter方法
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
    
    
    
}
