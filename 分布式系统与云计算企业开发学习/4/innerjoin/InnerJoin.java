package com.fucongchong.innerjoin;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class InnerJoin {
    public static void main(String[] args)throws Exception {

//        args=new String[]{"D:\\study\\HDFS\\Innerjoin\\","D:\\study\\HDFS\\output\\innerjoin"};

        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf,"InnerJoin");
        job.setJarByClass(InnerJoin.class);

        job.setMapperClass(InnerJoinMapper.class);
        job.setReducerClass(InnerJoinReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Table.class);

        job.setOutputKeyClass(Table.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        System.exit(job.waitForCompletion(true)?0:1);

    }
}
