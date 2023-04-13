package elf;

import elf.entity.ELFFile;
import elf.entity.ELFParams;
import elf.entity.ELFStringTable;
import elf.entity.Offset;
import elf.entity.dynamic.DUn;
import elf.entity.dynamic.ELFDyn;
import elf.entity.dynamic.enums.DTag;
import elf.entity.section.ELFSectionHeader;
import elf.entity.section.ELFSectionHeaders;
import elf.entity.symboltable.SymbolTable;
import elf.function.*;
import elf.entity.header.ELFHeader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author TestLove
 * @version 1.0
 * @date 2022/7/4 10:02
 * @Description:
 */
public class ELFApplication {
    public static void main(String[] args)  {
        ELFParams elfParams = null;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入相关命令：");
             elfParams = new ELFParams(input.nextLine());
            byte[] bytes = ELFUtils.fileToBytes(elfParams.getFilePath());
            ELFFile elfFile = new ELFFile();
            ELFInfoContainer.setElfFile(elfFile);
            ELFInfoContainer.setFileBytes(bytes);
            elfFile.setElfHeader(new ParseELFHeader().getELFHeader(bytes, new Offset(0)));
            elfFile.setElfSectionStringTable(new ELFStringTable(ELFInfoContainer.getOffsetOfSectionHeader(), ELFInfoContainer.getELFSectionStringTableOffset() * ELFInfoContainer.getSizeOfSectionHeader(), 0));
            elfFile.setElfSectionHeaders(new ELFSectionHeaders());

            ELFHeader elfHeader = elfFile.getElfHeader();
            switch (elfParams.getOptional()) {
                case "-h":
                    System.out.println(elfFile.getElfHeader().toString());
                    break;
                case "-p":
                    Integer numberOfProgramHeaders = elfHeader.getNumberOfProgramHeaders();
                    Integer sizeOfProgramHeaders = elfHeader.getSizeOfProgramHeaders();
                    Integer startOfProgramHeaders = elfHeader.getStartOfProgramHeaders();
                    for (int i = 0; i < numberOfProgramHeaders; i++) {
                        System.out.println(new ParseProgramHeader().getProgramHeader(bytes,
                                new Offset(startOfProgramHeaders + i * sizeOfProgramHeaders)));
                    }
                    break;
                case "-s":
                    new ParseELFSectionHeader().getELFSectionHeaders(bytes);
                    ELFInfoContainer.getElfFile().getElfSectionHeaders().getHeaders().forEach(System.out::println);
                    break;
                case "-sy":
                    new ParseELFSectionHeader().getELFSectionHeaders(bytes);
                    elfFile.setSymbolTable(new SymbolTable());
                    new ParseELFSymbolTable().getSymbolTable(bytes);
                    ELFInfoContainer.getElfFile().getSymbolTable().getSymbols().forEach(System.out::println);
                    break;
                case "-d":
                    ELFSectionHeader dynamicSH = new ParseELFSectionHeader().getELFSectionHeaders(bytes).getHeaderByName(".dynamic");
                    Integer offset = dynamicSH.getOffset();
                    Integer size = dynamicSH.getSize();
                    Integer entsize = dynamicSH.getEntsize();
                    ELFDyn elfDyn = new ELFDyn();
                    for (int i = 0; i < 24; i++) {
                        elfDyn.setD_tag(DTag.getEIClassType(ELFUtils.bytesToInt(bytes, offset + i * 12)));
                        DUn dUn = new DUn();
                        dUn.setD_val(ELFUtils.bytesToInt(bytes, offset + i * 12 + 4));
                        dUn.setD_ptr(ELFUtils.bytesToInt(bytes, offset + i * 12 + 8));
                        elfDyn.setD_un(dUn);
                        System.out.println(elfDyn);
                    }
                    break;
                default:
                    System.out.println("没有相关命令选项，请输入正确的命令!");

            }
        } catch (Exception e) {
            System.out.println("要解析的文件["+elfParams.getFilePath()+"]不存在，请输入正确的文件名!");
        }
    }
}
