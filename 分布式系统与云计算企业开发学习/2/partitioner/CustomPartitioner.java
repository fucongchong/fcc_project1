package com.fucongchong.partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class CustomPartitioner extends Partitioner<Text,Text> {
    @Override
    public int getPartition(Text key, Text value, int i) {
        int patition=4;

        String phoneNum=key.toString();
        if(phoneNum.startsWith("136")){
            patition=0;
        }else if (phoneNum.startsWith("137")){
            patition=1;
        }else if (phoneNum.startsWith("138")){
            patition=2;
        }else {
            patition=3;
        }
        return  patition;
    }
}
