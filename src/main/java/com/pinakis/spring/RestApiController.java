package com.pinakis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
public class RestApiController {

	@Autowired
	private AssetStatus assetStatus;

	@Autowired
	private Processor processor;

	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
	
	@RequestMapping("/content/v1/stories/{assetId}")
	public AssetStatus getState(@PathVariable Long assetId) {
		assetStatus.setId(assetId);
		assetStatus.setLastPublished(Instant.now());
		assetStatus.setLastUpdated(Instant.now());

		if (assetId == 1) {
			assetStatus.setStatus(State.DRAFT);
		}
		else if (assetId == 2){
			assetStatus.setStatus(State.PUBLISHED);
		}

		return assetStatus;
	}

}
