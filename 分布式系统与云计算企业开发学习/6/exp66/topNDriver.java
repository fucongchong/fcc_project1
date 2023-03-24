package com.fucongchong.exp66;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.TreeMap;

public class topNDriver {

    public static class MyIntWritable extends IntWritable {

        public MyIntWritable() {
        }

        public MyIntWritable(int value) {
            super(value);
        }

        @Override
        public int compareTo(IntWritable o) {
            return -super.compareTo(o);  //重写IntWritable排序方法，默认是升序 ，
        }
    }




    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();



        Job job = Job.getInstance(conf);

        job.setMapperClass(topNMapper.class);

        job.setReducerClass(topNReducer.class);

        job.setMapOutputKeyClass(MyIntWritable.class);

        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);

        job.setOutputValueClass(MyIntWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));


        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
