package com.noralsy.connected_mailbox.Entity;

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
    @TableId
    private int letterID;
    private String mailboxID;
    private Boolean gotNew;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private Timestamp dateTime;
}
