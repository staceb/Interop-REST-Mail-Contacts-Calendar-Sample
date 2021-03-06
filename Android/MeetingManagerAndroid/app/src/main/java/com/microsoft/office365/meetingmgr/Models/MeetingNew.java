package com.microsoft.office365.meetingmgr.Models;

import com.microsoft.office365.meetingmgr.DateFmt;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Meeting (event) representation in Graph API
 */
public class MeetingNew extends Meeting {

    public DateTimeZone start = new DateTimeZone();
    public DateTimeZone end = new DateTimeZone();

    public String createdDateTime;

    @Override
    public void setStart(String time) {
        start.dateTime = time;
    }

    @Override
    public String getStart() {
        return getTimeConditional(start);
    }

    @Override
    public void setEnd(String time) {
        end.dateTime = time;
    }

    @Override
    public String getEnd() {
        return getTimeConditional(end);
    }

    private String getTimeConditional(DateTimeZone dtz) {
        if (IsAllDay) {
            return DateFmt.getApiDateTime(dtz.dateTime, "UTC");
        }
        return DateFmt.getApiDateTimeWithTZ(dtz.dateTime, dtz.timezone);
    }

    @Override
    public void setStartTimeZone(String timeZone) {
        start.timezone = timeZone;
    }

    @Override
    public String getStartTimeZone() {
        return start.timezone;
    }

    @Override
    public void setEndTimeZone(String timeZone) {
        end.timezone = timeZone;
    }

    @Override
    public String getEndTimeZone() {
        return end.timezone;
    }

    @Override
    public String formatRecurrenceStartDate(Date startDate) {
        return DateFmt.toApiDateString(startDate);
    }

    @Override
    public String getCreatedTime() {
        return createdDateTime;
    }

    @Override
    public String getCreatedTimePropertyName() {
        return "createdDateTime";
    }

    public static class DateTimeZone {
        public String dateTime;
        public String timezone = TimeZone.getDefault().getDisplayName();

        private DateTimeZone() {}
    }
}
