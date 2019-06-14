package com.myhadoop.dc;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DCReducer extends Reducer<Text, DataBean, Text, DataBean>{

	@Override
	protected void reduce(Text key, Iterable<DataBean> v2s, Reducer<Text, DataBean, Text, DataBean>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		long up_sum = 0;
		long down_sum = 0;
		for (DataBean dataBean : v2s) {
			up_sum += dataBean.getUpPayLoad();
			down_sum += dataBean.getDownPayLoad();
		}
		DataBean bean = new DataBean(key.toString(), up_sum, down_sum);
		context.write(key, bean);
	}
	

}
