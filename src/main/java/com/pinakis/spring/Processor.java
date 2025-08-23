package com.pinakis.spring;

import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.List;

@Component
public class Processor {

    public List<PublishTime> setUpPublishedTime() {
        return List.of(
            new PublishTime(Instant.parse("2017-02-03T11:25:30.00Z")),
            new PublishTime(Instant.parse("2018-07-28T20:38:00.00Z"))
        );
    }
}
