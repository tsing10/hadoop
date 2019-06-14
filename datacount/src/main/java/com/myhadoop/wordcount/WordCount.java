package com.myhadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCount {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//自定义好了mapper reducer后 要把MapRducer作业提交上去
		//现在我们把MapReduce作业抽象为job对象
		Job job = Job.getInstance(new Configuration());
		
		//注意，一定要将main方法所在的类设置进来
		job.setJarByClass(WordCount.class);
		
		//接下来 设置Mapper相关属相
		job.setMapperClass(WordCountMapper.class);		//设置Mapper类
		job.setMapOutputKeyClass(Text.class);			//设置K2类型
		job.setMapOutputValueClass(LongWritable.class);	//设置V2类型
		//接下来 我们告诉程序去哪里读取文件 需要注意的是pathPath是指在Hadoop的HDFS系统上的路径
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		
		//设置Reducer相关属相
		job.setReducerClass(WordCountReducer.class);	//设置Reducer类
		job.setOutputKeyClass(Text.class);				//设置K3类型
		job.setOutputValueClass(LongWritable.class);	//设置V3类型
		
		//接下来 我们告诉程序把结果写到什么位置 注意 这里的path依然指的是Hadoop的HDFS系统上的路径
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		//接下来 提交作业 等待作业执行完成 参数为true 会打印进度和详情
		job.waitForCompletion(true);
	
	}

}
