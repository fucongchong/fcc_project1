package com.fucongchong.exp65;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class RemoveMapper extends Mapper<LongWritable,Text,Text,NullWritable>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[]words=value.toString().split(" ");

        context.write(value,NullWritable.get());

    }
}
