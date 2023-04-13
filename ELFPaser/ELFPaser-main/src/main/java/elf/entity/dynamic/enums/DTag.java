package elf.entity.dynamic.enums;

import elf.entity.header.enums.EIClassType;

/**
 * @author qxm
 * @create 2022-07-09 9:45
 **/
public enum DTag {
    DT_NULL("DT_NULL"),
    DT_NEEDED("DT_NEEDED"),
    DT_PLTRELSZ("DT_PLTRELSZ"),
    DT_PLTGOT("DT_PLTGOT"),
    DT_HASH("DT_HASH"),
    DT_STRTAB("DT_STRTAB"),
    DT_SYMTAB("DT_SYMTAB"),
    DT_RELA("DT_RELA"),
    DT_RELASZ("DT_RELASZ"),
    DT_RELAENT("DT_RELAENT"),
    DT_STRSZ("DT_STRSZ"),
    DT_SYMENT("DT_SYMENT"),
    DT_INIT("DT_INIT"),
    DT_FINI("DT_FINI"),
    DT_SONAME("DT_SONAME"),
    DT_RPATH("DT_RPATH"),
    DT_SYMBOLIC("DT_SYMBOLIC"),
    DT_REL("DT_REL"),
    DT_RELSZ("DT_RELSZ"),
    DT_RELENT("DT_RELENT"),
    DT_PLTREL("DT_PLTREL"),
    DT_DEBUG("DT_DEBUG"),
    DT_TEXTREL("DT_TEXTREL"),
    DT_JMPREL("DT_JMPREL"),
    DT_LOPROC("DT_LOPROC"),
    DT_HIPROC("DT_HIPROC");

    String description;

    DTag(String description) {
        this.description = description;
    }

    public static DTag getEIClassType(int index) {
        DTag result = null;
        switch (index) {
            case 0:
                result = DTag.DT_NULL;
                break;
            case 1:
                result = DTag.DT_NEEDED;
                break;
            case 2:
                result = DTag.DT_PLTRELSZ;
                break;
            case 3:
                result = DTag.DT_PLTGOT;
                break;
            case 4:
                result = DTag.DT_HASH;
                break;
            case 5:
                result = DTag.DT_STRTAB;
                break;
            case 6:
                result = DTag.DT_SYMTAB;
                break;
            case 7:
                result = DTag.DT_RELA;
                break;
            case 8:
                result = DTag.DT_RELASZ;
                break;
            case 9:
                result = DTag.DT_RELAENT;
                break;
            case 10:
                result = DTag.DT_STRSZ;
                break;
            case 11:
                result = DTag.DT_SYMENT;
                break;
            case 12:
                result = DTag.DT_INIT;
                break;
            case 13:
                result = DTag.DT_FINI;
                break;
            case 14:
                result = DTag.DT_SONAME;
                break;
            case 15:
                result = DTag.DT_RPATH;
                break;
            case 16:
                result = DTag.DT_SYMBOLIC;
                break;
            case 17:
                result = DTag.DT_REL;
                break;
            case 18:
                result = DTag.DT_RELSZ;
                break;
            case 19:
                result = DTag.DT_RELENT;
                break;
            case 20:
                result = DTag.DT_PLTREL;
                break;
            case 21:
                result = DTag.DT_DEBUG;
                break;
            case 22:
                result = DTag.DT_TEXTREL;
                break;
            case 23:
                result = DTag.DT_JMPREL;
                break;
            case 0x70000000:
                result = DTag.DT_LOPROC;
                break;
            case 0x7fffffff:
                result = DTag.DT_HIPROC;
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return description;
    }
}
