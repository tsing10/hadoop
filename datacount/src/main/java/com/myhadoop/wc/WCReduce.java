package com.myhadoop.wc;
import java.io.IOException;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WCReduce extends Reducer<Text, LongWritable, Text, LongWritable>{


            @Override
            protected void reduce(Text key, Iterable<LongWritable> v2s,
                              Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
                    //����һ��counter����ͳ��ĳ�����ʳ��ֵĴ����Ƕ���  
                    long counter=0;
                    //��ʵv2s���д洢�Ķ���һ���������л����˵�1
                    for(LongWritable i : v2s){
                          counter+=i.get();//��������Ϥ��counter++��һ����˼
                    }
                   //���<K3��V3>������<"hello", 5>
                   context.write(key, new LongWritable(counter));
            }
  
}