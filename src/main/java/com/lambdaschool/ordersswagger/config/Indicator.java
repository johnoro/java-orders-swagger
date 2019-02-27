package com.lambdaschool.ordersswagger.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import static java.lang.Math.random;

@Component
public class Indicator implements HealthIndicator {
  @Override
  public Health health() {
    int errorCode = check(); // random check
    if (errorCode != 0) {
      return Health.down()
        .withDetail("Error occurred with code", errorCode)
        .build();
    }
    return Health.up()
      .withDetail("Ooh, so custom", "isn't it?")
      .build();
  }

  public int check() {
    int rand = (int)(random() * 10) + 1;
    if (rand < 7) {
      return 0;
    }
    return rand;
  }
}
