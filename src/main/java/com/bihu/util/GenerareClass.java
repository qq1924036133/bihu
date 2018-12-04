package com.bihu.util;

import java.io.IOException;

public class GenerareClass {

    public static void main(String[] args) {
        String protoFile = "test.proto";//
        String strCmd = "D:/Java/protobuf-3.5.0/src/protoc.exe -I=./proto --java_out=./src/main/resources ./proto/"+ protoFile;
        try {
            Runtime.getRuntime().exec(strCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序
    }

}
