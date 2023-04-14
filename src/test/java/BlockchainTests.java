import nailya.Block;
import nailya.Blockchain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockchainTests {
    private Blockchain blockchain;
    private Block firstNode;
    private Block secondNode;
    private Block thirdNode;

    @BeforeEach
    public void setUp() {
        blockchain = new Blockchain();
        blockchain.addBlock(new Block(1, blockchain.getLatestBlock().getHash(),
                "This is the first block"));
        firstNode = blockchain.getLatestBlock();
        blockchain.addBlock(new Block(2, blockchain.getLatestBlock().getHash(),
                "This is the second block"));
        secondNode = blockchain.getLatestBlock();
        blockchain.addBlock(new Block(3, blockchain.getLatestBlock().getHash(),
                "This is the third block"));
        thirdNode = blockchain.getLatestBlock();
    }

    @Test
    public void testGetHash() {
        firstNode.setHash("3");
        Assertions.assertEquals("3", firstNode.getHash());
    }

    @Test
    public void testIsChainValid() {
        Assertions.assertTrue(blockchain.isChainValid());
    }

    @Test
    public void testIsValid() {
        Assertions.assertTrue(secondNode.isValid());
    }

    @Test
    public void testIndex() {
        Assertions.assertEquals(1, firstNode.getIndex());
    }

    @Test
    public void addBlock() {
        Block forthNode = new Block(4, "", "forth");
        blockchain.addBlock(forthNode);
        Assertions.assertEquals(forthNode, blockchain.getLatestBlock());
    }

    @Test
    public void getPreviousHashTest() {
        Block forthNode = new Block(4, blockchain.getLatestBlock().getHash(), "forth");
        Assertions.assertEquals( forthNode.getPreviousHash(), thirdNode.getHash());
    }

    @Test
    public void setData() {
        thirdNode.setData("uwu");
        Assertions.assertEquals("uwu", thirdNode.getData());
    }


    @Test
    public void testIsValidAfterSettingHash() {
        Block forthNode = new Block(4, "", "forth");
        forthNode.setHash("50000");
        Assertions.assertTrue(forthNode.isValid());
        forthNode.setHash("00005");
        Assertions.assertFalse(forthNode.isValid());
    }

    @Test
    void testMineWithOtherDifficulty() {
        firstNode.mineBlock(5);
        Assertions.assertEquals("00000",  firstNode.getHash().substring(firstNode.getHash().length()-5));
    }
}
