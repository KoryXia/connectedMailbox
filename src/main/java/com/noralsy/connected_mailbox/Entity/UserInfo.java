package com.noralsy.connected_mailbox.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserInfo {
    @TableId
    private String userID;
    private String name;
    private String address;
    private String room;
    private String phone;
    private String city;
    private String country;
    private String postalCode;
}
