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

		//�Զ������mapper reducer�� Ҫ��MapRducer��ҵ�ύ��ȥ
		//�������ǰ�MapReduce��ҵ����Ϊjob����
		Job job = Job.getInstance(new Configuration());
		
		//ע�⣬һ��Ҫ��main�������ڵ������ý���
		job.setJarByClass(WordCount.class);
		
		//������ ����Mapper�������
		job.setMapperClass(WordCountMapper.class);		//����Mapper��
		job.setMapOutputKeyClass(Text.class);			//����K2����
		job.setMapOutputValueClass(LongWritable.class);	//����V2����
		//������ ���Ǹ��߳���ȥ�����ȡ�ļ� ��Ҫע�����pathPath��ָ��Hadoop��HDFSϵͳ�ϵ�·��
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		
		//����Reducer�������
		job.setReducerClass(WordCountReducer.class);	//����Reducer��
		job.setOutputKeyClass(Text.class);				//����K3����
		job.setOutputValueClass(LongWritable.class);	//����V3����
		
		//������ ���Ǹ��߳���ѽ��д��ʲôλ�� ע�� �����path��Ȼָ����Hadoop��HDFSϵͳ�ϵ�·��
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		//������ �ύ��ҵ �ȴ���ҵִ����� ����Ϊtrue ���ӡ���Ⱥ�����
		job.waitForCompletion(true);
	
	}

}
