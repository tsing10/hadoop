package com.myhadoop.dc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class DataCount {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(DataCount.class);
		
		job.setMapperClass(DCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setOutputValueClass(DataBean.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		
		job.setReducerClass(DCReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DataBean.class);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}

}
