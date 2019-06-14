package com.myhadoop.dc;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class DataBean implements Writable{
	//手机号
	private String telNo;
	//上行流量
	private long upPayLoad;
	//下行流量
	private long downPayLoad;
	//总流量
	private long totalPayLoad;
	
	//序列化
	//注意：序列化和反序列化一定要注意类型和顺序 比如我们序列化的时候先序列化字符串telNo，
	//反序列化的时候就应该先反序列化telNo
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(telNo);
		out.writeLong(upPayLoad);
		out.writeLong(downPayLoad);
		out.writeLong(totalPayLoad);
	}
	
	//反序列化
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.telNo = in.readUTF();
		this.upPayLoad = in.readLong();
		this.downPayLoad = in.readLong();
		this.totalPayLoad = in.readLong();
	}
	
	//无参数构造函数:当编码了有参数的构造方法，就应该编码无参构造方法
	public DataBean() {	}
	//有参数构造函数
	public DataBean(String telNo,long upPayLoad,long downPayLoad) {
		super();
		this.telNo = telNo;
		this.upPayLoad = upPayLoad;
		this.downPayLoad = downPayLoad;
	}
	public DataBean(String telNo,long upPayLoad,long downPayLoad,long totalPayLoad) {
		super();
		this.telNo = telNo;
		this.upPayLoad = upPayLoad;
		this.downPayLoad = downPayLoad;
		this.totalPayLoad = totalPayLoad;
	}
	
	@Override
	public String toString() {
		return this.upPayLoad+"\t"+this.downPayLoad+"\t"+this.totalPayLoad;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public long getUpPayLoad() {
		return upPayLoad;
	}

	public void setUpPayLoad(long upPayLoad) {
		this.upPayLoad = upPayLoad;
	}

	public long getDownPayLoad() {
		return downPayLoad;
	}

	public void setDownPayLoad(long downPayLoad) {
		this.downPayLoad = downPayLoad;
	}

	public long getTotalPayLoad() {
		return totalPayLoad;
	}

	public void setTotalPayLoad(long totalPayLoad) {
		this.totalPayLoad = totalPayLoad;
	}
	
	
	

}
