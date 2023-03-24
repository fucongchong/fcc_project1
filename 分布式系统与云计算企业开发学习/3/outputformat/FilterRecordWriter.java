package com.fucongchong.outputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class FilterRecordWriter extends RecordWriter<Text, NullWritable> {
    FSDataOutputStream memberOFSichuan=null;
    FSDataOutputStream memberOfHenan=null;

    public FilterRecordWriter(TaskAttemptContext job) {
        FileSystem fs;
        try {
            fs=FileSystem.get(job.getConfiguration());

            Path pathofSiChuan=new Path("/Users/chenluo/Documents/大三下/分布式系统/分布式及云计算概论/实验/6.3/Sichuan");
            Path pahtofHenan=new Path("/Users/chenluo/Documents/大三下/分布式系统/分布式及云计算概论/实验/6.3/Henan");

            memberOfHenan=fs.create(pahtofHenan);
            memberOFSichuan=fs.create(pathofSiChuan);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void write(Text key, NullWritable nullWritable) throws IOException {
        if(key.toString().contains("四川")){

            memberOFSichuan.write(key.toString().getBytes());
            memberOFSichuan.write("\r\n".getBytes());

        }else {

            memberOfHenan.write(key.toString().getBytes());
            memberOfHenan.write("\r\n".getBytes());
        }
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext){
        IOUtils.closeStream(memberOfHenan);
        IOUtils.closeStream(memberOFSichuan);
    }
}
