package com.fucongchong.partitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class PhoneGroup {
    public static void main(String[] args) throws Exception{


        Configuration conf = new Configuration();

        Job job= Job.getInstance(conf,"PhoneGroup");
        job.setJarByClass(PhoneGroup.class);
        job.setMapperClass(PhoneGroupMapper.class);
        job.setReducerClass(PhoneGroupReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setPartitionerClass(CustomPartitioner.class);
        job.setNumReduceTasks(4);

        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        System.exit(job.waitForCompletion(true)?0:1);

    }
}
