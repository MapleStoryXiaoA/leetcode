package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 设计和实现一个  LRU (最近最少使用) 缓存机制
 * <p>
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P146LRU缓存机制 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1); // 缓存是 {1=1}

        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}

        // 返回 1
        System.out.println(lRUCache.get(1));

        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}

        // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}

        // 返回 -1 (未找到)
        System.out.println(lRUCache.get(1));

        // 返回 3
        System.out.println(lRUCache.get(3));

        // 返回 4
        System.out.println(lRUCache.get(4));
    }

    static class LRUCache {

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
