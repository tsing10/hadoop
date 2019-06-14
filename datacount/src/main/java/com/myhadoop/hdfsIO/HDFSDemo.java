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
			IOUtils.copyBytes（）方法:
			IOUtils.copyBytes(in, out, 4096, false)
			-- 4096表示用来拷贝的buffer大小（buffer是缓冲区）--缓冲区大小
			-- true - 是否关闭数据流，如果是false，就在finally里关掉
		 */
		System.out.println("下载完成");
	}
	@Test
	 public void upload() throws Exception {
		init();
		OutputStream os = fs.create(new Path("/test1"));
		InputStream is = new FileInputStream("E://test");
		IOUtils.copyBytes(is, os, 4096, true);
		System.out.println("上传完成");
		
	}
	@Test
	public void mkdir() throws Exception {
		init();
		boolean flag = fs.mkdirs(new Path("/tsing1"));
		System.out.println("创建路径成功？"+flag); 
	}
	@Test
	public void deleteFile() throws Exception {
		init();
		@SuppressWarnings("deprecation")
		//false：目录非空无法删除 true：目录非空也删除
		boolean flag = fs.delete(new Path("/tsing1"),true );
		System.out.println("删除文件？"+flag); 
	}

	

}
