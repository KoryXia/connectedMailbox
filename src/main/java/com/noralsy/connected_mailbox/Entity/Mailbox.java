package com.noralsy.connected_mailbox.Entity;

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
    private String mailboxID;
    private String interphoneID;
    private String nickname;
    private String userID;
    private Boolean gotNew;
    private String screenInfo;
}
