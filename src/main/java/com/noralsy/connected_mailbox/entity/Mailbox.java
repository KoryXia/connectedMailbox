package com.noralsy.connected_mailbox.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Mailbox {
    @TableId
    private String mailboxId;
    private String interphoneId;
    private String nickname;
    private String userId;
    private Boolean gotNew;
    private String screenInfo;
}
