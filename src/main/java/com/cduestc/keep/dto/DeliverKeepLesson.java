package com.cduestc.keep.dto;

import com.cduestc.keep.provider.Sports;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeliverKeepLesson implements Serializable {
    private Long id;
    private String imageUrl;
    private String lessonName;
    private Integer hot;
    private List<Sports> sports;
    private String type;
}
