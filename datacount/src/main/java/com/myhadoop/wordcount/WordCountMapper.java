package com.myhadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * ����һ��Mapper�࣬����̳���Hadoop��Mapper�࣬Mapper����4�����ͣ��ֱ����
 * KEYIN(K1)��VALUEIN(V1)��KEYOUT(K2)��VALEOUT(V2)������<K1,V1>�������磺
 * <0, "hello tom">��<K2,V2>�������磺<"hello", 1>��Mapper����4������һ��Ҫʵ��
 * ���л�������������ٴ��䡣Hadoop���õ����л���jdk���õ����л��ǲ�һ���ģ���Ϊ
 * jdk�����л����Ʒǳ�����(��Ҫ������֮��Ĺ�ϵ��)�����Hadoopʵ�����Լ���һ����
 * �л����ƣ�������ֵ�͵����ݿ�����LongWritable�����л����ַ����͵����ݿ�����Text
 * �����л������Ƿ���K1����ֵ���ͣ�����������л�������LongWritable��V1���ַ�����
 * ���������л�������Text��K2���ַ������ͣ�����������л�������Text��V2����ֵ����
 * ����������л�������LongWritable��
 *
 * @author
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
//			super.map(key, value, context);
			//��������V1
			String line = value.toString();
			//�з�����
			String [] words = line.split(" ");
			//ѭ�����words
			for (String word : words) {
				// word ��String���͵� û�����л� ��д��ȥ֮ǰ�����л�
				// 1 ��int���� û�����л� ��д��ȥ֮ǰ�����л�
				context.write(new Text(word), new LongWritable(1));
			}
		}

}
