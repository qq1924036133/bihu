package com.bihu.model;

import com.bihu.protobuf.MessageCodeEntity;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
@Component
public class MessageCode {
    public short tag=1;
    public byte version=1;
    public byte type=1;
    public short len=1;
    public short msg_id=1;
    public long msg_sn=1;
    public int reserve=1;

    public short getTag() {
        return tag;
    }

    public void setTag(short tag) {
        this.tag = tag;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public short getLen() {
        return len;
    }

    public void setLen(short len) {
        this.len = len;
    }

    public short getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(short msg_id) {
        this.msg_id = msg_id;
    }

    public long getMsg_sn() {
        return msg_sn;
    }

    public void setMsg_sn(long msg_sn) {
        this.msg_sn = msg_sn;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }


}
