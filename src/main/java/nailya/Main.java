package nailya;


public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        int i = 0;
        while (true){
            blockchain.addBlock(new Block(i, blockchain.getLatestBlock().getHash(),
                    "This is the "+i+" node"));
            System.out.println(blockchain.getLatestBlock().getData());
            System.out.println("Is valid? " + blockchain.isChainValid());
            i++;
        }
    }
}



