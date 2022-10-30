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
public class Interphone {
    @TableId
    private String interphoneID;
    private String city;
    private String address;
    private String postalCode;
    private String country;
}
