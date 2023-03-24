package com.fucongchong.exp66;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.util.*;

public class topNReducer extends Reducer<IntWritable, Text,Text, NullWritable> {

    private  TreeMap<Integer,Text> treeMap=new TreeMap<Integer, Text>();

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Set<Integer> k=treeMap.keySet();
        Iterator<Integer> it =k.iterator();

        for(Text value:values){

            treeMap.put(key.get(),value);
            if(treeMap.size()>5){
                treeMap.remove(treeMap.firstKey());
            }
        }
        for(Integer i:treeMap.keySet()){
            context.write(treeMap.get(i),NullWritable.get());
        }
    }
}
