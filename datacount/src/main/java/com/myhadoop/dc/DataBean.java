package com.myhadoop.dc;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class DataBean implements Writable{
	//�ֻ���
	private String telNo;
	//��������
	private long upPayLoad;
	//��������
	private long downPayLoad;
	//������
	private long totalPayLoad;
	
	//���л�
	//ע�⣺���л��ͷ����л�һ��Ҫע�����ͺ�˳�� �����������л���ʱ�������л��ַ���telNo��
	//�����л���ʱ���Ӧ���ȷ����л�telNo
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(telNo);
		out.writeLong(upPayLoad);
		out.writeLong(downPayLoad);
		out.writeLong(totalPayLoad);
	}
	
	//�����л�
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.telNo = in.readUTF();
		this.upPayLoad = in.readLong();
		this.downPayLoad = in.readLong();
		this.totalPayLoad = in.readLong();
	}
	
	//�޲������캯��:���������в����Ĺ��췽������Ӧ�ñ����޲ι��췽��
	public DataBean() {	}
	//�в������캯��
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
