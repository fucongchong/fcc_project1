package com.fucongchong.avg;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TvTime implements Writable {
     private Integer day;
     private Integer night;

     public TvTime(){
         super();
     }

     @Override
     public void write(DataOutput out) throws IOException{
         out.writeInt(day);
         out.writeInt(night);
     }

     @Override
     public void readFields(DataInput in) throws IOException{
         this.day=in.readInt();
         this.night=in.readInt();
     }

     @Override
    public String toString(){
         return day+"\t"+night;
     }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getNight() {
        return night;
    }

    public void setNight(Integer night) {
        this.night = night;
    }
}
