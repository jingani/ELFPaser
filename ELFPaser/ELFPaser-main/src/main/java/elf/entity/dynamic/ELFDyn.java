package elf.entity.dynamic;

import elf.entity.dynamic.enums.DTag;

/**
 * @author qxm
 * @create 2022-07-09 8:59
 **/
public class ELFDyn {
    private DUn d_un;
    private DTag d_tag;


    public ELFDyn() {
    }

    public ELFDyn(DUn d_un, DTag d_tag) {
        this.d_un = d_un;
        this.d_tag = d_tag;
    }

    public DUn getD_un() {
        return d_un;
    }

    public void setD_un(DUn d_un) {
        this.d_un = d_un;
    }

    public DTag getD_tag() {
        return d_tag;
    }

    public void setD_tag(DTag d_tag) {
        this.d_tag = d_tag;
    }

    @Override
    public String toString() {
        return "ELFDyn{" +
                "d_un=" + d_un +
                ", d_tag=" + d_tag +
                '}';
    }
}
