package com.myhadoop.wc;
import java.io.IOException;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WCReduce extends Reducer<Text, LongWritable, Text, LongWritable>{


            @Override
            protected void reduce(Text key, Iterable<LongWritable> v2s,
                              Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
                    //定义一个counter用来统计某个单词出现的次数是多少  
                    long counter=0;
                    //其实v2s当中存储的都是一个个被序列化好了的1
                    for(LongWritable i : v2s){
                          counter+=i.get();//跟我们熟悉的counter++是一个意思
                    }
                   //输出<K3、V3>，比如<"hello", 5>
                   context.write(key, new LongWritable(counter));
            }
  
}