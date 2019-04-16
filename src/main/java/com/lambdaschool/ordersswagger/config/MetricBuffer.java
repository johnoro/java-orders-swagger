package com.lambdaschool.ordersswagger.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class MetricBuffer {
  private static Counter counter;

  public MetricBuffer(MeterRegistry registry) {
    counter = registry.counter("buffer.count");
  }
}
