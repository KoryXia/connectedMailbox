package com.noralsy.connected_mailbox.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Letter {
    @TableId(type = IdType.AUTO)
    private Integer letterId;
    private String mailboxId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+1")
    private Timestamp dateTime;
}
