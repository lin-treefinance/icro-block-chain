package me.icro.ibchain;

import java.io.Serializable;
import java.util.Date;

/**
 * 区块
 * Created by Lin on 2018/6/11.
 */
public class Block implements Serializable {
    private static final long serialVersionUID = -2927217422117176773L;
    public String hash;
    public String previousHash;
    private String data; // our data will be a simple message.
    private long timeStamp; // as number of milliseconds since 1/1/1970.
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();

        this.hash = calculateHash();
    }

    // Calculate new hash based on blocks contents
    public String calculateHash() {
        return StringUtil.sha256(previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data);
    }

    public void mineBlock(int difficulty) {
        String target = StringUtil.getDifficultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block MINED!!! : " + hash);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}
