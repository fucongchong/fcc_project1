package com.fucongchong.innerjoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class InnerJoinMapper extends Mapper<LongWritable, Text,Text,Table> {
    String name;
    Table bean=new Table();
    Text k=new Text();

    @Override
    protected void setup(Context context){
        FileSplit split=(FileSplit)context.getInputSplit();
        name=split.getPath().getName();
    }

    @Override
    protected void map(LongWritable key,Text value,Context context)throws IOException,InterruptedException{
        String line=value.toString();
        if(name.startsWith("channel")){
            String[] fields=line.split("\t");
            bean.setChannelId(fields[0]);
            bean.setProgramId(fields[1]);
            bean.setAmount(Integer.parseInt(fields[2]));
            bean.setProgramName("");
            bean.setFlag("channel");

            k.set(fields[1]);

            context.write(k,bean);
        }else if(name.startsWith("program"))
        {
            String[] fields=line.split("\t");
            bean.setProgramId(fields[0]);
            bean.setProgramName(fields[1]);
            bean.setAmount(0);
            bean.setChannelId("");
            bean.setFlag("program");

            k.set(fields[0]);

            context.write(k,bean);
        }
    }

}
