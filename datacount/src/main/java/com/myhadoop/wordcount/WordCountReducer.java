package com.myhadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable>{

	@Override
	protected void reduce(Text key, Iterable<LongWritable> v2s,
			Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		super.reduce(key, v2s, context);
		//����ͳ��ĳ�����ʳ��ֵĴ���
		long counter = 0;
		for (LongWritable i : v2s) {
			//��counter++ ������ͬ
			counter = i.get();
		}
		//���<K3,V3> ���� <"hello",5>
		context.write(key, new LongWritable(counter));
	}
	
}
