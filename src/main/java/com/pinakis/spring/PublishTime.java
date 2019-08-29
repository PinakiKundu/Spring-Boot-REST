package com.pinakis.spring;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * DTO class for Publish time.
 */

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
@Component
public class PublishTime {
    private Instant publishedOn;
}