package org.espire.cache;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCacheUsingHashSet cache = new LRUCacheUsingHashSet(4);

        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);

        cache.display();


    }

}
