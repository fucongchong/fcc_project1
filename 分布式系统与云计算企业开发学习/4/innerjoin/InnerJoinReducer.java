package com.fucongchong.innerjoin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.codehaus.jackson.map.util.BeanUtil;

import java.io.IOException;
import java.util.ArrayList;

public class InnerJoinReducer extends Reducer<Text,Table,Table, NullWritable> {
    @Override
   protected void reduce(Text key,Iterable<Table> values,Context context)throws IOException,InterruptedException {

        ArrayList<Table> channelBeans = new ArrayList<>();

        Table programBean = new Table();
        for (Table bean : values)
        {
            if("channel".equals(bean.getFlag()))
            {
                Table channelBean=new Table();
                try{
                    BeanUtils.copyProperties(channelBean,bean);
                }catch (Exception e){
                    e.printStackTrace();
                }
                channelBeans.add(channelBean);
            }else{
                try{
                    BeanUtils.copyProperties(programBean,bean);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        for (Table bean:channelBeans){
            bean.setProgramName(programBean.getProgramName());
            context.write(bean,NullWritable.get());
        }
    }
}
