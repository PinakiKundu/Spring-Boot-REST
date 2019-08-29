package com.pinakis.spring;

 import com.fasterxml.jackson.annotation.JsonFormat;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;
 import lombok.experimental.Accessors;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.stereotype.Component;

 import java.time.Instant;

/**
 * representation of business domain object at presentation layer.
 * this decouples the domain from presentation.
 * <p>
 * Following Google JSON Style Guide
 * <p>
 * https://google.github.io/styleguide/jsoncstyleguide.xml
 * <p>
 * Using @JsonInclude(JsonInclude.Include.NON_EMPTY) as per Google JSON Style Guide rule: Consider removing empty or
 * null values.
 */

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
@Component
public class AssetStatus {
    private Long id;
    private State status;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
    private Instant lastUpdated;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
    private Instant lastPublished;
}
