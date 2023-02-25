package com.fbi.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author Generator
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID号
     */
    @TableId(value = "P_ID", type = IdType.AUTO)
    private Integer pId;

    /**
     * 姓名
     */
    @TableField("P_NAME")
    private String pName;

    /**
     * 年龄
     */
    @TableField("P_AGE")
    private Integer pAge;


}
