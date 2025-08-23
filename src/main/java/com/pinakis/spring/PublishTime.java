package com.pinakis.spring;

import org.springframework.stereotype.Component;
import java.time.Instant;

/**
 * DTO class for Publish time.
 */
public record PublishTime(Instant publishedOn) {}
