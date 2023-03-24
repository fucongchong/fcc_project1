package com.fucongchong.avg;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TvTimeAvgReducer extends Reducer<Text,TvTime,Text,TvTime>{
    @Override
    public void reduce(Text key,Iterable<TvTime> values,Context context) throws IOException,InterruptedException{
        Integer sum_day=0;
        Integer sum_night=0;

        int times=0;
        for(TvTime tvTime:values)
        {
            times++;
            sum_day+=tvTime.getDay();
            sum_night+=tvTime.getNight();
        }

        TvTime avg=new TvTime();
        avg.setDay(sum_day/times);
        avg.setNight(sum_night/times);

        context.write(key,avg);
    }

}
