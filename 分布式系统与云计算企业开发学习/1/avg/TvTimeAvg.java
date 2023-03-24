package com.fucongchong.avg;

import com.sugon.xdata.examples.MyMapper;
import com.sugon.xdata.examples.MyReducer;
import com.sugon.xdata.examples.WordCount;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class TvTimeAvg {
    public static void main(String[] args) throws Exception {

//        args=new String[]{"D:\\study\\HDFS\\data.txt","D:\\study\\HDFS\\output"};

        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf,"avg compute");
        job.setJarByClass(TvTimeAvg.class);

        job.setMapperClass(TvTimeAvgMapper.class);
        job.setReducerClass(TvTimeAvgReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TvTime.class);

        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        System.exit(job.waitForCompletion(true)?0:1);

    }
}
