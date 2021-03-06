﻿using System;

namespace MeetingManager.Models
{
    class HttpEventData
    {
        public DateTimeOffset TimeStamp { get; set; }
        public string Method { get; set; }
        public string Uri { get; set; }
        public string RequestBody { get; set; }
        public string RequestHeaders { get; set; }
        public string StatusCode { get; set; }
        public string ResponseBody { get; set; }
        public string ResponseHeaders { get; set; }
    }
}
