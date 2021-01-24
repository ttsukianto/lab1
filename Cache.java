import java.util.LinkedList;

public class Cache {
    private LinkedList cache1;
    private LinkedList cache2;
    private int cache1Refs;
    private int cache2Refs;
    private int cache1Hits;
    private int cache2Hits;
    private int cache1Size;
    private int cache2Size;

    public Cache(int size) {
        cache1 = new LinkedList();
        cache1Refs = 0;
        cache1Hits = 0;
        cache1Size = size;
    }

    public Cache(int size1, int size2) {
        cache1 = new LinkedList();
        cache1Refs = 0;
        cache1Hits = 0;
        cache1Size = size1;
        cache2 = new LinkedList();
        cache2Refs = 0;
        cache2Hits = 0;
        cache2Size = size2;
    }

    public Object getObject(Object o, boolean isCache2) {
        cache1Refs++;
        if(cache1.contains(o)) {
            cache1Hits++;
            cache1.remove(o);
            cache1.addFirst(o);
            if(isCache2) {
                cache2.remove(o);
                cache2.addFirst(o);
            }
        }
        else {
            if(isCache2) {
                cache2Refs++;
                if(cache2.contains(o)) {
                    cache2Hits++;
                    cache2.remove(o);
                    cache2.addFirst(o);
                    addObject(o, true);
                }
                else {
                    addObject(o, false);
                }
            }
        }
        return o;
    }

    public void addObject(Object o, boolean isHitCache2) {
        if(cache1.size() == cache1Size) {
            cache1.removeLast();
        }
        cache1.addFirst(o);
        if(!isHitCache2) {
            if(cache2.size() == cache2Size) {
                cache2.removeLast();
            }
            cache2.addFirst(o);
        }
    }

    public void removeObject(Object o, boolean isCache2) {
        cache1.remove(o);
        if(isCache2) {
            cache2.remove(o);
        }
    }

    public void clearCache(boolean isCache2) {
        cache1 = new LinkedList();
        if(isCache2) {
            cache2 = new LinkedList();
        }
    }

    public int getRefs(int cacheNum) {
        if(cacheNum == 1) {
            return cache1Refs;
        }
        else {
            return cache2Refs;
        }
    }

    public int getHits(int cacheNum) {
        if(cacheNum == 1) {
            return cache1Hits;
        }
        else {
            return cache2Hits;
        }
    }
}