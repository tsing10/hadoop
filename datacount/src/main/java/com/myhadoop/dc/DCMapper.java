package com.myhadoop.dc;

import java.io.IOException;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public  class DCMapper extends Mapper<LongWritable, Text, Text, DataBean>{

      Text text = null;

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DataBean>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

        String line = value.toString();
  
        String[] feilds = line.split("\t");
        String telNo = feilds[1];
        long up = Long.parseLong(feilds[8]);
        long down = Long.parseLong(feilds[9]);   
        DataBean bean = new DataBean(telNo,up,down);
        
        context.write(new Text(telNo), bean);
	}
      
      
    
}