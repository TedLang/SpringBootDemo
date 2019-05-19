package com.example.springboot.aspect.soundsystem;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: Yu
 * @Date: 2019-05-11
 * @Descripe:
 */
@Aspect
public class TrackCounter {
  private Map<Integer, Integer> tracksCounts = new HashMap<Integer, Integer>();

  @Pointcut("execution (* com.example.spring.aspect.soundsystem.CompactDisc.playTrack(..)) && args(trackNumber")
  public void trackPlayed(int tackNumber) {}

  @Before("trackPlayed(trackNumber)")
  public void countTrack(int trackNumber) {
    int currentCount = getPlayCount(trackNumber);
    tracksCounts.put(trackNumber, currentCount ++);
  }

  public int getPlayCount(int trackNumber) {
    return tracksCounts.containsKey(trackNumber) ? tracksCounts.get(trackNumber) : 0;
  }
}
