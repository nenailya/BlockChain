package nailya;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private final List<Block> blocks;
    private final int difficulty;

    public Blockchain() {
        this.blocks = new ArrayList<>();
        this.difficulty = 4;
        Block genesisBlock = new Block(0, "0", "This is the genesis block");
        genesisBlock.mineBlock(difficulty);
        blocks.add(genesisBlock);
    }


    public Block getLatestBlock() {
        return blocks.get(blocks.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blocks.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < blocks.size(); i++) {
            Block currentBlock = blocks.get(i);
            Block previousBlock = blocks.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current hash does not match");
                return false;
            }

            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous hash does not match");
                return false;
            }
        }
        return true;
    }
}