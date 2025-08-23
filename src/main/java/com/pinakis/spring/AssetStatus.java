package com.pinakis.spring;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;

/**
 * Representation of business domain object at presentation layer.
 */
public record AssetStatus(
        Long id,
        State status,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
        Instant lastUpdated,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
        Instant lastPublished
) {}