package com.company;

import java.io.Serializable;

public class Lesson implements Serializable{
    static int numberLesson = 1;
    int number;
    public String lesson;
    public String audienceNumber;
    public String teacher;

    public String startTime;
    public String endTime;

    public Lesson(String startTime,String endTime,String lectureHall, String teacher, String lesson){
        this.startTime = startTime;
        this.endTime = endTime;
        this.audienceNumber = lectureHall;
        this.lesson = lesson;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return this.number + "|" + this.startTime + "|" + this.endTime + "|" +
                this.audienceNumber + "|" + this.teacher + "|" + this.lesson;
    }

}
