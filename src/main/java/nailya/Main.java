package nailya;


public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.addBlock(new Block(0, blockchain.getLatestBlock().getHash(),
                "This is the first node"));
        System.out.println(blockchain.getLatestBlock().getData());
        System.out.println("Is valid? " + blockchain.isChainValid());

        blockchain.addBlock(new Block(1, blockchain.getLatestBlock().getHash(),
                "This is the second node"));
        System.out.println(blockchain.getLatestBlock().getData());
        System.out.println("Is valid? " + blockchain.isChainValid());

        blockchain.addBlock(new Block(2, blockchain.getLatestBlock().getHash(),
                "This is the third node"));
        System.out.println(blockchain.getLatestBlock().getData());
        System.out.println("Is valid? " + blockchain.isChainValid());
    }
}



