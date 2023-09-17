package cn.iocoder.yudao.server.dal.dataobject;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 物种 DO
 *
 * @author 芋道源码
 */
@TableName("col2019")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Col2019DO {

    /**
     * name code
     */
    @TableId(type = IdType.INPUT)
    private String nameCode;
    /**
     * kingdom
     */
    private String kingdom;
    /**
     * kingdom_c
     */
    private String kingdomC;
    /**
     * kingdom_c_py
     */
    private String kingdomCPy;
    /**
     * phylum
     */
    private String phylum;
    /**
     * phylum_c
     */
    private String phylumC;
    /**
     * phylum_c_py
     */
    private String phylumCPy;
    /**
     * class
     */
    private String clazz;
    /**
     * class_c
     */
    private String classC;
    /**
     * class_c_py
     */
    private String classCPy;
    /**
     * order
     */
    private String order;
    /**
     * order_c
     */
    private String orderC;
    /**
     * order_c_py
     */
    private String orderCPy;
    /**
     * family
     */
    private String family;
    /**
     * family_c
     */
    private String familyC;
    /**
     * family_c_py
     */
    private String familyCPy;
    /**
     * superfamily
     */
    private String superfamily;
    /**
     * superfamily_c
     */
    private String superfamilyC;
    /**
     * superfamily_c_py
     */
    private String superfamilyCPy;
    /**
     * family_common_name
     */
    private String familyCommonName;
    /**
     * genus
     */
    private String genus;
    /**
     * genus_c
     */
    private String genusC;
    /**
     * genus_c_py
     */
    private String genusCPy;
    /**
     * species
     */
    private String species;
    /**
     * species_c
     */
    private String speciesC;
    /**
     * species_c_py
     */
    private String speciesCPy;
    /**
     * canonical_name
     */
    private String canonicalName;
    /**
     * author
     */
    private String author;
    /**
     * scrutiny_date
     */
    private String scrutinyDate;
    /**
     * comments
     */
    private String comments;
    /**
     * 所属类群
     */
    private String taxaGroup;
    /**
     * CommonNames
     */
    private String commonNames;
    /**
     * UnacceptLaNames
     */
    private String unacceptLaNames;

}
