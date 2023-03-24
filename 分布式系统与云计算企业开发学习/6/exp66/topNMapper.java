package com.fucongchong.exp66;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.*;

public class topNMapper extends Mapper<LongWritable, Text,IntWritable, Text> {



    private TreeMap<Integer,Text> treeMap=new TreeMap<Integer, Text>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String []word =value.toString().split(" ");
        treeMap.put(Integer.parseInt(word[2]),value);
        if(treeMap.size()>5){
            treeMap.remove(treeMap.firstKey());
        }

    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {

        Set<Map.Entry<Integer,Text>> elems = treeMap.entrySet(); //将m1中所有元素收集起来组成一个集合

        Iterator<Map.Entry<Integer,Text>> elemsIt = elems.iterator();

        while( elemsIt.hasNext() ){
            Map.Entry<Integer,Text> elem = elemsIt.next(); //获取集合中的元素
            Integer key = elem.getKey();
            Text value = elem.getValue();

            try {
                context.write(new IntWritable(key),treeMap.get(key));
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }
}
