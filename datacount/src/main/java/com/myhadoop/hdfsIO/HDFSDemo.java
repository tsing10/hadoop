package com.myhadoop.hdfsIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HDFSDemo {

	static FileSystem fs = null;
	@Before
	public void init () throws Exception{
		//fs = FileSystem.get("hdfs://namenode:9000", new Configuration(), "hadoop");
		fs = FileSystem.get(new URI("hdfs://namenode:9000"), new Configuration(), "hadoop");
	}
	@Test
	public   void download() throws Exception  {
		init();
		InputStream is = fs.open(new Path("/user/jdk-8u111-linux-x64.tar.gz"));
		OutputStream os = new FileOutputStream("E://jdk1.7");
		IOUtils.copyBytes(is, os, 4096,true);	
		/**
			IOUtils.copyBytes��������:
			IOUtils.copyBytes(in, out, 4096, false)
			-- 4096��ʾ����������buffer��С��buffer�ǻ�������--��������С
			-- true - �Ƿ�ر��������������false������finally��ص�
		 */
		System.out.println("�������");
	}
	@Test
	 public void upload() throws Exception {
		init();
		OutputStream os = fs.create(new Path("/test1"));
		InputStream is = new FileInputStream("E://test");
		IOUtils.copyBytes(is, os, 4096, true);
		System.out.println("�ϴ����");
		
	}
	@Test
	public void mkdir() throws Exception {
		init();
		boolean flag = fs.mkdirs(new Path("/tsing1"));
		System.out.println("����·���ɹ���"+flag); 
	}
	@Test
	public void deleteFile() throws Exception {
		init();
		@SuppressWarnings("deprecation")
		//false��Ŀ¼�ǿ��޷�ɾ�� true��Ŀ¼�ǿ�Ҳɾ��
		boolean flag = fs.delete(new Path("/tsing1"),true );
		System.out.println("ɾ���ļ���"+flag); 
	}

	

}
