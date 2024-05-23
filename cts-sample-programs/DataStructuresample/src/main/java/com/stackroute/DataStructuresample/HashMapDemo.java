package com.stackroute.DataStructuresample;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapDemo {


  public static class HashMap<K, V> {

    private class HMNode {
      K key;
      V value;

      public HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size;
    private LinkedList<HMNode>[] buckets; //

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int size) {
      buckets = new LinkedList[size];
      for(int bi=0;bi<buckets.length;bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) {
      int bi = hashFn(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1) {
        // update
        HMNode node = buckets[bi].get(di);
        node.value = value;
      } else {
        // insert
        HMNode node = new HMNode(key, value);
        buckets[bi].add(node);
        size++;
      }



    }

    private int hashFn(K key) {
      int hc = key.hashCode();
      return Math.abs(hc) % buckets.length;
    }

    private int getIndexWithinBucket(K key, int bi) {
      int di = 0;
      for(HMNode node: buckets[bi]) {
        if(node.key.equals(key)) {
          return di;
        }
        di++;
      }
      return -1;
    }

    public boolean containsKey(K key) {
      int bi = hashFn(key);
      int di = getIndexWithinBucket(key, bi);
      if(di != -1) {
        return true;
      } else {
        return false;
      }
    }

    public V get(K key) {
      int bi = hashFn(key);
      int di = getIndexWithinBucket(key, bi);
      if(di != -1) {
        HMNode node = buckets[bi].get(di);
        return node.value;
      } else {
        return null;
      }
    }

    public V remove(K key) {
      int bi = hashFn(key);
      int di = getIndexWithinBucket(key, bi);
      if(di != -1) {
        HMNode node = buckets[bi].remove(di);
        size--;
        return node.value;
      } else {
        return null;
      }
    }

    public int size() {
      return size;
    }

    public ArrayList<K> keySet() {
  	  ArrayList<K> keys = new ArrayList<>();

  	  for(int i=0;i<buckets.length;i++) {
  	    for(HMNode node: buckets[i]) {
  	      keys.add(node.key);
  	    }
  	  }

  	  return keys;
  	}
    //keySet

  }




  public static void main(String[] args) {



  }
}