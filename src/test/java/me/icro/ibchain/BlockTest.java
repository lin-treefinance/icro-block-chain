package me.icro.ibchain;

import org.junit.Test;

/**
 * 区块测试
 * Created by Lin on 2018/6/11.
 */
public class BlockTest {

    @Test
    public void testCreateBlock() throws Exception {

        Block genesisBlock = new Block("Hi im the first block", "0");
        System.out.println("Hash for block 1: " + genesisBlock.hash);

        Block secondBlock = new Block("Hi im the second block", genesisBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        Block thirdBlock = new Block("Hi im the third block", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);

    }
}