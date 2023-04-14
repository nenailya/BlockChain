package nailya;


    public class Main {
        public static void main(String[] args) {
            Blockchain blockchain = new Blockchain();
            blockchain.addBlock(new Block(1, blockchain.getLatestBlock().getHash(),
                    "This is the second block"));
            blockchain.addBlock(new Block(2, blockchain.getLatestBlock().getHash(),
                    "This is the third block"));

            System.out.println("Is chain valid? " + blockchain.isChainValid());

            blockchain.getLatestBlock().setData("This is a tampered block");
            System.out.println("Is chain valid? " + blockchain.isChainValid());
        }
    }



