package com.cduestc.keep.mapper;

import com.cduestc.keep.model.KeepLesson;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface KeepLessonExMapper {
    List<KeepLesson> getHotLesson();

    void updateHot(@Param("id") Long id,@Param("i") int i);
}
