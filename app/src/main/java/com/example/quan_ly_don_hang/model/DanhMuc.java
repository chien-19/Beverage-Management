package com.example.quan_ly_don_hang.model;

public class DanhMuc {
private int mMaDM;
private String mTenDM;


public DanhMuc() {
	super();
}
public DanhMuc(String mTenDM) {
	super();
	this.mTenDM = mTenDM;
}
public DanhMuc(int mMaDM, String mTenDM) {
	super();
	this.mMaDM = mMaDM;
	this.mTenDM = mTenDM;
}
public int getmMaDM() {
	return mMaDM;
}
public void setmMaDM(int mMaDM) {
	this.mMaDM = mMaDM;
}
public String getmTenDM() {
	return mTenDM;
}
public void setmTenDM(String mTenDM) {
	this.mTenDM = mTenDM;
}



}
