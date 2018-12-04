package com.bihu.service;

import com.bihu.model.MessageCode;
import com.bihu.protobuf.MessageCodeEntity;
import com.bihu.util.ByteConvert;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

@Service
public class MessageService {
    private Socket socket;
    private SocketAddress address;

    public boolean sendMessageCode(String mobile,MessageCode messageCode) {
        try {
            socket = new Socket();
            address = new InetSocketAddress("60.205.225.116", 8080);
            socket.connect(address, 1000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.write(serializeContents(messageCode,mobile));
            byte[] a = serializeContents(messageCode,mobile);
            for (byte aa: a)
                System.out.println(aa);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
        return false;
    }

    public static void main(String[] args) {

    }


    public byte[] serializeContents(MessageCode messageCode, String mobile) throws IOException {
        byte[] messageHead = serializeHeader(messageCode);
        byte[] messageBody = null;
        MessageCodeEntity.contents.Builder contentsBuilder = MessageCodeEntity.contents.newBuilder();
        contentsBuilder.setMobile(mobile);
        MessageCodeEntity.contents contents = contentsBuilder.build();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        contents.writeTo(output);
        messageBody = output.toByteArray();
        return ArrayUtils.addAll(messageHead, messageBody);
    }

    public byte[] serializeHeader(MessageCode messageCode) throws IOException {
        byte[] messageHead = new byte[20];
        ByteConvert.shortToBytes(messageCode.getTag(),messageHead,0);
        messageHead[2]=messageCode.getVersion();
        messageHead[3]=messageCode.getType();
        ByteConvert.shortToBytes(messageCode.getLen(),messageHead,4);
        ByteConvert.shortToBytes(messageCode.getMsg_id(),messageHead,6);
        ByteConvert.longToBytes(messageCode.getMsg_sn(),messageHead,8);
        ByteConvert.intToBytes(messageCode.getReserve(),messageHead,16);
        return messageHead;
    }
}

