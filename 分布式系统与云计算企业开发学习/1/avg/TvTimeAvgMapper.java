package com.fucongchong.avg;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TvTimeAvgMapper extends Mapper<LongWritable, Text,Text,TvTime> {
    @Override
    public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException{
        String[] data=value.toString().split(" ");

        Text k=new Text(data[1]);

        TvTime v=new TvTime();
        v.setDay(Integer.parseInt(data[2]));
        v.setNight(Integer.parseInt(data[3]));

        context.write(k,v);
    }
}
