package org.apache.hadoop.yarn.server.timelineservice.storage;

import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.service.AbstractService;
import org.apache.hadoop.yarn.api.records.timelineservice.TimelineDomain;
import org.apache.hadoop.yarn.api.records.timelineservice.TimelineEntities;
import org.apache.hadoop.yarn.api.records.timelineservice.TimelineEntity;
import org.apache.hadoop.yarn.api.records.timelineservice.TimelineWriteResponse;
import org.apache.hadoop.yarn.server.timelineservice.collector.TimelineCollectorContext;
import org.apache.hadoop.yarn.util.timeline.TimelineUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LogTimelineWriterImpl extends AbstractService
    implements TimelineWriter{
  private static Logger LOG =
      LoggerFactory.getLogger(LogTimelineWriterImpl.class.getName());

  public LogTimelineWriterImpl(){
    super(LogTimelineWriterImpl.class.getName());
  }

  @Override
  public TimelineWriteResponse write(TimelineCollectorContext context,
      TimelineEntities data, UserGroupInformation callerUgi)
      throws IOException {
    LOG.info(TimelineUtils.dumpTimelineRecordtoJSON(data));
    return null;
  }

  @Override
  public TimelineWriteResponse write(TimelineCollectorContext context,
      TimelineDomain domain) throws IOException {
    return null;
  }

  @Override public TimelineWriteResponse aggregate(TimelineEntity data,
      TimelineAggregationTrack track) throws IOException {
    return null;
  }

  @Override public void flush() throws IOException {

  }
}
