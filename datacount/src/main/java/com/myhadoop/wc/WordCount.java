package com.myhadoop.wc;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCount {
             public static void main(String[] args) throws Exception {
                   //�����Ѿ��Զ������Mapper��RedUC����������Ҫ���ľ��ǰ�MapReduce��ҵ�ύ��ȥ
                   //�������ǰ�MapReduce��ҵ�����Job������
                   Job job = Job.getInstance(new Configuration());
  
                   //ע�⣺һ��Ҫ��main�������ڵ������ý�����
                   job.setJarByClass(WordCount.class);
   
                   //��������������һ��Job��Mapper�������
                   job.setMapperClass(WCMapper.class);//����Mapper��
                   job.setMapOutputKeyClass(Text.class);//����K2������
                   job.setMapOutputValueClass(LongWritable.class);//����V2������
                   //���������ǵø��߳�������Ӧ��ȥ�����ȡ�ļ�����Ҫע�����Path��ָ��Hadoop��HDFSϵͳ�ϵ�·��
                   FileInputFormat.setInputPaths(job, new Path(args[0]));//�������ǲ��ñ�������ʽ��������ַ
  
                   //����������������һ��Job��Reducer�������
                   job.setReducerClass(WCReduce.class);//����Reducer��
                   job.setOutputKeyClass(Text.class);//����K3������
                   job.setOutputValueClass(LongWritable.class);//����V3������
                   //���������ǵø��߳���Ӧ�ðѽ����Ϣд��ʲôλ�á�ע�⣺�����Path��Ȼ��ָ�ļ���Hadoop��HDFSϵͳ
                   //�ϵ�·����
                  FileOutputFormat.setOutputPath(job, new Path(args[1]));//������Ȼ���ñ�������ʽ�����������ַ��
  
                  job.waitForCompletion(true);//����ҵ�ύ���ҵȴ�ִ����ɣ�����Ϊtrue�Ļ������ӡ���Ⱥ����顣
            }
}