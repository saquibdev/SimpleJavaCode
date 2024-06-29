import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    private final SortedMap<Integer, String> hashRing = new TreeMap<>();

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing();

        //Lets add two servers
        consistentHashing.addServer("SERVER1");
        consistentHashing.addServer("SERVER2");
        consistentHashing.addServer("SERVER3");

        //Now Let us Place few keys
        String s1 = consistentHashing.getServerForKey("Key1");
        String s2 = consistentHashing.getServerForKey("Key2");
        String s3 = consistentHashing.getServerForKey("A1");
        String s4 = consistentHashing.getServerForKey("cbejhdfiuehwfjk");
        System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", s3 = " + s3   +   ", s4= " + s4);
    }

    public void addServer(String serverName) {
        int numVirtualNodes = 100; // Number of virtual nodes per server
        for (int i = 0; i < numVirtualNodes; i++) {
            String virtualNodeName = serverName + "-" + i;
            int hash = hashFunction(virtualNodeName);
            hashRing.put(hash, serverName);
        }
    }

    public String getServerForKey(String key) {
        int hash = hashFunction(key);
        // Find the first server clockwise on the ring
        SortedMap<Integer, String> tailMap = hashRing.tailMap(hash);
        hash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        return hashRing.get(hash);
    }

    private int hashFunction(String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md5.digest(key.getBytes());
            return ((hashBytes[0] & 0xFF) << 24)
                    | ((hashBytes[1] & 0xFF) << 16)
                    | ((hashBytes[2] & 0xFF) << 8)
                    | (hashBytes[3] & 0xFF);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 hash function not found", e);
        }
    }
}
