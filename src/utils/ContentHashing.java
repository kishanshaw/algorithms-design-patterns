package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class ContentHashing {
    private int replicasCount;
    private TreeMap<String, String> ringMap;
    private MessageDigest messageDigest;

    public ContentHashing() throws NoSuchAlgorithmException {
        ringMap = new TreeMap<>();
        messageDigest = MessageDigest.getInstance("MD5");
        replicasCount = 3;
    }

    public ContentHashing(int replicasCount, TreeMap<String, String> ringMap, MessageDigest messageDigest) {
        this.replicasCount = replicasCount;
        this.ringMap = ringMap;
        this.messageDigest = messageDigest;
    }

    public String getHash(String key) {
        byte[] digest = messageDigest.digest(key.getBytes());
        BigInteger bigInteger = new BigInteger(1, digest);
        return bigInteger.toString(16);
    }

    public void addServer(String server) {
        for (int i = 0; i < replicasCount; i++) {
            String hash = getHash(server + i);
            ringMap.put(hash, server);
        }
    }

    public void removeServer(String server) {
        for (int i = 0; i < replicasCount; i++) {
            String hash = getHash(server + i);
            ringMap.remove(hash);
        }
    }

    public String getServer(String key) {
        if (ringMap.isEmpty()) {
            return null;
        }
        String hash = getHash(key);
        if (!ringMap.containsKey(hash)) {
            SortedMap<String, String> sortedMap = ringMap.tailMap(key);
            if (sortedMap.isEmpty()) {
                hash = ringMap.firstKey();
            } else {
                hash = sortedMap.firstKey();
            }

        }
        return ringMap.get(hash);
    }
}
